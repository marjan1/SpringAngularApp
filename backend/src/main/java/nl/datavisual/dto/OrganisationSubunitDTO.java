package nl.datavisual.dto;

import java.io.Serializable;
import java.util.List;


public class OrganisationSubunitDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idOrgSubunit;

	private String code;

	private byte folder;

	private String name;

	private byte retentationYesrs;

	private List<DocumentDTO> documentDTOS;

	private OrganisationUnitDTO organisationUnitDTO;

	public OrganisationSubunitDTO() {
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

	public List<DocumentDTO> getDocumentDTOS() {
		return this.documentDTOS;
	}

	public void setDocumentDTOS(List<DocumentDTO> documentDTOS) {
		this.documentDTOS = documentDTOS;
	}

	public DocumentDTO addDocument(DocumentDTO documentDTO) {
		getDocumentDTOS().add(documentDTO);
		documentDTO.setOrganisationSubunitDTO(this);

		return documentDTO;
	}

	public DocumentDTO removeDocument(DocumentDTO documentDTO) {
		getDocumentDTOS().remove(documentDTO);
		documentDTO.setOrganisationSubunitDTO(null);

		return documentDTO;
	}

	public OrganisationUnitDTO getOrganisationUnitDTO() {
		return this.organisationUnitDTO;
	}

	public void setOrganisationUnitDTO(OrganisationUnitDTO organisationUnitDTO) {
		this.organisationUnitDTO = organisationUnitDTO;
	}

}