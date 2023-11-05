package at.fhtw.swkom.paperless.services.mapper;

import at.fhtw.swkom.paperless.domain.DocumentsDocument;
import at.fhtw.swkom.paperless.domain.DocumentsDocumenttype;
import at.fhtw.swkom.paperless.mapper.DtoEntitiyMapperImpl;
import at.fhtw.swkom.paperless.services.dto.DocumentType;
import io.swagger.v3.core.util.Json;
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
    }
}