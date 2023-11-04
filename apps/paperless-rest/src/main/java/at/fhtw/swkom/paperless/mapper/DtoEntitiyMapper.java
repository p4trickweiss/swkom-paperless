package at.fhtw.swkom.paperless.mapper;

import at.fhtw.swkom.paperless.domain.DocumentsCorrespondent;
import at.fhtw.swkom.paperless.domain.DocumentsDocument;
import at.fhtw.swkom.paperless.domain.DocumentsDocumenttype;
import at.fhtw.swkom.paperless.domain.DocumentsStoragepath;
import at.fhtw.swkom.paperless.services.dto.Document;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.openapitools.jackson.nullable.JsonNullable;

@Mapper
public interface DtoEntitiyMapper extends JsonNullableMapper {
    Document entityToDto(DocumentsDocument documentsDocument);
    DocumentsDocument dtoToEntity(Document documentDto);
    default JsonNullable<Integer> map(DocumentsCorrespondent documentsCorrespondent) {
        return documentsCorrespondent!=null ? JsonNullable.of(documentsCorrespondent.getId()) : JsonNullable.undefined();
    }
    default JsonNullable<Integer> map(DocumentsDocumenttype documentsDocumenttype) {
        return documentsDocumenttype!=null ? JsonNullable.of(documentsDocumenttype.getId()) : JsonNullable.undefined();
    }
    default JsonNullable<Integer> map(DocumentsStoragepath documentsStoragepath) {
        return documentsStoragepath!=null ? JsonNullable.of(documentsStoragepath.getId()) : JsonNullable.undefined();
    }
}