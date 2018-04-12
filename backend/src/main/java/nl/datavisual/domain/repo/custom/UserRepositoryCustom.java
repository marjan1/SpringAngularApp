package nl.datavisual.domain.repo.custom;

import com.querydsl.core.Tuple;
import nl.datavisual.domain.entity.Company;
import nl.datavisual.domain.entity.OrganizationSubunit;
import nl.datavisual.domain.entity.Role;
import nl.datavisual.domain.entity.User;

import java.util.List;

public interface UserRepositoryCustom {

    List<User> findUsersByEmailPart(String emailPart);

    List<OrganizationSubunit> getAllOrganizationSubunitsForUserByUsername(String username);

    Company getCompanyByUsername(String username);

    List<Tuple> getNumberOfUsersPerCompany();

    List<User> geCompanyUsersPerRole(Role roleParam, Company companyParam);

    void deleteById(long id);

    long updateOrganizationSubunitsForUserByUsername(String username);
}
