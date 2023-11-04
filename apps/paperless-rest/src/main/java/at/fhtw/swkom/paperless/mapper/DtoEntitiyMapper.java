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
public interface DtoEntitiyMapper {
    Document entityToDto(DocumentsDocument documentsDocument);
    DocumentsDocument dtoToEntity(Document documentDto);
}
