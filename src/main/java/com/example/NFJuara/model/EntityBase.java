package com.example.NFJuara.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Data;

@Data
@MappedSuperclass
public class EntityBase implements Serializable {


	private static final long serialVersionUID = 4719636313065251476L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "isActive")
	private int isActive;
	
	@CreatedDate
	@Column(name = "createdAt")
	private Date createdAt;

	@LastModifiedDate
	@Column(name = "updatedAt")
	private Date updatedAt;
}
