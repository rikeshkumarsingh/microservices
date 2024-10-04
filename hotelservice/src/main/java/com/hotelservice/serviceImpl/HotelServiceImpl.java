package com.hotelservice.serviceImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelservice.Model.Hotels;
import com.hotelservice.repository.HotelsRepository;
import com.hotelservice.service.HotelsService;

@Service
public class HotelServiceImpl implements HotelsService {
	
	@Autowired
	HotelsRepository hotelsRepository;

	@Override
	public Hotels savehotels(Hotels hotels) {
		String hoteId=UUID.randomUUID().toString();
		hotels.setId(hoteId);
		Hotels save = this.hotelsRepository.save(hotels);
		return save;
	}

	@Override
	public List<Hotels> getallhotell() {
		List<Hotels> findAll = this.hotelsRepository.findAll();
		return findAll;
	}

	@Override
	public Hotels getById(String id) {
	 Hotels hotels = this.hotelsRepository.findById(id).get();
		return hotels;
	}

}
