package nl.datavisual.dto;

import java.io.Serializable;
import java.util.List;



public class CollaboratorDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private int idCollaborators;

    private String account;

    private String address;

    private String companyNumber;

    private String email;

    private String name;

    private String phone;

    private int statusCode;

    private List<DocumentDTO> documentDTOS;

    public CollaboratorDTO() {
    }

    public int getIdCollaborators() {
        return this.idCollaborators;
    }

    public void setIdCollaborators(int idCollaborators) {
        this.idCollaborators = idCollaborators;
    }

    public String getAccount() {
        return this.account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCompanyNumber() {
        return this.companyNumber;
    }

    public void setCompanyNumber(String companyNumber) {
        this.companyNumber = companyNumber;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public List<DocumentDTO> getDocumentDTOS() {
        return this.documentDTOS;
    }

    public void setDocumentDTOS(List<DocumentDTO> documentDTOS) {
        this.documentDTOS = documentDTOS;
    }

    public DocumentDTO addDocument(DocumentDTO documentDTO) {
        getDocumentDTOS().add(documentDTO);
        documentDTO.setCollaboratorDTO(this);

        return documentDTO;
    }

    public DocumentDTO removeDocument(DocumentDTO documentDTO) {
        getDocumentDTOS().remove(documentDTO);
        documentDTO.setCollaboratorDTO(null);

        return documentDTO;
    }

}