package com.example.NFJuara.controller;

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
import com.example.NFJuara.dto.TagsDto;
import com.example.NFJuara.model.Tags;
import com.example.NFJuara.service.TagsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@RestController
@RequestMapping(value = "/app/tag")
public class TagsController {
	
	
	private static final Logger log = LoggerFactory.getLogger(TagsController.class);
	private ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
	private JsonMessage message = new JsonMessage();

	private TagsService tagsService;
	
	@Autowired
	public TagsController(TagsService tagsService) {
		this.tagsService = tagsService;
	}
	
	@PostMapping("")
	public JsonMessage addTags(@RequestBody TagsDto dto) {
		try {
			if (null!=dto) {
				
				Tags data = tagsService.save(dto);
				
				return message.showSuccessMessage("Data Saved");
			}
		} catch (Exception e) {
			log.info("Failed addTags " + e);
			return message.showErrorMessage("Failed to Save Data");
		}
		return null;
	}
	
	@PutMapping("/{id}")
	public JsonMessage updateTags(@PathVariable Long id, @RequestBody TagsDto dto) {
		try {
			if (null!=dto) {
				dto.setId(id);
				Tags data = tagsService.save(dto);
				
				return new JsonMessage("Success", "Data Exist", data); 
			}
		} catch (Exception e) {
			log.info("error failed to add cause : " + e);
			return message.showErrorMessage("Failed to save Data");
		}
		return null;
	}
	
	@GetMapping("/{id}")
	public JsonMessage getTags(@PathVariable Long id) {
		try {
			TagsDto data = tagsService.getById(id);
			
			if (null!=data)
			return new JsonMessage("Success", "Data Exist", data); 
		} catch (Exception e) {
			// TODO: handle exception
		}
		return message.showErrorMessage("Not Found");
	}
	
	@DeleteMapping("/{id}")
	public JsonMessage deleteTags(@PathVariable Long id) {
		try {
			TagsDto data = tagsService.setInactive(id);
			if(null!=data)
				if(data.getIsActive()==1)
					return message.showSuccessMessage("Data Saved");
			
		} catch (Exception e) {
			log.info("Failed deleteTags " + e);
		}
		return null;
	}
	
	


}
