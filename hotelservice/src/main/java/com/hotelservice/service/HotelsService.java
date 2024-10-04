package com.hotelservice.service;

import java.util.List;

import com.hotelservice.Model.Hotels;

public interface HotelsService {

	Hotels savehotels(Hotels hotels);

	List<Hotels> getallhotell();

	Hotels getById(String id);

}
