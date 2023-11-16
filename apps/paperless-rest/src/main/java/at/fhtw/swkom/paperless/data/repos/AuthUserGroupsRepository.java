package at.fhtw.swkom.paperless.data.repos;

import at.fhtw.swkom.paperless.data.domain.AuthUserGroups;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AuthUserGroupsRepository extends JpaRepository<AuthUserGroups, Integer> {
}
