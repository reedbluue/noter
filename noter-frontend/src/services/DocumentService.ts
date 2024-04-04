import {IDocumentDTO} from "../dtos/response/document/IDocumentDTO.ts";
import {IDocumentUpdateDTO} from "../dtos/request/document/IDocumentUpdateDTO.ts";
import {baseUrl} from "../configs/AxiosConfig.ts";

export abstract class DocumentService {
  public static get(id: string) {
    return baseUrl.get<IDocumentDTO>("/api/v1/document/" + id);
  }

  public static create() {
    return baseUrl.post<IDocumentDTO>("/api/v1/document");
  }

  public static update(documentUpdateDTO: IDocumentUpdateDTO) {
    return baseUrl.put<IDocumentDTO>("/api/v1/document", documentUpdateDTO);
  }
}