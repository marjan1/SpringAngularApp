package nl.datavisual.service;

import nl.datavisual.domain.entity.Company;
import nl.datavisual.dto.CompanyDTO;
import nl.datavisual.domain.repo.CompanyRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyService {
    Logger log = LoggerFactory.getLogger(CompanyService.class);

    private CompanyRepository companyRepository;
    private ModelMapper modelMapper;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
        this.modelMapper = new ModelMapper();
    }

    public List<CompanyDTO> getAllCompanies() {
        log.debug("Get all companies");
        return companyRepository.findAll().stream()
                .map(company -> modelMapper.map(company, CompanyDTO.class)).collect(Collectors.toList());
    }

    public CompanyDTO updateCompany(CompanyDTO companyDTO) {
        log.debug("Update company {}", companyDTO);
        return modelMapper.map(companyRepository.save(modelMapper.map(companyDTO, Company.class)), CompanyDTO.class);
    }
}
