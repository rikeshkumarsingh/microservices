package com.hotelservice.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/staffs")
public class StaffsController {
	
	@GetMapping("/get")
	ResponseEntity<List<String>>getStaff(){
		List<String> asList = Arrays.asList("riku","miku","ram","tony");
		return new ResponseEntity<List<String>>(asList,HttpStatus.OK);
	}

}
