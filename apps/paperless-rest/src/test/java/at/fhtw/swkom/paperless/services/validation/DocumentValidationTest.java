package at.fhtw.swkom.paperless.services.validation;

import at.fhtw.swkom.paperless.domain.DocumentsDocument;
import at.fhtw.swkom.paperless.domain.DocumentsDocumentTags;
import at.fhtw.swkom.paperless.repos.DocumentsDocumentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class DocumentValidationTest {

}