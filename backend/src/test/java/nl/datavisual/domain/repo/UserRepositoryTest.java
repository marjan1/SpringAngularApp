package nl.datavisual.domain.repo;

import com.querydsl.core.Tuple;
import nl.datavisual.domain.entity.Company;
import nl.datavisual.domain.entity.OrganizationSubunit;
import nl.datavisual.domain.entity.Role;
import nl.datavisual.domain.entity.User;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


@RunWith(SpringRunner.class)
@SpringBootTest
//@DataJpaTest
@Ignore
public class UserRepositoryTest {
    public static final String USERNAME_1 = "username_1";

//    @Autowired
//    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private CollaboratorRepository collaboratorRepository;


    @Test
    public void shouldFindUserByUsername() {

        List<User> userList = userRepository.findUsersByEmailPart("1");
        assertNotNull(userList);
        assertEquals(3, userList.size());
    }

    @Test
    public void shouldGetOrganizationalSubUnitsByUsername() {
        String testUsername = "username_1";
        List<OrganizationSubunit> organizationSubunits = userRepository.getAllOrganizationSubunitsForUserByUsername(testUsername);
        assertNotNull(organizationSubunits);
        for (OrganizationSubunit organizationSubunit : organizationSubunits) {
            List<User> users = organizationSubunit.getOrganizationUnit().getCompany().getUsers();
            assertNotNull(users);
            users.forEach(user -> assertEquals(testUsername, user.getUsername()));
        }
    }

    @Test
    public void shouldGetCompanyByUsername() {
        String username1 = USERNAME_1;
        Company company = userRepository.getCompanyByUsername(username1);
        assertNotNull(company);
        assertTrue(company.getUsers().stream().anyMatch(user -> username1.equals(user.getUsername())));

    }

    @Test
    public void shoudGetCompaniesWithNumberOfUsers() {
        List<Tuple> usersPerCompany = userRepository.getNumberOfUsersPerCompany();
        usersPerCompany.forEach(tuple -> System.out.println("Company name : " + tuple.get(0, String.class)
                + " number of users : " + tuple.get(1, Integer.class)));
        usersPerCompany.get(0).get(1, Integer.class);
        assertNotNull(usersPerCompany);
    }

    @Test
    public void shouldGetDistinctUsersPerCompanyAndRole() {
        List<Role> roles = roleRepository.findAll();
        Role role = roles.stream().findFirst().get();

        Company company = companyRepository.findOne(3);

        List<User> usersPerCompany = userRepository.geCompanyUsersPerRole(role, company);

        usersPerCompany.forEach(user -> {
            assertTrue(user.getRoles().stream().anyMatch(role1 -> role1.getIdRoles() == role.getIdRoles()));
            assertEquals(company.getIdCompanies(), user.getCompany().getIdCompanies());
        });
    }

    @Test
    public void deleteWithLevel() {
        User userForDelete = userRepository.findFirstByIdUsers(21l);
        userRepository.deleteById(userForDelete.getIdUsers());

        List<User> users = userRepository.findAll();
        assertTrue(users.stream().noneMatch(user -> user.getIdUsers().equals(userForDelete.getIdUsers())));

    }

    @Test
    public void shouldUpdateCodeAndNameAllIrganizationalSubUnitsByUsername() {
        String testUsername = "username_7";
        long numberOfUpdatedRows = userRepository.updateOrganizationSubunitsForUserByUsername(testUsername);
        assertTrue(numberOfUpdatedRows > 0);


    }


}