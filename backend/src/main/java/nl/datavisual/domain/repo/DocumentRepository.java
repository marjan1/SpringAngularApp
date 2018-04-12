package nl.datavisual.domain.repo;

import nl.datavisual.domain.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository  extends JpaRepository<Document,Long> {
}
