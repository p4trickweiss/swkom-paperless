package at.fhtw.swkom.paperless.services.validation;

import at.fhtw.swkom.paperless.domain.DocumentsDocument;
import at.fhtw.swkom.paperless.domain.DocumentsDocumentTags;
import at.fhtw.swkom.paperless.repos.DocumentsDocumentRepository;
import jakarta.validation.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.util.AssertionErrors.assertFalse;

@ExtendWith(MockitoExtension.class)
public class DocumentValidationTest {
    @Mock
    private DocumentsDocumentRepository yourService;

    private Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @Test
    public void whenNullValueInNonNullColumn_thenValidationFails() {

        DocumentsDocument entity = new DocumentsDocument();

        Set<ConstraintViolation<DocumentsDocument>> violations = validator.validate(entity);

        System.out.printf(violations.toString());

        assertFalse("No violations found for null field that should have failed validation", violations.isEmpty());
    }
}