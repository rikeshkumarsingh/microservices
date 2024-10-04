package com.ratingservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Rating {
	
	@Id
	private String rateid;
	private String userid;
	private String hotelid;
	private int rating;
	private String feedback;
	
	

}
