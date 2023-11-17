package at.fhtw.swkom.paperless.data.repos;

import at.fhtw.swkom.paperless.data.domain.AuthtokenToken;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AuthtokenTokenRepository extends JpaRepository<AuthtokenToken, String> {
}
