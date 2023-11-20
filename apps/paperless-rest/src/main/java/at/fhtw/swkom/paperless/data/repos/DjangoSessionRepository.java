package at.fhtw.swkom.paperless.data.repos;

import at.fhtw.swkom.paperless.data.domain.DjangoSession;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DjangoSessionRepository extends JpaRepository<DjangoSession, String> {
}
