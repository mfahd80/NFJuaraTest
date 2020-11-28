package com.example.NFJuara.service.implement;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.NFJuara.dto.TodosTagsDto;
import com.example.NFJuara.model.TodosTags;
import com.example.NFJuara.repository.TodosTagsRepository;
import com.example.NFJuara.service.TodosTagsService;


@Service
public class TodosTagsServiceImpl implements TodosTagsService{

	private static final Logger log = LoggerFactory.getLogger(TodosServiceImpl.class);

	private TodosTagsRepository todosTagsRepository;
	
	@Autowired
	public TodosTagsServiceImpl(TodosTagsRepository todosTagsRepository) {
		this.todosTagsRepository = todosTagsRepository;
	}
	
	private TodosTagsDto toDto(TodosTags entity){
		try {
			if(null!=entity) {
				TodosTagsDto dto = new TodosTagsDto();
				dto.setId(entity.getId());
				dto.setTodos(entity.getTodo());
				dto.setTags(entity.getTags());
				
				return dto;
			}
			
		} catch (Exception e) {
			
		}
		
		return null;
	}
	
	@Override
	public Long getNum() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TodosTagsService save(TodosTagsDto dto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TodosTagsDto getById(Long pk) throws Exception {
		try {
			TodosTags entity = todosTagsRepository.getById(pk);
			return toDto(entity);
		} catch (Exception e) {
			log.info("Failed getById" + e);
		}
		return null;
	}

	@Override
	public Boolean delete(Long PK) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TodosTagsDto> getAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TodosTagsDto> getAllActiveTodos() {
		try {
			List<TodosTagsDto> dtoList = new ArrayList<>();
			List<TodosTags> dataList = todosTagsRepository.getByAllActive();
			if (null!=dataList && dataList.size() > 0)
				for (TodosTags todosTags : dataList) {
					dtoList.add(toDto(todosTags));
				}
			
			return dtoList;
				
		} catch (Exception e) {
			log.info("Failed getAllActiveTodos" + e);
		}
		return null;
	}

}
