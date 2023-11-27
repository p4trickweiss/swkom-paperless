package at.technikumwien.swkom.paperlessrest.data.repos;

import at.technikumwien.swkom.paperlessrest.data.domain.DjangoMigrations;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DjangoMigrationsRepository extends JpaRepository<DjangoMigrations, Integer> {
}
