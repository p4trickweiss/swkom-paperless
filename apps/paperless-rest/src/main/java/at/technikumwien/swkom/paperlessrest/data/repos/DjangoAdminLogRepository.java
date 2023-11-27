package at.technikumwien.swkom.paperlessrest.data.repos;

import at.technikumwien.swkom.paperlessrest.data.domain.DjangoAdminLog;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DjangoAdminLogRepository extends JpaRepository<DjangoAdminLog, Integer> {
}
