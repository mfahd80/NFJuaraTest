package com.example.NFJuara.dto;

import com.example.NFJuara.model.Tags;
import com.example.NFJuara.model.Todos;

import lombok.Data;

@Data
public class TodosTagsDto {

	Long id;
	Todos todos;
	Tags tags;
}
