import {useEffect, useState} from "react";
import {DocumentService} from "./services/DocumentService.ts";
import {IDocumentDTO} from "./dtos/response/document/IDocumentDTO.ts";
import {IDefaultExceptionResponse} from "./dtos/response/exception/IDefaultExceptionResponse.ts";
import {AxiosError} from "axios";
import {useForm} from "react-hook-form";

export const App = () => {
  const documentId = window.location.pathname.slice(1);
  const [document, setDocument] = useState<IDocumentDTO>();
  const {register, watch, reset,} = useForm<IDocumentDTO>();

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
        console.log("Update document");
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
    const timer = setInterval(() => {
      updateDocument();
    }, 1000);

    return () => {
      clearInterval(timer);
    }
  }, [document]);

  return (
      <div>
        <form>
          <input type={"text"} {...register("title")}/>
          <textarea {...register("content")}/>
        </form>
      </div>
  )
}