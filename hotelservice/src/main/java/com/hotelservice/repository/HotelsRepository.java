package com.hotelservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotelservice.Model.Hotels;

@Repository
public interface HotelsRepository extends JpaRepository<Hotels, String> {

}
