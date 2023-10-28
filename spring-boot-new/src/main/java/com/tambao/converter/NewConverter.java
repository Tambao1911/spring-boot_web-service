package com.tambao.converter;

import org.springframework.stereotype.Component;

import com.tambao.dto.NewDTO;
import com.tambao.entity.NewEntity;

@Component
public class NewConverter {
	
	public NewEntity toEntity(NewDTO dto) {
		NewEntity entity = new NewEntity();
		entity.setTitle(dto.getTitle());
		entity.setContent(dto.getContent());
		entity.setThumbnail(dto.getThumbnail());
		entity.setShortDescription(dto.getShortDescription());
		return entity;
	}
	
	public NewDTO toDTO(NewEntity entity) {
		NewDTO dto = new NewDTO();
		if(entity.getId() != null) {
			dto.setId(entity.getId());
		}
		dto.setTitle(entity.getTitle());
		dto.setContent(entity.getContent());
		dto.setThumbnail(entity.getThumbnail());
		dto.setShortDescription(entity.getShortDescription());
		dto.setCreatedDate(entity.getCreatedDate());
		dto.setCreatedBy(entity.getCreatedBy());
		dto.setModifiedDate(entity.getModifiedDate());
		dto.setModifiedBy(entity.getModifiedBy());
		return dto;
	}
	
	public NewEntity toEntity(NewDTO dto, NewEntity entity) {
		entity.setTitle(dto.getTitle());
		entity.setContent(dto.getContent());
		entity.setThumbnail(dto.getThumbnail());
		entity.setShortDescription(dto.getShortDescription());
		return entity;
	}
}
