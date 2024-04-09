import {useEffect, useState} from "react";
import {Controller, useForm} from "react-hook-form";
import {IDocumentDTO} from "../dtos/response/document/IDocumentDTO.ts";
import {DocumentService} from "../services/DocumentService.ts";
import {IDefaultExceptionResponse} from "../dtos/response/exception/IDefaultExceptionResponse.ts";
import {useSubscription} from "react-stomp-hooks";
import toast from "react-hot-toast";
import MarkdownEditor from "@uiw/react-markdown-editor";
import {Edit, Type} from "react-feather";
import {useParams} from "react-router-dom";

export const DocumentPage = () => {
  const {documentId} = useParams();
  const [document, setDocument] = useState<IDocumentDTO>();
  const {watch, reset, control} = useForm<IDocumentDTO>();
  const {content} = watch();
  const [viewMode, setViewMode] = useState(true);

  const getDocument = async () => {
    if (documentId) {
      try {
        const resDocument = await DocumentService.get(documentId);
        setDocument(resDocument.data);
        reset(resDocument.data);
        window.document.title = "Noter - " + resDocument.data.id;
      } catch (e) {
        const error = e as IDefaultExceptionResponse;
        console.log(error.message);
      }
    }
  }

  const updateDocument = async () => {
    const formDocument = watch();
    if (document && (document.content
        != formDocument.content)) {
      try {
        const formDocument = watch();
        const resDocument = await DocumentService.update({
          id: formDocument.id,
          content: formDocument.content,
        });
        setDocument(resDocument.data);
        toast.success("Document saved");
      } catch (e) {
        toast.error("Error saving document");
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
  }, [content]);

  useSubscription(`/topic/doc-update-${documentId}`, getDocument);

  return (
      <div className={"h-full w-full flex flex-col gap-5"}>
        {!viewMode &&
            <Controller name={"content"} control={control} render={({field}) => (
                <MarkdownEditor {...field} className={"flex-grow"}
                                toolbarsMode={["preview", {
                                  name: "view",
                                  icon: <Type size={16}/>,
                                  execute: () => setViewMode(true)
                                }]}/>
            )}/>
        }
        {viewMode &&
            <div className={"flex-grow flex flex-col"}>
              <button className="btn btn-circle fixed bottom-5 right-5"
                      onClick={() => setViewMode(false)}>
                <Edit size={20}/>
              </button>
              <MarkdownEditor.Markdown source={content} className={"flex-grow"}/>
            </div>
        }
      </div>
  )
}