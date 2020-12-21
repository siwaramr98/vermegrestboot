package com.sip.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
@Entity
public class Book {
	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	private int idBook;
	 @NotBlank(message = "title is mandatory")
	 @Column(name = "title")
	 private String title;

	 @Column(name = "price")
	 private double price;

	 @Column(name = "releaseDate")
	 private String releaseDate;
	 @Column(name = "coverImage")
	 private String coverImage;
	 public Book() {}
	public Book(int idBook, String title, double price,String releaseDate, String coverImage) {
		this.idBook = idBook;
		this.title = title;
		this.price = price;
		this.releaseDate = releaseDate;
		this.coverImage = coverImage;
	}
	public int getIdBook() {
		return idBook;
	}
	public void setIdBook(int idBook) {
		this.idBook = idBook;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getCoverImage() {
		return coverImage;
	}
	public void setCoverImage(String coverImage) {
		this.coverImage = coverImage;
	}
	
	 
	
}
