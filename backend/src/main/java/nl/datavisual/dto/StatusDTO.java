package nl.datavisual.dto;

import java.io.Serializable;



public class StatusDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idStatus;

	private int code;

	private String name;

	public StatusDTO() {
	}

	public int getIdStatus() {
		return this.idStatus;
	}

	public void setIdStatus(int idStatus) {
		this.idStatus = idStatus;
	}

	public int getCode() {
		return this.code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}