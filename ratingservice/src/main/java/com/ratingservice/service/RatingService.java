package com.ratingservice.service;

import java.util.List;

import com.ratingservice.model.Rating;

public interface RatingService {

	Rating saveRate(Rating rating);

	List<Rating> getall();

	Rating getById(String id);

	List<Rating> getByuserid(String userid);

}
