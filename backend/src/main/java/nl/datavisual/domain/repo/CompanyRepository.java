package nl.datavisual.domain.repo;


import nl.datavisual.domain.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

    List<Company> getAllCompanyListByCompanyName(String companyName);
}
