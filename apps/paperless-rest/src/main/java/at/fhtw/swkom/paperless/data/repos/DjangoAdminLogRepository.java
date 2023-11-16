package at.fhtw.swkom.paperless.data.repos;

import at.fhtw.swkom.paperless.data.domain.DjangoAdminLog;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DjangoAdminLogRepository extends JpaRepository<DjangoAdminLog, Integer> {
}
