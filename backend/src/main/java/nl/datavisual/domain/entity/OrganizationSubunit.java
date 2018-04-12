package nl.datavisual.domain.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the organisation_subunit database table.
 * 
 */
@Entity
@Table(name = "organization_subunit")
@NamedQuery(name = "OrganizationSubunit.findAll", query = "SELECT o FROM OrganizationSubunit o")
public class OrganizationSubunit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_org_subunit")
	private int idOrgSubunit;

	private String code;

	private byte folder;

	private String name;

	@Column(name = "retentation_yesrs")
	private byte retentationYesrs;

	//bi-directional many-to-one association to DocumentDTO
	@OneToMany(mappedBy = "organizationSubunit")
	private List<Document> documents;

	//bi-directional many-to-one association to OrganisationUnitDTO
	@ManyToOne
	@JoinColumn(name = "org_unit_id")
	private OrganizationUnit organizationUnit;

	public OrganizationSubunit() {
	}

	public int getIdOrgSubunit() {
		return this.idOrgSubunit;
	}

	public void setIdOrgSubunit(int idOrgSubunit) {
		this.idOrgSubunit = idOrgSubunit;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public byte getFolder() {
		return this.folder;
	}

	public void setFolder(byte folder) {
		this.folder = folder;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte getRetentationYesrs() {
		return this.retentationYesrs;
	}

	public void setRetentationYesrs(byte retentationYesrs) {
		this.retentationYesrs = retentationYesrs;
	}

	public List<Document> getDocuments() {
		return this.documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	public Document addDocument(Document document) {
		getDocuments().add(document);
		document.setOrganizationSubunit(this);

		return document;
	}

	public Document removeDocument(Document document) {
		getDocuments().remove(document);
		document.setOrganizationSubunit(null);

		return document;
	}

	public OrganizationUnit getOrganizationUnit() {
		return this.organizationUnit;
	}

	public void setOrganizationUnit(OrganizationUnit organizationUnit) {
		this.organizationUnit = organizationUnit;
	}

}