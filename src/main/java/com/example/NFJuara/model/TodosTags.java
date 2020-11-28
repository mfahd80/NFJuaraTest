package com.example.NFJuara.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="todos_tags")
public class TodosTags implements Serializable{

	private static final long serialVersionUID = -8577982916950118401L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "todo_id")
	private Todos todo;
	
	@ManyToOne
	@JoinColumn(name = "tags_id")
	private Tags tags;
}
