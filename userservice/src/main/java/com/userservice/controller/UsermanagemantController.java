package com.userservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userservice.Model.Usermanagemant;
import com.userservice.service.UsermanagemantService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/users")
public class UsermanagemantController {

	@Autowired
	UsermanagemantService usermanagemantService;

	@PostMapping("/save")
	ResponseEntity<Usermanagemant> saveuser(@RequestBody Usermanagemant usermanagemant) {
		try {
			Usermanagemant saveuser = this.usermanagemantService.saveuser(usermanagemant);
			return new ResponseEntity<Usermanagemant>(saveuser, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Usermanagemant>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getall")
	ResponseEntity<List<Usermanagemant>> getAll() {
		try {
			List<Usermanagemant> all = this.usermanagemantService.getAll();
			return new ResponseEntity<List<Usermanagemant>>(all, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Usermanagemant>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get/{id}")
//	@CircuitBreaker(name = "ratingHotleBreaker", fallbackMethod = "ratingHotelFallback")
//	@Retry(name = "ratingHotleBreaker", fallbackMethod = "ratingHotelFallback")
	@RateLimiter(name = "userRateLimiter", fallbackMethod = "ratingHotelFallback")
	public ResponseEntity<Usermanagemant> getById(@PathVariable String id) {
		try {
			Usermanagemant byId = this.usermanagemantService.getById(id);
			return new ResponseEntity<>(byId, HttpStatus.OK);
		} catch (Exception e) {
			// Log the exception for debugging
			System.err.println("Error occurred: " + e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<Usermanagemant> ratingHotelFallback(String id, Exception ex) {
		// Log the fallback for debugging
		System.out.println("Fallback method invoked due to: " + ex.getMessage());
		Usermanagemant build = Usermanagemant.builder().name("rikesh").phone("8405099999").about("service is down")
				.build();
		return new ResponseEntity<>(build, HttpStatus.OK);
	}

}
