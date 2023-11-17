package at.fhtw.swkom.paperless.data.repos;

import at.fhtw.swkom.paperless.data.domain.DjangoMigrations;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DjangoMigrationsRepository extends JpaRepository<DjangoMigrations, Integer> {
}
