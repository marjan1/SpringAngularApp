package nl.datavisual.dto;

import java.io.Serializable;


public class DocumentAppendixeDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idDoctAppendixes;

	private byte[] content;

	private String name;

	private DocumentDTO documentDTO;

	public DocumentAppendixeDTO() {
	}

	public int getIdDoctAppendixes() {
		return this.idDoctAppendixes;
	}

	public void setIdDoctAppendixes(int idDoctAppendixes) {
		this.idDoctAppendixes = idDoctAppendixes;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DocumentDTO getDocumentDTO() {
		return this.documentDTO;
	}

	public void setDocumentDTO(DocumentDTO documentDTO) {
		this.documentDTO = documentDTO;
	}

}