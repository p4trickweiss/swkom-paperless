package at.fhtw.swkom.paperless.data.repos;

import at.fhtw.swkom.paperless.data.domain.DocumentsDocumenttype;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface DocumentsDocumenttypeRepository extends JpaRepository<DocumentsDocumenttype, Integer> {
    Optional<DocumentsDocumenttype> findByName(String name);
}
