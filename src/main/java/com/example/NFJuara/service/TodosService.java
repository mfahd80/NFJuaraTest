package com.example.NFJuara.service;

import com.example.NFJuara.dto.TodosDto;
import com.example.NFJuara.model.Todos;

public interface TodosService extends CommonService<Todos, TodosDto, Long>{

	TodosDto setInactive(Long id);
	
	
}