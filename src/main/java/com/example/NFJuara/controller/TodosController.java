package com.example.NFJuara.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.NFJuara.config.JsonMessage;
import com.example.NFJuara.dto.TodosDto;
import com.example.NFJuara.dto.TodosTagsDto;
import com.example.NFJuara.model.Todos;
import com.example.NFJuara.service.TodosService;
import com.example.NFJuara.service.TodosTagsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;


@RestController
@RequestMapping(value = "/app/todo")
public class TodosController {
	
	
	private static final Logger log = LoggerFactory.getLogger(TodosController.class);
	private ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
	private JsonMessage message = new JsonMessage();


	private TodosService todosService;
	private TodosTagsService todosTagsService;
	
	@Autowired
	public TodosController(TodosService todosService, TodosTagsService todosTagsService) {
		this.todosService = todosService;
		this.todosTagsService = todosTagsService;
	}
	
	@PostMapping("")
	public JsonMessage addTodos(@RequestBody TodosDto dto) {
		try {
			if (null!=dto) {
				
				Todos data = todosService.save(dto);
				
				return message.showSuccessMessage("Data Saved");
			}
		} catch (Exception e) {
			log.info("Failed addTodos " + e);
			return message.showErrorMessage("Failed to Save Data");
		}
		return null;
	}
	
	@PutMapping("/{id}")
	public JsonMessage updateTodos(@PathVariable Long id, @RequestBody TodosDto dto) {
		try {
			if (null!=dto) {
				dto.setId(id);
				Todos data = todosService.save(dto);
				
				return new JsonMessage("Success", "Data Saved", data); 
			}
		} catch (Exception e) {
			log.info("error failed to add cause : " + e);
			return message.showErrorMessage("Failed to save Data");
		}
		return null;
	}
	
	@GetMapping("/{id}")
	public JsonMessage getTodo(@PathVariable Long id) {
		try {
			TodosDto data = todosService.getById(id);
			
			if (null!=data)
			return new JsonMessage("Success", "Data Exist", data); 
		} catch (Exception e) {
			// TODO: handle exception
		}
		return message.showErrorMessage("Not Found");
	}
	
	@DeleteMapping("/{id}")
	public JsonMessage deleteTodos(@PathVariable Long id) {
		try {
			TodosDto data = todosService.setInactive(id);
			if(null!=data)
				if(data.getIsActive()==1)
					return message.showSuccessMessage("Data Saved");
			
		} catch (Exception e) {
			log.info("Failed deleteTodos " + e);
		}
		return null;
	}
	
//	@GetMapping("s")
//	public JsonMessage getAllActiveTodos() {
//		try {
//			List<TodosTagsDto> allActive = todosTagsService.getAllActiveTodos();
//			if(allActive.size()>0)
//				return new JsonMessage("Success", "Data Exist", allActive);
//		} catch (Exception e) {
//			log.info("Failed getAllTodos " + e);
//		}
//		return message.showErrorMessage("Not Found");
//	}
//	
	
}
