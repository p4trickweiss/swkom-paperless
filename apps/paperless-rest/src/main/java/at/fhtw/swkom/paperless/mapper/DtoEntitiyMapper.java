package at.fhtw.swkom.paperless.mapper;

import at.fhtw.swkom.paperless.domain.*;
import at.fhtw.swkom.paperless.repos.DocumentsCorrespondentRepository;
import at.fhtw.swkom.paperless.repos.DocumentsDocumenttypeRepository;
import at.fhtw.swkom.paperless.repos.DocumentsStoragepathRepository;
import at.fhtw.swkom.paperless.services.dto.Correspondent;
import at.fhtw.swkom.paperless.services.dto.DocTag;
import at.fhtw.swkom.paperless.services.dto.Document;
import at.fhtw.swkom.paperless.services.dto.DocumentType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.openapitools.jackson.nullable.JsonNullable;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper
public interface DtoEntitiyMapper extends JsonNullableMapper {

    @Mapping(target = "originalFileName", source = "originalFileName")
    @Mapping(target = "archivedFileName", source = "archiveFilename")
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

    //Document Tags
    DocTag entityToDto(DocumentsTag documentsTag);
    DocumentsTag dtoToEntity(DocTag docTag);

    //Document Types
    DocumentType entityToDto(DocumentsDocumenttype documentType);
    DocumentsDocumenttype dtoToEntity(DocumentType documentType);

    //Document Corespondent:
    //entity(DocumentCorrespondent) -> dto(Corespondent)
    //dto(Correspondent) -> entity(DocumentCorrespondent)
    Correspondent entityToDto(DocumentsCorrespondent correspondent);
    DocumentsCorrespondent dtoToEntity(Correspondent correspondent);


}