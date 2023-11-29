package at.technikumwien.swkom.paperlessrest.services.validation;

import at.technikumwien.swkom.paperlessrest.data.domain.DocumentsDocument;
import at.technikumwien.swkom.paperlessrest.data.repos.DocumentsDocumentRepository;
import jakarta.validation.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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