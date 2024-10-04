package com.userservice.service;

import java.util.List;

import com.userservice.Model.Usermanagemant;

public interface UsermanagemantService {

	Usermanagemant saveuser(Usermanagemant usermanagemant);

	List<Usermanagemant> getAll();

	Usermanagemant getById(String id);

}
