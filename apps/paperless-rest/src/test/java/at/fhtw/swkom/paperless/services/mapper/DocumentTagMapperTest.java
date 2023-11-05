package at.fhtw.swkom.paperless.services.mapper;

import at.fhtw.swkom.paperless.domain.DocumentsTag;
import at.fhtw.swkom.paperless.mapper.DtoEntitiyMapperImpl;
import at.fhtw.swkom.paperless.services.dto.DocTag;
import at.fhtw.swkom.paperless.services.dto.Document;
import org.junit.jupiter.api.Test;
import org.openapitools.jackson.nullable.JsonNullable;

import static org.junit.jupiter.api.Assertions.*;

class DocumentTagMapperTest {

    //attributes
    Integer id = 1;
    Boolean isInboxTag = true;
    String match = "Match";
    String color = "yellow";
    String name = "Obi Wan";
    Boolean isInsensitive = true;
    @Test
    void entityToDto() {

        //set Entity
        DocumentsTag documentsTag = new DocumentsTag();
        documentsTag.setId(id);
        documentsTag.setIsInboxTag(isInboxTag);
        documentsTag.setMatch(match);
        documentsTag.setColor(color);
        documentsTag.setName(name);
        documentsTag.setIsInsensitive(isInsensitive);

        //set testDto
        DocTag expectedDocTag = new DocTag();
        expectedDocTag.setId(Long.valueOf(id));
        expectedDocTag.setIsInboxTag(true);
        expectedDocTag.setMatch(JsonNullable.of(match));
        expectedDocTag.setColor(JsonNullable.of(color));
        expectedDocTag.setName(JsonNullable.of(name));
        expectedDocTag.setIsInsensitive(isInsensitive);

        //test
        DtoEntitiyMapperImpl documentsTagImpl = new DtoEntitiyMapperImpl();
        DocTag documentsTagDto = documentsTagImpl.entityToDto(documentsTag);


        System.out.println("Expected -----------------");
        System.out.println(expectedDocTag);

        System.out.println("Actual -----------------");
        System.out.println(documentsTagDto);

        assertEquals(expectedDocTag, documentsTagDto);
    }

    @Test
    void dtoToEntity() {

        //set Dto
        DocTag docTag = new DocTag();
        docTag.setId(Long.valueOf(id));
        docTag.setIsInboxTag(true);
        docTag.setMatch(JsonNullable.of(match));
        docTag.setColor(JsonNullable.of(color));
        docTag.setName(JsonNullable.of(name));
        docTag.setIsInsensitive(isInsensitive);

        //set testEntity
        DocumentsTag expectedDocumentsTag = new DocumentsTag();
        expectedDocumentsTag.setId(id);
        expectedDocumentsTag.setIsInboxTag(isInboxTag);
        expectedDocumentsTag.setMatch(match);
        expectedDocumentsTag.setColor(color);
        expectedDocumentsTag.setName(name);
        expectedDocumentsTag.setIsInsensitive(isInsensitive);

        //test
        DtoEntitiyMapperImpl documentsTagImpl = new DtoEntitiyMapperImpl();
        DocumentsTag documentsTag = documentsTagImpl.dtoToEntity(docTag);

        System.out.println("Expected -----------------");
        System.out.println(expectedDocumentsTag);

        System.out.println("Actual -----------------");
        System.out.println(documentsTag);

        assertEquals(expectedDocumentsTag.toString(), documentsTag.toString());
    }
}