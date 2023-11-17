package at.fhtw.swkom.paperless.data.repos;

import at.fhtw.swkom.paperless.data.domain.DocumentsStoragepath;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DocumentsStoragepathRepository extends JpaRepository<DocumentsStoragepath, Integer> {
}
