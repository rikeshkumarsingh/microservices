package com.userservice.external.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.userservice.Model.Hotels;

@FeignClient(name = "HOTELSERVICE")
public interface HotelService {

	
	@GetMapping("/hotel/get/{hotelid}")
	Hotels getHotels(@PathVariable String hotelid); 
}
