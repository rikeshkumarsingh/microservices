package com.hotelservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelservice.Model.Hotels;
import com.hotelservice.service.HotelsService;

@RestController
@RequestMapping("/hotel")
public class HotelsController {

	@Autowired
	HotelsService hotelsService;

	@PostMapping("/save")
	ResponseEntity<Hotels> saveHotels(@RequestBody Hotels hotels) {
		try {
			Hotels savehotels = this.hotelsService.savehotels(hotels);
			return new ResponseEntity<Hotels>(savehotels, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Hotels>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@GetMapping("/getall")
	ResponseEntity<List<Hotels>>GetAppHotel(){		
		try {
			List<Hotels> getallhotell = this.hotelsService.getallhotell();
			return new ResponseEntity<List<Hotels>>(getallhotell,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Hotels>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
	}
	
	@GetMapping("/get/{id}")
	ResponseEntity<Hotels>getById(@PathVariable String id){
		try {
			Hotels byId = this.hotelsService.getById(id);
			return new ResponseEntity<Hotels>(byId,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Hotels>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
	}

}
