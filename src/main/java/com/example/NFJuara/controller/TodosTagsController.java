package com.example.NFJuara.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.NFJuara.config.JsonMessage;
import com.example.NFJuara.dto.TodosTagsDto;
import com.example.NFJuara.service.TodosTagsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@RestController
@RequestMapping(value = "/app/todos")
public class TodosTagsController {

	private static final Logger log = LoggerFactory.getLogger(TagsController.class);
	private ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
	private JsonMessage message = new JsonMessage();
	
	private TodosTagsService todosTagsService;
	
	@Autowired
	public TodosTagsController(TodosTagsService todosTagsService) {
		this.todosTagsService = todosTagsService;
	}
	
	@GetMapping()
	public JsonMessage getAllActiveTodos() {
		try {
			List<TodosTagsDto> allActive = todosTagsService.getAllActiveTodos();
			if(allActive.size()>0)
				return new JsonMessage("Success", "Data Exist", allActive);
		} catch (Exception e) {
			log.info("Failed getAllTodos " + e);
		}
		return message.showErrorMessage("Not Found");
	}
	
	@GetMapping("/{id}")
	public JsonMessage getById(@PathVariable Long id) {
		TodosTagsDto data;
		try {
			data = todosTagsService.getById(id);
			return new JsonMessage("Success", "Data Exist", data);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message.showErrorMessage("Not Found");
	}
	
	
	
}
