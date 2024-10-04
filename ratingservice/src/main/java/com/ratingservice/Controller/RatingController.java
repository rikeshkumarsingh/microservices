package com.ratingservice.Controller;

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

import com.ratingservice.model.Rating;
import com.ratingservice.service.RatingService;

@RestController
@RequestMapping("/rate")
public class RatingController {
	
	@Autowired
	RatingService ratingService;
	
	@PostMapping("/save")
	ResponseEntity<Rating> saveRating(@RequestBody Rating rating){
		try {
			Rating saveRate = this.ratingService.saveRate(rating);
			return new ResponseEntity<Rating>(saveRate,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Rating>(HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}
	
	@GetMapping("/getall")
	ResponseEntity<List<Rating>>getAll(){
		List<Rating> getall = this.ratingService.getall();
		return new ResponseEntity<List<Rating>>(getall, HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	ResponseEntity<Rating>getByid(@PathVariable String id){
		try {
			Rating byId = this.ratingService.getById(id);
			return new ResponseEntity<Rating>(byId,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Rating>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	@GetMapping("/get/rating/{userid}")
	ResponseEntity<List<Rating>>getByUserId(@PathVariable String userid){
		try {
			 List<Rating> byuserid = this.ratingService.getByuserid(userid);
			return new ResponseEntity<List<Rating>>(byuserid,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Rating>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	

}
