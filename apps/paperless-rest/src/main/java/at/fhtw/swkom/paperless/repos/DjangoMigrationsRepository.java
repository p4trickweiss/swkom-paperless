package at.fhtw.swkom.paperless.repos;

import at.fhtw.swkom.paperless.domain.DjangoMigrations;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DjangoMigrationsRepository extends JpaRepository<DjangoMigrations, Integer> {
}
