package nl.datavisual.domain.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * The persistent class for the users database table.
 */
@Entity
@Table(name = "users")
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_users")
    private Long idUsers;

    private String email;

    private String name;

    private String password;

    @Column(name = "status_code")
    private int statusCode;

    private String username;

    //bi-directional many-to-one association to DocumentDTO
    @OneToMany(mappedBy = "user")
    private List<Document> documents;

    //bi-directional many-to-many association to RoleDTO
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
            @JoinColumn(name = "role_id") })
    private List<Role> roles;

    //bi-directional many-to-one association to CompanyDTO
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

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

    public int getStatusCode() {
        return this.statusCode;
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

    public List<Document> getDocuments() {
        return this.documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    public Document addDocument(Document document) {
        getDocuments().add(document);
        document.setUser(this);

        return document;
    }

    public Document removeDocument(Document document) {
        getDocuments().remove(document);
        document.setUser(null);

        return document;
    }

    public List<Role> getRoles() {
        return this.roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Company getCompany() {
        return this.company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String[] getArrayOrRolesToString() {
        String[] roleNames = new String[roles.size()];
        int counter = 0;
        for (Role role : roles) {
            roleNames[counter++] = role.getName();
        }
        return roleNames;
    }

}