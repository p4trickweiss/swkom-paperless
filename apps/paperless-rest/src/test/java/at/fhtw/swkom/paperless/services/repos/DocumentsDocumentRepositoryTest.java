package at.fhtw.swkom.paperless.services.repos;

import at.fhtw.swkom.paperless.data.domain.DocumentsDocument;
import at.fhtw.swkom.paperless.data.repos.DocumentsDocumentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class DocumentsDocumentRepositoryTest {
    @Mock
    private DocumentsDocumentRepository repository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindByDocumentTitle() {
        // Arrange
        DocumentsDocument mockEntity = new DocumentsDocument();
        mockEntity.setTitle("Title");
        when(repository.findByTitle("Title")).thenReturn(Optional.of(mockEntity));

        // Act
        Optional<DocumentsDocument> result = repository.findByTitle("Title");

        // Assert
        assertTrue(result.isPresent());
        assertEquals(mockEntity.getId(), result.get().getId());
    }




}
