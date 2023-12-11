package at.technikumwien.swkom.paperlessrest.services.mapper;

import at.technikumwien.swkom.paperlessrest.data.domain.DocumentsDocumenttype;
import at.technikumwien.swkom.paperlessrest.data.dto.DocumentType;
import at.technikumwien.swkom.paperlessrest.data.mapper.DtoEntitiyMapperImpl;
import org.junit.jupiter.api.Test;
import org.openapitools.jackson.nullable.JsonNullable;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DocumentTypeMapperTest {

    //attributes
    Integer id = 1;
    Integer documentCount = 3;
    String name = "Lion";
    String match = "Paper";
    Boolean isInsensitive = false;
    String slug = "Slug";
    Integer matchingAlgorithm = 4;
    @Test
    void entityToDto() {

        // expected dto
        DocumentType expectedDocumentType = new DocumentType();
        expectedDocumentType.setId(Long.valueOf(id));
        //expectedDocumentType.setDocumentCount(Long.valueOf(documentCount));
        expectedDocumentType.setName(JsonNullable.of(name));
        expectedDocumentType.setMatch(JsonNullable.of(match));
        expectedDocumentType.setIsInsensitive(isInsensitive);
        //expectedDocumentType.setSlug(JsonNullable.of(slug));
        expectedDocumentType.setMatchingAlgorithm(Long.valueOf(matchingAlgorithm));

        // entity
        DocumentsDocumenttype documentTypeEntityInput = new DocumentsDocumenttype();
        documentTypeEntityInput.setId(id);
        documentTypeEntityInput.setName(name);
        documentTypeEntityInput.setMatch(match);
        documentTypeEntityInput.setMatchingAlgorithm(matchingAlgorithm);
        documentTypeEntityInput.setIsInsensitive(isInsensitive);

        // test entity -> dto
        DtoEntitiyMapperImpl documentsTagImpl = new DtoEntitiyMapperImpl();
        DocumentType documentTypeDtoOutput = documentsTagImpl.entityToDto(documentTypeEntityInput);

        System.out.println("Expected -----------------");
        System.out.println(expectedDocumentType);

        System.out.println("Actual -----------------");
        System.out.println(documentTypeDtoOutput);

        assertEquals(expectedDocumentType, documentTypeDtoOutput);
    }


    @Test
    void dtoToEntity() {

        // expected entity
        DocumentsDocumenttype expectedDocumentTypeEntity = new DocumentsDocumenttype();
        expectedDocumentTypeEntity.setId(id);
        expectedDocumentTypeEntity.setName(name);
        expectedDocumentTypeEntity.setMatch(match);
        expectedDocumentTypeEntity.setMatchingAlgorithm(matchingAlgorithm);
        expectedDocumentTypeEntity.setIsInsensitive(isInsensitive);

        // dto
        DocumentType documentTypeDtoInput = new DocumentType();
        documentTypeDtoInput.setId(Long.valueOf(id));
        //documentTypeDtoInput.setDocumentCount(Long.valueOf(documentCount));
        documentTypeDtoInput.setName(JsonNullable.of(name));
        documentTypeDtoInput.setMatch(JsonNullable.of(match));
        documentTypeDtoInput.setIsInsensitive(isInsensitive);
        //documentTypeDtoInput.setSlug(JsonNullable.of(slug));
        documentTypeDtoInput.setMatchingAlgorithm(Long.valueOf(matchingAlgorithm));

        // test dto -> entity(DocumentsDocumets..)
        DtoEntitiyMapperImpl documentsTagImpl = new DtoEntitiyMapperImpl();
        DocumentsDocumenttype documentTypeEntityOutput = documentsTagImpl.dtoToEntity(documentTypeDtoInput);

        System.out.println("Expected -----------------");
        System.out.println(expectedDocumentTypeEntity);

        System.out.println("Actual -----------------");
        System.out.println(documentTypeEntityOutput);

        assertEquals(expectedDocumentTypeEntity.toString(), documentTypeEntityOutput.toString());

    }
}