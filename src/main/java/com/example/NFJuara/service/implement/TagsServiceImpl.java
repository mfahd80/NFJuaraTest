package com.example.NFJuara.service.implement;

import java.util.Calendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.NFJuara.dto.TagsDto;
import com.example.NFJuara.model.Tags;
import com.example.NFJuara.repository.TagsRepository;
import com.example.NFJuara.service.TagsService;

@Service
public class TagsServiceImpl implements TagsService{
	
	private static final Logger log = LoggerFactory.getLogger(TodosServiceImpl.class);

	
	private TagsRepository tagsRepository;
	
	@Autowired
	public TagsServiceImpl(TagsRepository tagsRepository) {
		this.tagsRepository = tagsRepository;
	}

	private Tags toEntity(TagsDto dto) {
		try {
			if(null!=dto) {
				Tags entity = new Tags();
				if(null!=dto.getId()) 
					entity=tagsRepository.getById(dto.getId());
				
				entity.setName(dto.getName());
				entity.setIsActive(dto.getIsActive());
				
				return entity;
			}
		} catch (Exception e) {
			log.debug("failed toEntity cause  " + e);
		}
		return null;
	}
	
	private TagsDto toDto(Tags entity){
		try {
			if(null!=entity) {
				TagsDto dto = new TagsDto();
				dto.setId(entity.getId());
				dto.setName(entity.getName());
				dto.setIsActive(entity.getIsActive());
				dto.setCreatedAt(entity.getCreatedAt());
				dto.setUpdatedAt(entity.getUpdatedAt());
				
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
	public Tags save(TagsDto dto) throws Exception {
		try {
			Tags entity = new Tags();
			entity = toEntity(dto);
			entity.setUpdatedAt(Calendar.getInstance().getTime());
			
			if (null!=entity) entity = tagsRepository.save(entity);
			
			return entity;
		} catch (Exception e) {
			log.info("failed save cause " +e);
		}
		return null;
	}

	@Override
	public TagsDto getById(Long pk) throws Exception {
		try {
			
			Tags data = tagsRepository.getById(pk);
			
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
			Tags data = tagsRepository.getById(PK);
			data.setIsActive(1);
			
			data = tagsRepository.save(data);
			
			return true;
			
		} catch (Exception e) {
			log.info("Failed setInactive " + e);
		}
		return false;
	}

	@Override
	public List<TagsDto> getAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TagsDto setInactive(Long id) {
		try {
			Tags data = tagsRepository.getById(id);
			data.setIsActive(1);
			
			data = tagsRepository.save(data);
			
			return toDto(data);
			
		} catch (Exception e) {
			log.info("Failed setInactive " + e);
		}
		return null;
	}

}
