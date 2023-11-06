package at.fhtw.swkom.paperless.services.mapper;

import at.fhtw.swkom.paperless.domain.DocumentsCorrespondent;
import at.fhtw.swkom.paperless.domain.DocumentsTag;
import at.fhtw.swkom.paperless.mapper.DtoEntitiyMapperImpl;
import at.fhtw.swkom.paperless.services.dto.Correspondent;
import io.swagger.v3.core.util.Json;
import org.junit.jupiter.api.Test;
import org.openapitools.jackson.nullable.JsonNullable;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import static org.junit.jupiter.api.Assertions.*;

class DtoEntitiyMapperTest {

    //attributes
    Integer id = 1;
    String name = "Name";
    OffsetDateTime lastCorrespondance = OffsetDateTime.of(LocalDate.of(2030, 1, 1), LocalTime.of(3, 0, 0), ZoneOffset.ofHours(1));
    String match = "Match";
    String slug = "Slug";
    Integer documentCount = 1;

    Boolean isInsensitive = false;
    Integer matchingAlgorithmn = 2;
    @Test
    void entityToDto() {
        // expected Dto (Correspondent)
        Correspondent expectedCorrespondent = new Correspondent();
        expectedCorrespondent.setId(Long.valueOf(id));
        //expectedCorrespondent.setLastCorrespondence(lastCorrespondance);
        expectedCorrespondent.setName(JsonNullable.of(name));
        expectedCorrespondent.setMatch(JsonNullable.of(match));
        //expectedCorrespondent.setSlug(JsonNullable.of(slug));
        //expectedCorrespondent.setDocumentCount(Long.valueOf(documentCount));
        expectedCorrespondent.setIsInsensitive(isInsensitive);
        expectedCorrespondent.setMatchingAlgorithm(Long.valueOf(matchingAlgorithmn));

        // input entity (DocumentCorrestpondent)
        DocumentsCorrespondent correspondentEntityInput = new DocumentsCorrespondent();
        correspondentEntityInput.setName(name);
        correspondentEntityInput.setMatch(match);
        correspondentEntityInput.setId(id);
        correspondentEntityInput.setIsInsensitive(isInsensitive);
        correspondentEntityInput.setMatchingAlgorithm(matchingAlgorithmn);

        // test
        DtoEntitiyMapperImpl documentsTagImpl = new DtoEntitiyMapperImpl();
        Correspondent correspondentDtoOutput = documentsTagImpl.entityToDto(correspondentEntityInput);

        System.out.println("Expected -----------------");
        System.out.println(expectedCorrespondent);

        System.out.println("Actual -----------------");
        System.out.println(correspondentDtoOutput);

        assertEquals(expectedCorrespondent, correspondentDtoOutput);
    }

    @Test
    void dtoToEntity() {
        // expected Entity(Document Correspondent)
        DocumentsCorrespondent expectedCorrespondent = new DocumentsCorrespondent();
        expectedCorrespondent.setName(name);
        expectedCorrespondent.setMatch(match);
        expectedCorrespondent.setId(id);
        expectedCorrespondent.setIsInsensitive(isInsensitive);
        expectedCorrespondent.setMatchingAlgorithm(matchingAlgorithmn);

        // input dto
        Correspondent correspondentDtoInput = new Correspondent();
        correspondentDtoInput.setId(Long.valueOf(id));
        //correspondentDtoInput.setLastCorrespondence(lastCorrespondance);
        correspondentDtoInput.setName(JsonNullable.of(name));
        correspondentDtoInput.setMatch(JsonNullable.of(match));
        //correspondentDtoInput.setSlug(JsonNullable.of(slug));
        //correspondentDtoInput.setDocumentCount(Long.valueOf(documentCount));
        correspondentDtoInput.setIsInsensitive(isInsensitive);
        correspondentDtoInput.setMatchingAlgorithm(Long.valueOf(matchingAlgorithmn));

        DtoEntitiyMapperImpl documentsTagImpl = new DtoEntitiyMapperImpl();
        DocumentsCorrespondent correspondentEntityOutput = documentsTagImpl.dtoToEntity(correspondentDtoInput);

        System.out.println("Expected -----------------");
        System.out.println(expectedCorrespondent);

        System.out.println("Actual -----------------");
        System.out.println(correspondentEntityOutput);

        assertEquals(expectedCorrespondent.toString(), correspondentEntityOutput.toString());
    }
}