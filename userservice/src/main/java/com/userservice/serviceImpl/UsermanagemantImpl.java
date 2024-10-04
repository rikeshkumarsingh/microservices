package com.userservice.serviceImpl;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.hibernate.annotations.Collate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.userservice.Model.Hotels;
import com.userservice.Model.Rating;
import com.userservice.Model.Usermanagemant;
import com.userservice.external.service.HotelService;
import com.userservice.external.service.RatingService;
import com.userservice.repository.UsermanagemantRepository;
import com.userservice.service.UsermanagemantService;

@Service
public class UsermanagemantImpl implements UsermanagemantService {

	@Autowired
	UsermanagemantRepository usermanagemantRepository;

	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	HotelService hotelService;
	
	@Autowired
	RatingService ratingService;

	Logger log = LoggerFactory.getLogger(UsermanagemantImpl.class);

	@Override
	public Usermanagemant saveuser(Usermanagemant usermanagemant) {
		String userId = UUID.randomUUID().toString();
		usermanagemant.setUserid(userId);
		Usermanagemant save = this.usermanagemantRepository.save(usermanagemant);
		return save;
	}

	@Override
	public List<Usermanagemant> getAll() {
		List<Usermanagemant> findAll = this.usermanagemantRepository.findAll();
		return findAll;
	}

	@Override
	public Usermanagemant getById(String id) {
		// Fetch the user by ID, handle Optional properly to avoid
		// NoSuchElementException
		Usermanagemant usermanagemant = this.usermanagemantRepository.findById(id).get();

		// Fetch ratings for the user from the Rating Service
//		String ratingUrl = "http://RATINGSERVICE/rate/get/rating/" + id;
//		Rating[] ratingOfUser = this.restTemplate.getForObject(ratingUrl, Rating[].class);
		
		Rating[] ratingOfUser = this.ratingService.getRatings(id);

		// Convert Rating[] to List<Rating>
		List<Rating> list = Arrays.stream(ratingOfUser).toList();

		// Map ratings to include hotel information
		List<Rating> collect = list.stream().map(rating -> {
			// Dynamic hotel URL based on rating's hotelId
//			String hotelUrl = "http://HOTELSERVICE/hotel/get/afab1d9b-7b14-40ef-a719-0fa2ade5285d";
//			String hotelUrl = "http://HOTELSERVICE/hotel/get/"+rating.getHotelid();

			// Fetch the hotel information for each rating
//			Hotels hotel = this.restTemplate.getForObject(hotelUrl, Hotels.class);
			Hotels hotel = this.hotelService.getHotels(rating.getHotelid()); 

			// Set the fetched hotel to the rating
			rating.setHotels(hotel);

			return rating;
		}).collect(Collectors.toList());

		// Set the ratings to the usermanagemant object
		usermanagemant.setRatings(collect);
		return usermanagemant;
	}

}
