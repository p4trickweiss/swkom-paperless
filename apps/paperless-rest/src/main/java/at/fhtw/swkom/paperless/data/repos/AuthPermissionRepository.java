package at.fhtw.swkom.paperless.data.repos;

import at.fhtw.swkom.paperless.data.domain.AuthPermission;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AuthPermissionRepository extends JpaRepository<AuthPermission, Integer> {
}
