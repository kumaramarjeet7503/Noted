package com.entities;

import java.util.Date;
import org.hibernate.*;
import jakarta.persistence.*;

@Entity
public class Note {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id ;
	private String Description ;
	private String Title ;
	private Date CreatedDate ;
	
	
	public Note(String description, String title, Date createdDate) {
		super();
		Description = description;
		Title = title;
		CreatedDate = createdDate;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public Date getCreatedDate() {
		return CreatedDate;
	}

	public void setCreatedDate(Date createdDate) {
		CreatedDate = createdDate;
	}

	public Note() {
		
	}

}
