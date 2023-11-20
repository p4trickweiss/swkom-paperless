package at.fhtw.swkom.paperless.data.repos;

import at.fhtw.swkom.paperless.data.domain.DocumentsNote;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DocumentsNoteRepository extends JpaRepository<DocumentsNote, Integer> {
}
