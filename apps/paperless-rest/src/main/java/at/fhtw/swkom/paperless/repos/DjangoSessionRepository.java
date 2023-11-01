package at.fhtw.swkom.paperless.repos;

import at.fhtw.swkom.paperless.domain.DjangoSession;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DjangoSessionRepository extends JpaRepository<DjangoSession, String> {
}
