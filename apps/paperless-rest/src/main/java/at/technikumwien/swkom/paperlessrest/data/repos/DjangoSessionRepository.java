package at.technikumwien.swkom.paperlessrest.data.repos;

import at.technikumwien.swkom.paperlessrest.data.domain.DjangoSession;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DjangoSessionRepository extends JpaRepository<DjangoSession, String> {
}
