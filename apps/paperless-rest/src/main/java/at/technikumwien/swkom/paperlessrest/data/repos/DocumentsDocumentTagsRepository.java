package at.technikumwien.swkom.paperlessrest.data.repos;

import at.technikumwien.swkom.paperlessrest.data.domain.DocumentsDocumentTags;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DocumentsDocumentTagsRepository extends JpaRepository<DocumentsDocumentTags, Integer> {
}
