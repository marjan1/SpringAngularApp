package nl.datavisual.domain.entity;

import javax.persistence.*;
import java.io.Serializable;


/**
 * The persistent class for the document_appendixes database table.
 * 
 */
@Entity
@Table(name = "document_appendixes")
@NamedQuery(name = "DocumentAppendixe.findAll", query = "SELECT d FROM DocumentAppendixe d")
public class DocumentAppendixe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_doct_appendixes")
	private int idDoctAppendixes;

	@Lob
	private byte[] content;

	private String name;

	//bi-directional many-to-one association to DocumentDTO
	@ManyToOne
	@JoinColumn(name = "document_id")
	private Document document;

	public DocumentAppendixe() {
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

	public Document getDocument() {
		return this.document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

}