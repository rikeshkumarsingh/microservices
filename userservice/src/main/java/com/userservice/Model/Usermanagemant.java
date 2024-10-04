package com.userservice.Model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Usermanagemant {

	@Id
	private String userid;
	private String name;
	private String phone;
	private String about;

	@Transient
	private List<Rating> ratings = new ArrayList<>();

}
