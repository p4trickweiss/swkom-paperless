package at.fhtw.swkom.paperless.repos;

import at.fhtw.swkom.paperless.domain.DjangoAdminLog;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DjangoAdminLogRepository extends JpaRepository<DjangoAdminLog, Integer> {
}
