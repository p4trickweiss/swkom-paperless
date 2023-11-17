package at.fhtw.swkom.paperless.data.repos;

import at.fhtw.swkom.paperless.data.domain.DocumentsDocument;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface DocumentsDocumentRepository extends JpaRepository<DocumentsDocument, Integer> {
    Optional<DocumentsDocument> findByTitle(String name);

}
