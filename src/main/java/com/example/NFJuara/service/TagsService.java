package com.example.NFJuara.service;

import com.example.NFJuara.dto.TagsDto;
import com.example.NFJuara.model.Tags;

public interface TagsService extends CommonService<Tags, TagsDto, Long> {

	TagsDto setInactive(Long id);
}
