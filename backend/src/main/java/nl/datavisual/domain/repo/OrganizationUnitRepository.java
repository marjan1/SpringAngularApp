package nl.datavisual.domain.repo;

import nl.datavisual.domain.entity.OrganizationUnit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationUnitRepository extends JpaRepository<OrganizationUnit, Integer> {
}
