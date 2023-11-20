package at.fhtw.swkom.paperless.data.repos;

import at.fhtw.swkom.paperless.data.domain.AuthGroupPermissions;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AuthGroupPermissionsRepository extends JpaRepository<AuthGroupPermissions, Integer> {
}
