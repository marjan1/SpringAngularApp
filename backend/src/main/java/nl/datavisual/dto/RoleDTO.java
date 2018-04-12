package nl.datavisual.dto;

import java.io.Serializable;
import java.util.List;


public class RoleDTO implements Serializable {
	private static final long serialVersionUID = 1L;

    private int idRoles;

	private String desription;

	private String name;

    private List<User> users;

	public RoleDTO() {
	}

    public RoleDTO(String name) {
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

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("RoleDTO{");
		sb.append("idRoles=").append(idRoles);
		sb.append(", desription='").append(desription).append('\'');
		sb.append(", name='").append(name).append('\'');
		sb.append(", users=").append(users);
		sb.append('}');
		return sb.toString();
	}
}