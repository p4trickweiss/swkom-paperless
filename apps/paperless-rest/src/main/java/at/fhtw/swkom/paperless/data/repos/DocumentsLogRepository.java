package at.fhtw.swkom.paperless.data.repos;

import at.fhtw.swkom.paperless.data.domain.DocumentsLog;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DocumentsLogRepository extends JpaRepository<DocumentsLog, Integer> {
}
