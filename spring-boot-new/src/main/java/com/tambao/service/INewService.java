package com.tambao.service;

import com.tambao.dto.NewDTO;

public interface INewService {
	NewDTO save(NewDTO newDTO);
	//NewDTO update(NewDTO newDTO);
	void delete(long[] ids);
}
