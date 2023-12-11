package at.technikumwien.swkom.paperlessrest.data.repos;

import at.technikumwien.swkom.paperlessrest.data.domain.PaperlessMailProcessedmail;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PaperlessMailProcessedmailRepository extends JpaRepository<PaperlessMailProcessedmail, Integer> {
}
