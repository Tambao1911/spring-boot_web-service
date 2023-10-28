package com.tambao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tambao.converter.NewConverter;
import com.tambao.dto.NewDTO;
import com.tambao.entity.CategoryEntity;
import com.tambao.entity.NewEntity;
import com.tambao.repository.CategoryRepository;
import com.tambao.repository.NewRepository;
import com.tambao.service.INewService;

@Service
public class NewService implements INewService {

	@Autowired
	private NewRepository newRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private NewConverter newConverter;

	@Override
	public NewDTO save(NewDTO newDTO) {
		NewEntity newEntity = new NewEntity();
		if(newDTO.getId() != null) {
			NewEntity oldNewEntity = newRepository.findOne(newDTO.getId());
			newEntity = newConverter.toEntity(newDTO, oldNewEntity);
		}else {
			newEntity = newConverter.toEntity(newDTO);
		}
		CategoryEntity categoryEntity = categoryRepository.findOneByCode(newDTO.getCategoryCode());
		newEntity.setCategory(categoryEntity);
		newEntity = newRepository.save(newEntity);
		return newConverter.toDTO(newEntity);
	}

//	@Override
//	public NewDTO update(NewDTO newDTO) {
//		NewEntity oldNewEntity = newRepository.findOne(newDTO.getId());
//		NewEntity newEntity = newConverter.toEntity(newDTO, oldNewEntity);
//		CategoryEntity categoryEntity = categoryRepository.findOneByCode(newDTO.getCategoryCode());
//		newEntity.setCategory(categoryEntity);
//		newEntity = newRepository.save(newEntity);
//		return newConverter.toDTO(newEntity);
//	}
}
