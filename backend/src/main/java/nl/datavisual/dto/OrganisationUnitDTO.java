package nl.datavisual.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;



public class OrganisationUnitDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idOrgUnits;

	private String code;

	private Date efectiveYear;

	private String name;

	private List<OrganisationSubunitDTO> organisationSubunitDTOS;

	private CompanyDTO companyDTO;

	public OrganisationUnitDTO() {
	}

	public int getIdOrgUnits() {
		return this.idOrgUnits;
	}

	public void setIdOrgUnits(int idOrgUnits) {
		this.idOrgUnits = idOrgUnits;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getEfectiveYear() {
		return this.efectiveYear;
	}

	public void setEfectiveYear(Date efectiveYear) {
		this.efectiveYear = efectiveYear;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<OrganisationSubunitDTO> getOrganisationSubunitDTOS() {
		return this.organisationSubunitDTOS;
	}

	public void setOrganisationSubunitDTOS(List<OrganisationSubunitDTO> organisationSubunitDTOS) {
		this.organisationSubunitDTOS = organisationSubunitDTOS;
	}

	public OrganisationSubunitDTO addOrganisationSubunit(OrganisationSubunitDTO organisationSubunitDTO) {
		getOrganisationSubunitDTOS().add(organisationSubunitDTO);
		organisationSubunitDTO.setOrganisationUnitDTO(this);

		return organisationSubunitDTO;
	}

	public OrganisationSubunitDTO removeOrganisationSubunit(OrganisationSubunitDTO organisationSubunitDTO) {
		getOrganisationSubunitDTOS().remove(organisationSubunitDTO);
		organisationSubunitDTO.setOrganisationUnitDTO(null);

		return organisationSubunitDTO;
	}

	public CompanyDTO getCompanyDTO() {
		return this.companyDTO;
	}

	public void setCompanyDTO(CompanyDTO companyDTO) {
		this.companyDTO = companyDTO;
	}

}