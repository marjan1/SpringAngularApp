package nl.datavisual.dto;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long idUsers;

    private String email;

    private String name;

    private String password;

    private int statusCode;

    private String username;

    private List<DocumentDTO> documentDTOS;

    private List<RoleDTO> roleDTOS;

    private CompanyDTO companyDTO;

    public User() {
    }

    public Long getIdUsers() {
        return this.idUsers;
    }

    public void setIdUsers(Long idUsers) {
        this.idUsers = idUsers;
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

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<DocumentDTO> getDocumentDTOS() {
        return this.documentDTOS;
    }

    public void setDocumentDTOS(List<DocumentDTO> documentDTOS) {
        this.documentDTOS = documentDTOS;
    }

    public DocumentDTO addDocument(DocumentDTO documentDTO) {
        getDocumentDTOS().add(documentDTO);
        documentDTO.setUser(this);

        return documentDTO;
    }

    public DocumentDTO removeDocument(DocumentDTO documentDTO) {
        getDocumentDTOS().remove(documentDTO);
        documentDTO.setUser(null);

        return documentDTO;
    }

    public List<RoleDTO> getRoleDTOS() {
        return this.roleDTOS;
    }

    public void setRoleDTOS(List<RoleDTO> roleDTOS) {
        this.roleDTOS = roleDTOS;
    }

    public CompanyDTO getCompanyDTO() {
        return this.companyDTO;
    }

    public void setCompanyDTO(CompanyDTO companyDTO) {
        this.companyDTO = companyDTO;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("User{");
        sb.append("idUsers=").append(idUsers);
        sb.append(", email='").append(email).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", statusCode=").append(statusCode);
        sb.append(", username='").append(username).append('\'');
        sb.append(", documentDTOS=").append(documentDTOS);
        sb.append(", roleDTOS=").append(roleDTOS);
        sb.append(", companyDTO=").append(companyDTO);
        sb.append('}');
        return sb.toString();
    }

//    public String[] getArrayOrRolesToString() {
//        String[] roleNames = new String[roleDTOS.size()];
//        int counter = 0;
//        for (RoleDTO roleDTO : roleDTOS) {
//            roleNames[counter++] = roleDTO.getName();
//        }
//        return roleNames;
//    }

}