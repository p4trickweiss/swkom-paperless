package at.fhtw.swkom.paperless.data.repos;

import at.fhtw.swkom.paperless.data.domain.PaperlessMailProcessedmail;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PaperlessMailProcessedmailRepository extends JpaRepository<PaperlessMailProcessedmail, Integer> {
}
