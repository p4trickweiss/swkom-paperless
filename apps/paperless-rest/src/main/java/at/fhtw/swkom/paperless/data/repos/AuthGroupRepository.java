package at.fhtw.swkom.paperless.data.repos;

import at.fhtw.swkom.paperless.data.domain.AuthGroup;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AuthGroupRepository extends JpaRepository<AuthGroup, Integer> {
}
