package com.ratingservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ratingservice.model.Rating;

public interface RatingRepository extends JpaRepository<Rating, String>{

	List<Rating> findAllByUserid(String userid);

}
