interface InvalidArgumentErrorDto {
  field: string
  message: string
}

export interface IDefaultExceptionResponse {
  message: string
  statusCode: number
  statusName: string
  fieldsErrors?: InvalidArgumentErrorDto[]
}