package at.fhtw.swkom.paperless.data.repos;

import at.fhtw.swkom.paperless.data.domain.AuthUserUserPermissions;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AuthUserUserPermissionsRepository extends JpaRepository<AuthUserUserPermissions, Integer> {
}
