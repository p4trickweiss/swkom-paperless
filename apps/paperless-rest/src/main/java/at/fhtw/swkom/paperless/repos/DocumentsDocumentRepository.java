package at.fhtw.swkom.paperless.repos;

import at.fhtw.swkom.paperless.domain.DocumentsDocument;
import at.fhtw.swkom.paperless.domain.DocumentsTag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface DocumentsDocumentRepository extends JpaRepository<DocumentsDocument, Integer> {
    Optional<DocumentsDocument> findByTitle(String name);

}
