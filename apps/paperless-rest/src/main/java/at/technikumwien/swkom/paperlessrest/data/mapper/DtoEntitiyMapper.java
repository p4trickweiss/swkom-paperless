package at.technikumwien.swkom.paperlessrest.data.mapper;

import at.technikumwien.swkom.paperlessrest.data.domain.*;
import at.technikumwien.swkom.paperlessrest.data.dto.Correspondent;
import at.technikumwien.swkom.paperlessrest.data.dto.DocTag;
import at.technikumwien.swkom.paperlessrest.data.dto.Document;
import at.technikumwien.swkom.paperlessrest.data.dto.DocumentType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.openapitools.jackson.nullable.JsonNullable;

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