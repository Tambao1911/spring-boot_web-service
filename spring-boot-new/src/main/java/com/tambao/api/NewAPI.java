package com.tambao.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tambao.dto.NewDTO;
import com.tambao.service.INewService;

@CrossOrigin
@RestController
public class NewAPI {

	@Autowired
	private INewService newService;
	
	@PostMapping("/new")
    public NewDTO createNew(@RequestBody NewDTO model) {
            return newService.save(model);
    }
	
	@PutMapping("/new")
	public NewDTO updateNew(@RequestBody NewDTO model) {
		return model;
	}
	
	@DeleteMapping("/new")
	public void deleteNew(long []ids) {
		
	}
}

