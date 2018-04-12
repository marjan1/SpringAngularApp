package nl.datavisual;


import nl.datavisual.domain.entity.*;
import nl.datavisual.domain.repo.*;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
@Ignore
public class DatabaseTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private CollaboratorRepository collaboratorRepository;

    @Autowired
    private OrganizationUnitRepository organizationUnitRepository;

    @Autowired
    private OrganizationSubunitRepository organizationSubunitRepository;

    @Autowired
    private DocumentRepository documentRepository;

    @Autowired
    private DocumentAppendixeRepository documentAppendixeRepository;

    @Test
  //  @Ignore
    public void populateDatabase() {
        List<Role> roleList = setRolesInDB();
        List<Collaborator> collaboratorList = saveColaboratorsInDB(3);
        List<Company> companies = saveCompaniesInDB(7);
        List<OrganizationUnit> organizationUnits = saveOrganizationalUnitsInDB(companies, 4);
        List<OrganizationSubunit> organizationSubunits = saveOrganizationalSubUnitsInDB(organizationUnits, 2);
        List<User> users = saveUsersInDB(companies, roleList, 3);
        List<Document> documentList = saveDocumentsInDB(organizationSubunits, collaboratorList, users);
        List<DocumentAppendixe> documentAppendixes = saveDocumentAppendixeInDB(documentList, 2);
        System.out.println("End");
    }

    private List<DocumentAppendixe> saveDocumentAppendixeInDB(List<Document> documentList, int number) {
        List<DocumentAppendixe> documentAppendixeList = new ArrayList<>();
        for (Document document : documentList) {
            for (int i = 0; i < number; i++) {
                documentAppendixeList.add(documentAppendixeRepository.save(generateDocumentAppendixe(document)));
            }
        }

        return documentAppendixeList;
    }

    private DocumentAppendixe generateDocumentAppendixe(Document document) {
        DocumentAppendixe documentAppendixe = new DocumentAppendixe();
        documentAppendixe.setName("name_" + document.getIdDocument());
        documentAppendixe.setDocument(document);
        return documentAppendixe;
    }

    private List<User> saveUsersInDB(List<Company> companies, List<Role> roleList, int number) {
        List<User> userList = new ArrayList<>();
        Random random = new Random(2);
        for (Company company : companies) {
            for (int i = 0; i < number; i++) {
                List<Role> roles = new ArrayList<>();
                roles.add(roleList.get(i % 3));
                roles.add(roleList.get(i % 2));
                userList.add(userRepository.save(generateUser(company, roles)));
            }
        }

        return userList;
    }

    private List<Document> saveDocumentsInDB(List<OrganizationSubunit> organizationSubunits, List<Collaborator> collaboratorList, List<User> users) {
        organizationSubunits = organizationSubunits.subList(0, organizationSubunits.size() / 2);
        List<Document> documentList = new ArrayList<>();

        for (User user : users) {
            for (Collaborator collaborator : collaboratorList) {
                int k=0;
                for (OrganizationSubunit organizationSubunit : organizationSubunits) {
                   int i =0;i++;
                    documentList.add(documentRepository.save(generateDocument(user, collaborator, organizationSubunit)));
                    if(i==15){
                        break;
                    }
                }
            }
        }
        return documentList;
    }

    private Document generateDocument(User user, Collaborator collaborator, OrganizationSubunit organizationSubunit) {
        Document document = new Document();
        document.setCloseDate(new Date());
        document.setCounter(1);
        document.setCreationDate(new Date());
        document.setExternalDate(new Date());
        document.setExternalNumber(user.getIdUsers() + "exNumber" + organizationSubunit.getIdOrgSubunit());
        document.setName("name_collabo_" + collaborator.getIdCollaborators());
        document.setParentId(2);
        document.setStatusCode(user.getStatusCode());
        document.setOrganizationSubunit(organizationSubunit);
        document.setCollaborator(collaborator);
        document.setUser(user);

        return document;
    }

    private User generateUser(Company company, List<Role> roleList) {
        User user = new User();
        user.setEmail(company.getIdCompanies() + "_email@user.com");
        user.setName("name_" + company.getIdCompanies());
        user.setPassword("password_" + company.getIdCompanies());
        user.setStatusCode(company.getIdCompanies() % 2);
        user.setUsername("username_" + company.getIdCompanies());
        user.setCompany(company);
        user.setRoles(roleList);
        return user;
    }

    private List<OrganizationSubunit> saveOrganizationalSubUnitsInDB(List<OrganizationUnit> organizationUnits, int number) {
        List<OrganizationSubunit> organizationSubunits = new ArrayList<>();
        for (OrganizationUnit organizationUnit : organizationUnits) {
            for (int i = 0; i < number; i++) {
                organizationSubunits.add(organizationSubunitRepository.save(generateOrganizationSubunit(organizationUnit)));
            }
        }
        return organizationSubunits;
    }

    private OrganizationSubunit generateOrganizationSubunit(OrganizationUnit organizationUnit) {
        OrganizationSubunit organizationSubunit = new OrganizationSubunit();
        organizationSubunit.setCode("code_" + organizationUnit.getIdOrgUnits());
        organizationSubunit.setName("name_" + organizationUnit.getIdOrgUnits());
        organizationSubunit.setOrganizationUnit(organizationUnit);
        return organizationSubunit;
    }

    private List<OrganizationUnit> saveOrganizationalUnitsInDB(List<Company> companies, int number) {
        List<OrganizationUnit> organizationUnitList = new ArrayList<>();
        for (Company company : companies) {
            for (int i = 0; i < number; i++) {
                organizationUnitList.add(organizationUnitRepository.save(generateOrganizationUnit(company)));
            }
        }

        return organizationUnitList;
    }

    private OrganizationUnit generateOrganizationUnit(Company company) {
        OrganizationUnit organizationUnit = new OrganizationUnit();
        organizationUnit.setCode("code_" + company.getIdCompanies());
        organizationUnit.setEfectiveYear(new Date());
        organizationUnit.setName("Org_unit_name_" + company.getIdCompanies());
        organizationUnit.setCompany(company);
        return organizationUnit;
    }

    private List<Company> saveCompaniesInDB(int number) {
        List<Company> companyList = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            companyList.add(companyRepository.save(generateCompany(i)));
        }
        return companyList;
    }

    private Company generateCompany(int i) {
        Company company = new Company();
        company.setAddress("Company_address_" + i);
        company.setCompanyName("Company_name_" + i);
        company.setExpirationDate(new Date());
        company.setNumberOfUsers(i * 10);
        company.setPhone("Company_phone_" + i);
        company.setStatusCode(i % 2);
        return company;
    }

    private List<Collaborator> saveColaboratorsInDB(int number) {
        List<Collaborator> collaboratorList = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            collaboratorList.add(collaboratorRepository.save(generateCollaborator(i)));
        }
        return collaboratorList;
    }

    private Collaborator generateCollaborator(int i) {
        Collaborator collaborator = new Collaborator();
        collaborator.setAccount("Account_" + i);
        collaborator.setAddress("Address_" + i);
        collaborator.setCompanyNumber("Company_number_" + i);
        collaborator.setEmail(i + "_collaborator@email.com");
        collaborator.setName("Name_" + i);
        collaborator.setPhone("Phone_" + i);
        collaborator.setStatusCode(i % 2);
        return collaborator;
    }

    private List<Role> setRolesInDB() {
        List<Role> roles = roleRepository.findAll();
        roles.add(saveRoleInDB(roles, "ROLE_USER", "Role for users"));
        roles.add(saveRoleInDB(roles, "ROLE_ADMIN", "Role for admins"));
        roles.add(saveRoleInDB(roles, "ROLE_SUPER_ADMIN", "Role for super admins"));
        return roles;
    }

    private Role saveRoleInDB(List<Role> roles, String roleName, String roleDescription) {
        //   if (roles.stream().noneMatch(role -> role.getName().equals(roleName))) {
        Role role = new Role();
        role.setName(roleName);
        role.setDesription(roleDescription);
        return roleRepository.save(role);
        // }
    }


}
