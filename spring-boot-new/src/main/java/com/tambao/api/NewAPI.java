package com.tambao.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tambao.api.output.NewOutput;
import com.tambao.dto.NewDTO;
import com.tambao.service.INewService;

@CrossOrigin
@RestController
public class NewAPI {

	@Autowired
	private INewService newService;

	@GetMapping(value = "/new")
	public NewOutput showNew(@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "limit", required = false) Integer limit) {
		NewOutput result = new NewOutput();
		// Sử dụng required
		if (page != null & limit != null) {
			result.setPage(page);
			Pageable pageable = new PageRequest(page - 1, limit);
			result.setListResult(newService.findAll(pageable));
			result.setTotalPage((int) Math.ceil((double) (newService.totalItem()) / limit));
		} else {
			result.setListResult(newService.findAll());
		}

		// sử dụng defaultValue
		
		// Phải dùng chuỗi
		// -> defaultValue = "NONE"
//		if(!page.equals("NONE") && !limit.equals("NONE")) {
//			int pageParse = Integer.parseInt(page);
//			int limitParse = Integer.parseInt(limit);
//			result.setPage(pageParse);
//			Pageable pageable = new PageRequest(pageParse - 1, limitParse);
//			result.setListResult(newService.findAll(pageable));
//			result.setTotalPage((int) Math.ceil((double) (newService.totalItem()) / limitParse));
//		}else {
//			result.setListResult(newService.findAll());
//		}
		return result;
	}

	@PostMapping(value = "/new")
	public NewDTO createNew(@RequestBody NewDTO model) {
		return newService.save(model);
	}

	@PutMapping(value = "/new/{id}")
	public NewDTO updateNew(@RequestBody NewDTO model, @PathVariable("id") long id) {
		model.setId(id);
		return newService.save(model);
	}

	@DeleteMapping(value = "/new")
	public void deleteNew(@RequestBody long[] ids) {
		newService.delete(ids);
	}
}
