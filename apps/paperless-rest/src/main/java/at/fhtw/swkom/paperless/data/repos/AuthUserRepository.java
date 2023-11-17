package at.fhtw.swkom.paperless.data.repos;

import at.fhtw.swkom.paperless.data.domain.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AuthUserRepository extends JpaRepository<AuthUser, Integer> {
}
