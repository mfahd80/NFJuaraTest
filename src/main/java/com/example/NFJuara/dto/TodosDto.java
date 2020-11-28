package com.example.NFJuara.dto;


import java.util.Date;

import lombok.Data;

@Data
public class TodosDto {

	private Long id;
	private String name;
	private int isFinished;
	private int isActive;
	private Date createdAt;
	private Date updatedAt;
}
