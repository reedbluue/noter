import {useEffect, useState} from "react";
import {AxiosError} from "axios";
import {Controller, useForm} from "react-hook-form";
import {IDocumentDTO} from "../dtos/response/document/IDocumentDTO.ts";
import {DocumentService} from "../services/DocumentService.ts";
import {IDefaultExceptionResponse} from "../dtos/response/exception/IDefaultExceptionResponse.ts";
import {useSubscription} from "react-stomp-hooks";
import toast from "react-hot-toast";
import MDEditor from '@uiw/react-md-editor';
import rehypeSanitize from "rehype-sanitize";

export const DocumentPage = () => {
  const documentId = window.location.pathname.slice(1);
  const [document, setDocument] = useState<IDocumentDTO>();
  const {register, watch, reset, control} = useForm<IDocumentDTO>();
  const {title, content} = watch();

  const getDocument = async () => {
    if (documentId) {
      try {
        const resDocument = await DocumentService.get(documentId);
        setDocument(resDocument.data);
        reset(resDocument.data);
      } catch (e) {
        const error = e as IDefaultExceptionResponse;
        console.log(error.message);
      }
    }
  }

  const updateDocument = async () => {
    const formDocument = watch();
    if (document && (document.content
        != formDocument.content
        || document.title
        != formDocument.title)) {
      try {
        const formDocument = watch();
        const resDocument = await DocumentService.update({
          id: formDocument.id,
          title: formDocument.title,
          content: formDocument.content,
        });
        setDocument(resDocument.data);
        toast.success("Document updated");
      } catch (e) {
        const error = e as AxiosError<IDefaultExceptionResponse>;
        console.log(error.message);
      }
    }
  }

  useEffect(() => {
    getDocument();
  }, []);

  useEffect(() => {
    const timer = setTimeout(() => {
      updateDocument();
    }, 1000);

    return () => {
      clearTimeout(timer);
    }
  }, [title, content]);

  useSubscription(`/topic/doc-update-${documentId}`, getDocument);

  return (
      <div>
        <form>
          <input type={"text"} {...register("title")}/>
          <textarea {...register("content")}/>
          <Controller control={control} name={"content"} render={
            ({field}) => (
                <MDEditor {...field}
                          previewOptions={{
                            rehypePlugins: [[rehypeSanitize]],
                          }}
                />
            )
          }/>
        </form>
      </div>
  )
}