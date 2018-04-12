package nl.datavisual.domain.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the roles database table.
 * 
 */
@Entity
@Table(name = "roles")
@NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_roles")
    private int idRoles;

	private String desription;

	private String name;

	//bi-directional many-to-many association to User
    @ManyToMany(mappedBy = "roles")
    private List<User> users;

	public Role() {
	}

    public Role(String name) {
        this.name = name;
    }

	public int getIdRoles() {
		return this.idRoles;
	}

	public void setIdRoles(int idRoles) {
		this.idRoles = idRoles;
	}

	public String getDesription() {
		return this.desription;
	}

	public void setDesription(String desription) {
		this.desription = desription;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}