package com.example.NFJuara.service;

import java.util.List;

import com.example.NFJuara.dto.TodosTagsDto;

public interface TodosTagsService extends CommonService<TodosTagsService, TodosTagsDto, Long>{
	
	List<TodosTagsDto> getAllActiveTodos();

}
