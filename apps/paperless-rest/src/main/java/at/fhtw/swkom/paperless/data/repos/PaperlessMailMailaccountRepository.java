package at.fhtw.swkom.paperless.data.repos;

import at.fhtw.swkom.paperless.data.domain.PaperlessMailMailaccount;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PaperlessMailMailaccountRepository extends JpaRepository<PaperlessMailMailaccount, Integer> {
}
