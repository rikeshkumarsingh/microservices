package com.userservice.external.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.userservice.Model.Rating;

@FeignClient(name = "RATINGSERVICE")
public interface RatingService {
	
	
	@GetMapping("/rate/get/rating/{rateid}")
	Rating[] getRatings(@PathVariable String rateid );
	
	// for post mapping you can use same method as you use to call post mapping, put, delete

}
