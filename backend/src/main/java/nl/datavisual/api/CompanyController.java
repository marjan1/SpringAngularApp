package nl.datavisual.api;

import nl.datavisual.dto.CompanyDTO;
import nl.datavisual.service.CompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class CompanyController {
    Logger log = LoggerFactory.getLogger(CompanyController.class);

    private CompanyService companyService;

    public CompanyController( CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping(path = "/allcompanies")
    public List<CompanyDTO> getAllCompanies() {

        log.debug("Get all companies");
        return companyService.getAllCompanies();
    }

    @PostMapping(path = "/update")
    public CompanyDTO updateCompany(@RequestBody CompanyDTO companyDTO){
        log.debug("Update company {}",companyDTO);
        return companyService.updateCompany(companyDTO);
    }

}