package com.hotelservice.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Hotels {
	
	@Id
	private String id;
	private String name;
	private String location;
	private String about;
	

}
