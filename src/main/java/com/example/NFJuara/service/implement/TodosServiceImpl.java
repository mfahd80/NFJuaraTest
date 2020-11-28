package com.example.NFJuara.service.implement;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.NFJuara.dto.TodosDto;
import com.example.NFJuara.model.Todos;
import com.example.NFJuara.repository.TodosRepository;
import com.example.NFJuara.service.TodosService;

@Service
public class TodosServiceImpl implements TodosService{
	
	
	private static final Logger log = LoggerFactory.getLogger(TodosServiceImpl.class);

	
	private TodosRepository todosRepository;
	
	@Autowired
	public TodosServiceImpl(TodosRepository todosRepository) {
		this.todosRepository = todosRepository;
	}

	private Todos toEntity(TodosDto dto) {
		try {
			if(null!=dto) {
				Todos entity = new Todos();
				if(null!=dto.getId()) 
					entity=todosRepository.getById(dto.getId());
				
				entity.setName(dto.getName());
				entity.setIsActive(dto.getIsActive());
				entity.setIsFinished(dto.getIsFinished());
				
				return entity;
			}
		} catch (Exception e) {
			log.debug("failed toEntity cause  " + e);
		}
		return null;
	}
	
	private TodosDto toDto(Todos entity){
		try {
			if(null!=entity) {
				TodosDto dto = new TodosDto();
				dto.setId(entity.getId());
				dto.setName(entity.getName());
				dto.setIsActive(entity.getIsActive());
				dto.setIsFinished(entity.getIsFinished());
				dto.setCreatedAt(entity.getCreatedAt());
				dto.setUpdatedAt(entity.getUpdatedAt());
				log.info("entity to+ " +entity);
				log.info("entity to+ " +dto);
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
	public Todos save(TodosDto dto) throws Exception {
		try {
			Todos entity = new Todos();
			entity = toEntity(dto);
			entity.setUpdatedAt(Calendar.getInstance().getTime());
			
			if (null!=entity) entity = todosRepository.save(entity);
			
			return entity;
		} catch (Exception e) {
			log.info("failed save cause " +e);
		}
		return null;
	}

	@Override
	public TodosDto getById(Long pk) throws Exception {
		try {
			
			Todos data = todosRepository.getById(pk);
			
			if(null!=data) 
				return toDto(data);
			
		} catch (Exception e) {
			log.info("Failed getById " +e);
		}
		return null;
	}

	@Override
	public Boolean delete(Long PK) throws Exception {
		try {
			Todos data = todosRepository.getById(PK);
			data.setIsActive(1);
			
			data = todosRepository.save(data);
			
			return true;
			
		} catch (Exception e) {
			log.info("Failed setInactive " + e);
		}
		return false;
	}

	@Override
	public List<TodosDto> getAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TodosDto setInactive(Long id) {
		try {
			Todos data = todosRepository.getById(id);
			data.setIsActive(1);
			
			data = todosRepository.save(data);
			
			return toDto(data);
			
		} catch (Exception e) {
			log.info("Failed setInactive " + e);
		}
		return null;
	}


}
