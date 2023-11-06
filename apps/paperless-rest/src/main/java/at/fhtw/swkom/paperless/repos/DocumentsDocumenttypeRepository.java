package at.fhtw.swkom.paperless.repos;

import at.fhtw.swkom.paperless.domain.DocumentsDocumenttype;
import at.fhtw.swkom.paperless.domain.DocumentsTag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface DocumentsDocumenttypeRepository extends JpaRepository<DocumentsDocumenttype, Integer> {
    Optional<DocumentsDocumenttype> findByName(String name);
}
