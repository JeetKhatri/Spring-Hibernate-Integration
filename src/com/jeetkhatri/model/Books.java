package com.jeetkhatri.model;

import java.io.File;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author JeetKhatri
 *
 */
@Entity
@Table(name = "Books")
public class Books implements Serializable {

	private static final long serialVersionUID = -723583058586873479L;

	@Id
	@Column(name = "id")
	private String id;

	@Column(name = "name")
	private String name;

	@Column(name = "author")
	private String author;

	@Column(name = "price")
	private String price;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
