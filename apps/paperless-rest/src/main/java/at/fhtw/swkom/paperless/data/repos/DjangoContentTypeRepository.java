package at.fhtw.swkom.paperless.data.repos;

import at.fhtw.swkom.paperless.data.domain.DjangoContentType;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DjangoContentTypeRepository extends JpaRepository<DjangoContentType, Integer> {
}
