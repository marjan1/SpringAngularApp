package nl.datavisual.domain.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the document database table.
 */
@Entity
@NamedQuery(name = "Document.findAll", query = "SELECT d FROM Document d")
public class Document implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_document")
    private Long idDocument;

    @Temporal(TemporalType.DATE)
    @Column(name = "close_date")
    private Date closeDate;

    @Column(name = "column_14")
    private int column14;

    @Lob
    private byte[] content;

    private int counter;

    @Temporal(TemporalType.DATE)
    @Column(name = "creation_date")
    private Date creationDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "external_date")
    private Date externalDate;

    @Column(name = "external_number")
    private String externalNumber;

    private byte folder;

    private String name;

    @Column(name = "parent_id")
    private int parentId;

    @Column(name = "status_code")
    private int statusCode;

    //bi-directional many-to-one association to OrganisationSubunitDTO
    @ManyToOne
    @JoinColumn(name = "org_subunit_id")
    private OrganizationSubunit organizationSubunit;

    //bi-directional many-to-one association to CollaboratorDTO
    @ManyToOne
    @JoinColumn(name = "collaborator_id")
    private Collaborator collaborator;

    //bi-directional many-to-one association to User
    @ManyToOne
    @JoinColumn(name = "users_id")
    private User user;

    //bi-directional many-to-one association to DocumentAppendixeDTO
    @OneToMany(mappedBy = "document")
    private List<DocumentAppendixe> documentAppendixes;

    public Document() {
    }

    public Long getIdDocument() {
        return this.idDocument;
    }

    public void setIdDocument(Long idDocument) {
        this.idDocument = idDocument;
    }

    public Date getCloseDate() {
        return this.closeDate;
    }

    public void setCloseDate(Date closeDate) {
        this.closeDate = closeDate;
    }

    public int getColumn14() {
        return this.column14;
    }

    public void setColumn14(int column14) {
        this.column14 = column14;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public int getCounter() {
        return this.counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public Date getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getExternalDate() {
        return this.externalDate;
    }

    public void setExternalDate(Date externalDate) {
        this.externalDate = externalDate;
    }

    public String getExternalNumber() {
        return this.externalNumber;
    }

    public void setExternalNumber(String externalNumber) {
        this.externalNumber = externalNumber;
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

    public int getParentId() {
        return this.parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public OrganizationSubunit getOrganizationSubunit() {
        return organizationSubunit;
    }

    public void setOrganizationSubunit(OrganizationSubunit organizationSubunit) {
        this.organizationSubunit = organizationSubunit;
    }

    public Collaborator getCollaborator() {
        return this.collaborator;
    }

    public void setCollaborator(Collaborator collaborator) {
        this.collaborator = collaborator;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<DocumentAppendixe> getDocumentAppendixes() {
        return this.documentAppendixes;
    }

    public void setDocumentAppendixes(List<DocumentAppendixe> documentAppendixes) {
        this.documentAppendixes = documentAppendixes;
    }

    public DocumentAppendixe addDocumentAppendixe(DocumentAppendixe documentAppendixe) {
        getDocumentAppendixes().add(documentAppendixe);
        documentAppendixe.setDocument(this);

        return documentAppendixe;
    }

    public DocumentAppendixe removeDocumentAppendixe(DocumentAppendixe documentAppendixe) {
        getDocumentAppendixes().remove(documentAppendixe);
        documentAppendixe.setDocument(null);

        return documentAppendixe;
    }

}