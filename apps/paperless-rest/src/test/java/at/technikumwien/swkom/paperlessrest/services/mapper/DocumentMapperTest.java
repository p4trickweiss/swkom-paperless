package at.technikumwien.swkom.paperlessrest.services.mapper;

import at.technikumwien.swkom.paperlessrest.data.domain.DocumentsDocument;
import at.technikumwien.swkom.paperlessrest.data.dto.Document;
import at.technikumwien.swkom.paperlessrest.data.mapper.DtoEntitiyMapperImpl;
import org.junit.jupiter.api.Test;
import org.openapitools.jackson.nullable.JsonNullable;

import java.time.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class DocumentMapperTest {

    @Test
    void testEntityToDto() {
        Integer id = 1;
        Integer correspondent = 2;
        Integer documentType = 3;
        Integer storagePath = 4;
        String title = "Title";
        String content = "Content";
        List<Integer> tags = List.of(100, 101);
        OffsetDateTime created = OffsetDateTime.of(LocalDate.of(2030, 1, 1), LocalTime.of(3, 0, 0), ZoneOffset.ofHours(1));
        OffsetDateTime createdDate = OffsetDateTime.of(LocalDate.of(2020, 1, 1), LocalTime.of(2, 0, 0), ZoneOffset.ofHours(1));
        OffsetDateTime modified = OffsetDateTime.of(LocalDate.of(2010, 1, 1), LocalTime.of(1, 0, 0), ZoneOffset.ofHours(1));
        OffsetDateTime added = OffsetDateTime.of(LocalDate.of(2000, 1, 1), LocalTime.of(0, 0, 0), ZoneOffset.ofHours(1));
        String archiveSerialNumber = "5";
        String originalFileName = "OriginalFileName";
        String archivedFileName = "ArchivedFileName";

        DocumentsDocument document = new DocumentsDocument();
        document.setId(id);
        document.setTitle(title);
        document.setContent(content);
        document.setCreated(created);
        document.setModified(modified);
        document.setAdded(added);
        document.setArchiveSerialNumber(Integer.valueOf(archiveSerialNumber));

        //when test starts both values are null
        document.setArchiveFilename(archivedFileName);
        document.setOriginalFileName(originalFileName);

        // TODO:
        /*
        String checksum
        String storageType
        String filename
        String mimeType
        String archiveChecksum
        DocumentsCorrespondent correspondent
        DocumentsDocumenttype documentType
        DocumentsStoragepath storagePath
        AuthUser owner
        Set<DocumentsNote> documentDocumentsNotes
        Set<DocumentsDocumentTags> documentDocumentsDocumentTagses
        */

        Document expectedDocumentDto = new Document();
        expectedDocumentDto.setId(id);
        expectedDocumentDto.setTitle(JsonNullable.of(title));
        expectedDocumentDto.setContent(JsonNullable.of(content));
        expectedDocumentDto.setCreated(created);
        expectedDocumentDto.setModified(modified);
        expectedDocumentDto.setAdded(added);
        expectedDocumentDto.setArchiveSerialNumber(JsonNullable.of(archiveSerialNumber));
        //when test starts both values are null
        expectedDocumentDto.setArchivedFileName(JsonNullable.of(archivedFileName));
        expectedDocumentDto.setOriginalFileName(JsonNullable.of(originalFileName));

        // TODO:
        /*
        expectedDocumentDto.setCorrespondent(JsonNullable.of(correspondent));
        expectedDocumentDto.setDocumentType(JsonNullable.of(documentType));
        expectedDocumentDto.setStoragePath(JsonNullable.of(storagePath));
        expectedDocumentDto.setTags(JsonNullable.of(tags));
        expectedDocumentDto.setCreatedDate(createdDate);
         */

        DtoEntitiyMapperImpl documentMapperImpl = new DtoEntitiyMapperImpl();
        Document documentDto = documentMapperImpl.entityToDto(document);

        System.out.println("Expected -----------------");
        System.out.println(expectedDocumentDto.toString());

        System.out.println("Actual -----------------");
        System.out.println(documentDto.toString());

        assertEquals(expectedDocumentDto.toString(), documentDto.toString().toString());
    }

    /*
    @Test
    void testDtoToEntity() {
        Integer id = 1;
        Integer correspondent = 2;
        Integer documentType = 3;
        Integer storagePath = 4;
        String title = "Title";
        String content = "Content";
        List<Integer> tags = List.of(100, 101);
        OffsetDateTime created = OffsetDateTime.of(LocalDate.of(2030, 1, 1), LocalTime.of(3, 0, 0), ZoneOffset.ofHours(1));
        OffsetDateTime createdDate = OffsetDateTime.of(LocalDate.of(2020, 1, 1), LocalTime.of(2, 0, 0), ZoneOffset.ofHours(1));
        OffsetDateTime modified = OffsetDateTime.of(LocalDate.of(2010, 1, 1), LocalTime.of(1, 0, 0), ZoneOffset.ofHours(1));
        OffsetDateTime added = OffsetDateTime.of(LocalDate.of(2000, 1, 1), LocalTime.of(0, 0, 0), ZoneOffset.ofHours(1));
        String archiveSerialNumber = "5";
        String originalFileName = "OriginalFileName";
        String archivedFileName = "ArchivedFileName";

        Document documentDto = new Document();
        documentDto.setId(id);
        documentDto.setTitle(JsonNullable.of(title));
        documentDto.setContent(JsonNullable.of(content));
        documentDto.setCreated(created);
        documentDto.setModified(modified);
        documentDto.setAdded(added);
        documentDto.setArchiveSerialNumber(JsonNullable.of(archiveSerialNumber));
        documentDto.setArchivedFileName(JsonNullable.of(archivedFileName));
        documentDto.setOriginalFileName(JsonNullable.of(originalFileName));


        DocumentsDocument expectedDocumentsDocument = new DocumentsDocument();
        expectedDocumentsDocument.setId(id);
        expectedDocumentsDocument.setTitle(title);
        expectedDocumentsDocument.setContent(content);
        expectedDocumentsDocument.setCreated(created);
        expectedDocumentsDocument.setModified(modified);
        expectedDocumentsDocument.setAdded(added);
        expectedDocumentsDocument.setArchiveSerialNumber(Integer.valueOf(archiveSerialNumber));
        expectedDocumentsDocument.setArchiveFilename(archivedFileName);
        expectedDocumentsDocument.setOriginalFileName(originalFileName);


        DtoEntitiyMapperImpl documentMapperImpl = new DtoEntitiyMapperImpl();
        DocumentsDocument documentsDocument = documentMapperImpl.dtoToEntity(documentDto);

        System.out.println("Expected -----------------");
        System.out.println(expectedDocumentsDocument);

        System.out.println("Actual -----------------");
        System.out.println(documentsDocument);

        assertEquals(expectedDocumentsDocument.toString(), documentsDocument.toString());

    }
    */
}
