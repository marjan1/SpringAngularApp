package nl.datavisual.domain.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the organisation_units database table.
 * 
 */
@Entity
@Table(name = "organization_units")
@NamedQuery(name = "OrganizationUnit.findAll", query = "SELECT o FROM OrganizationUnit o")
public class OrganizationUnit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_org_units")
	private int idOrgUnits;

	private String code;

	@Temporal(TemporalType.DATE)
	@Column(name = "efective_year")
	private Date efectiveYear;

	private String name;

	//bi-directional many-to-one association to OrganisationSubunitDTO
	@OneToMany(mappedBy = "organizationUnit")
	private List<OrganizationSubunit> organizationSubunits;

	//bi-directional many-to-one association to CompanyDTO
	@ManyToOne
	@JoinColumn(name = "company_id")
	private Company company;

	public OrganizationUnit() {
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

	public List<OrganizationSubunit> getOrganizationSubunits() {
		return this.organizationSubunits;
	}

	public void setOrganizationSubunits(List<OrganizationSubunit> organizationSubunits) {
		this.organizationSubunits = organizationSubunits;
	}

	public OrganizationSubunit addOrganisationSubunit(OrganizationSubunit organizationSubunit) {
		getOrganizationSubunits().add(organizationSubunit);
		organizationSubunit.setOrganizationUnit(this);

		return organizationSubunit;
	}

	public OrganizationSubunit removeOrganisationSubunit(OrganizationSubunit organizationSubunit) {
		getOrganizationSubunits().remove(organizationSubunit);
		organizationSubunit.setOrganizationUnit(null);

		return organizationSubunit;
	}

	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

}