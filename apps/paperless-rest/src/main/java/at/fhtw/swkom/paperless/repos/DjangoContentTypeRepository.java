package at.fhtw.swkom.paperless.repos;

import at.fhtw.swkom.paperless.domain.DjangoContentType;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DjangoContentTypeRepository extends JpaRepository<DjangoContentType, Integer> {
}
