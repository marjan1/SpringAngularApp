package nl.datavisual.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


public class DocumentDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long idDocument;

    private Date closeDate;

    private int column14;

    private byte[] content;

    private int counter;

    private Date creationDate;

    private Date externalDate;

    private String externalNumber;

    private byte folder;

    private String name;

    private int parentId;

    private int statusCode;

    private OrganisationSubunitDTO organisationSubunitDTO;

    private CollaboratorDTO collaboratorDTO;

    private User user;

    private List<DocumentAppendixeDTO> documentAppendixDTOS;

    public DocumentDTO() {
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

    public OrganisationSubunitDTO getOrganisationSubunitDTO() {
        return this.organisationSubunitDTO;
    }

    public void setOrganisationSubunitDTO(OrganisationSubunitDTO organisationSubunitDTO) {
        this.organisationSubunitDTO = organisationSubunitDTO;
    }

    public CollaboratorDTO getCollaboratorDTO() {
        return this.collaboratorDTO;
    }

    public void setCollaboratorDTO(CollaboratorDTO collaboratorDTO) {
        this.collaboratorDTO = collaboratorDTO;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<DocumentAppendixeDTO> getDocumentAppendixDTOS() {
        return this.documentAppendixDTOS;
    }

    public void setDocumentAppendixDTOS(List<DocumentAppendixeDTO> documentAppendixDTOS) {
        this.documentAppendixDTOS = documentAppendixDTOS;
    }

    public DocumentAppendixeDTO addDocumentAppendixe(DocumentAppendixeDTO documentAppendixeDTO) {
        getDocumentAppendixDTOS().add(documentAppendixeDTO);
        documentAppendixeDTO.setDocumentDTO(this);

        return documentAppendixeDTO;
    }

    public DocumentAppendixeDTO removeDocumentAppendixe(DocumentAppendixeDTO documentAppendixeDTO) {
        getDocumentAppendixDTOS().remove(documentAppendixeDTO);
        documentAppendixeDTO.setDocumentDTO(null);

        return documentAppendixeDTO;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("DocumentDTO{");
        sb.append("idDocument=").append(idDocument);
        sb.append(", closeDate=").append(closeDate);
        sb.append(", column14=").append(column14);
        sb.append(", content=");
        if (content == null) sb.append("null");
        else {
            sb.append('[');
            for (int i = 0; i < content.length; ++i)
                sb.append(i == 0 ? "" : ", ").append(content[i]);
            sb.append(']');
        }
        sb.append(", counter=").append(counter);
        sb.append(", creationDate=").append(creationDate);
        sb.append(", externalDate=").append(externalDate);
        sb.append(", externalNumber='").append(externalNumber).append('\'');
        sb.append(", folder=").append(folder);
        sb.append(", name='").append(name).append('\'');
        sb.append(", parentId=").append(parentId);
        sb.append(", statusCode=").append(statusCode);
        sb.append(", organisationSubunitDTO=").append(organisationSubunitDTO);
        sb.append(", collaboratorDTO=").append(collaboratorDTO);
        sb.append(", user=").append(user);
        sb.append(", documentAppendixDTOS=").append(documentAppendixDTOS);
        sb.append('}');
        return sb.toString();
    }
}