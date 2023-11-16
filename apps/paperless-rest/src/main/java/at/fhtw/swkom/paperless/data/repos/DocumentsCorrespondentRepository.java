package at.fhtw.swkom.paperless.data.repos;

import at.fhtw.swkom.paperless.data.domain.DocumentsCorrespondent;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DocumentsCorrespondentRepository extends JpaRepository<DocumentsCorrespondent, Integer> {
}
