package com.ratingservice.serviceImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ratingservice.model.Rating;
import com.ratingservice.repository.RatingRepository;
import com.ratingservice.service.RatingService;

@Service
public class RatingServiceImpl implements RatingService {

	@Autowired
	RatingRepository ratingRepository;

	@Override
	public Rating saveRate(Rating rating) {
		String rateid=UUID.randomUUID().toString();
		rating.setRateid(rateid);
		Rating save = this.ratingRepository.save(rating);
		return save;
	}

	@Override
	public List<Rating> getall() {
		List<Rating> findAll = this.ratingRepository.findAll();
		return findAll;
	}

	@Override
	public Rating getById(String id) {
		Rating rating = this.ratingRepository.findById(id).get();
		return rating;
	}

	@Override
	public List<Rating> getByuserid(String userid) {
		List<Rating> findAllByUserid = this.ratingRepository.findAllByUserid(userid);
		return findAllByUserid;
	}

}
