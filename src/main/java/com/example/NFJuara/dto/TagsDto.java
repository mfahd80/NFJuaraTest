package com.example.NFJuara.dto;

import java.util.Date;

import lombok.Data;

@Data
public class TagsDto {

	private Long id;
	private String name;
	private int isActive;
	private Date createdAt;
	private Date updatedAt;
}
