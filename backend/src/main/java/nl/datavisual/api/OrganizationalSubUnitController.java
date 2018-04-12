package nl.datavisual.api;

import nl.datavisual.domain.entity.OrganizationSubunit;
import nl.datavisual.service.CompanyService;
import nl.datavisual.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class OrganizationalSubUnitController {
    Logger log = LoggerFactory.getLogger(OrganizationalSubUnitController.class);

    private UserService userService;
    private CompanyService companyService;


    public OrganizationalSubUnitController(UserService userService, CompanyService companyService) {
        this.userService = userService;
        this.companyService = companyService;
    }


    @GetMapping(path = "/osu")
    public List<OrganizationSubunit> getOrganizationalSubunitForUserByUsername(@RequestParam String username) {
        log.debug("Request for getting all organizational subunits for user with username = {}", username);
        return userService.getAllOrganizationSubunitsForUserByUsername(username);
    }


}