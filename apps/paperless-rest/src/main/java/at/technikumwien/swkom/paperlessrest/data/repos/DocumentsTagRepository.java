package at.technikumwien.swkom.paperlessrest.data.repos;

import at.technikumwien.swkom.paperlessrest.data.domain.DocumentsTag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface DocumentsTagRepository extends JpaRepository<DocumentsTag, Integer> {
    Optional<DocumentsTag> findByName(String name);
}
