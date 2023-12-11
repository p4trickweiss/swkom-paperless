package at.technikumwien.swkom.paperlessrest.data.repos;

import at.technikumwien.swkom.paperlessrest.data.domain.DjangoContentType;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DjangoContentTypeRepository extends JpaRepository<DjangoContentType, Integer> {
}
