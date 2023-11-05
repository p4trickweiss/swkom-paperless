package at.fhtw.swkom.paperless.repos;

import at.fhtw.swkom.paperless.domain.DocumentsTag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface DocumentsTagRepository extends JpaRepository<DocumentsTag, Integer> {
    Optional<DocumentsTag> findByName(String name);
}
