package nl.datavisual.domain.repo;

import nl.datavisual.domain.entity.Collaborator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollaboratorRepository extends JpaRepository<Collaborator, Integer> {
}
