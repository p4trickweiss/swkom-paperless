package at.technikumwien.swkom.paperlessrest.data.repos;

import at.technikumwien.swkom.paperlessrest.data.domain.DocumentsDocument;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface DocumentsDocumentRepository extends JpaRepository<DocumentsDocument, Integer> {
    Optional<DocumentsDocument> findByTitle(String name);

    Optional<DocumentsDocument> findById(Integer Id);

    List<DocumentsDocument> findByIdIn(List<Integer> ids);

}
