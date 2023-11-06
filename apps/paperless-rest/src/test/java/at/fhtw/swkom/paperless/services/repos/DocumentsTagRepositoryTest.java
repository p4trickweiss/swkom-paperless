package at.fhtw.swkom.paperless.services.repos;

import at.fhtw.swkom.paperless.domain.DocumentsTag;
import at.fhtw.swkom.paperless.repos.DocumentsTagRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;


public class DocumentsTagRepositoryTest {
    @Mock
    private DocumentsTagRepository repository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindByTagName() {
        // Arrange
        DocumentsTag mockEntity = new DocumentsTag();
        mockEntity.setName("Name");
        when(repository.findByName("Name")).thenReturn(Optional.of(mockEntity));

        // Act
        Optional<DocumentsTag> result = repository.findByName("Name");

        // Assert
        assertTrue(result.isPresent());
        assertEquals(mockEntity.getId(), result.get().getId());
    }
}
