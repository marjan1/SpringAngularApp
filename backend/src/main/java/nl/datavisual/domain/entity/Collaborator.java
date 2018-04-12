package nl.datavisual.domain.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the collaborators database table.
 * 
 */
@Entity
@Table(name = "collaborators")
@NamedQuery(name = "Collaborator.findAll", query = "SELECT c FROM Collaborator c")
public class Collaborator implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_collaborators")
    private int idCollaborators;

    private String account;

    private String address;

    @Column(name = "company_number")
    private String companyNumber;

    private String email;

    private String name;

    private String phone;

    @Column(name = "status_code")
    private int statusCode;

    //bi-directional many-to-one association to DocumentDTO
    @OneToMany(mappedBy = "collaborator")
    private List<Document> documents;

    public Collaborator() {
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

    public List<Document> getDocuments() {
        return this.documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    public Document addDocument(Document document) {
        getDocuments().add(document);
        document.setCollaborator(this);

        return document;
    }

    public Document removeDocument(Document document) {
        getDocuments().remove(document);
        document.setCollaborator(null);

        return document;
    }

}