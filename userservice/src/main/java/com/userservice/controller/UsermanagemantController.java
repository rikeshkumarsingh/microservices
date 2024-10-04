package com.userservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userservice.Model.Usermanagemant;
import com.userservice.service.UsermanagemantService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/users")
public class UsermanagemantController {
	
	@Autowired
	UsermanagemantService usermanagemantService;
	
	@PostMapping("/save")
	ResponseEntity<Usermanagemant>saveuser(@RequestBody Usermanagemant usermanagemant){
		try {
			Usermanagemant saveuser = this.usermanagemantService.saveuser(usermanagemant);
			return new ResponseEntity<Usermanagemant>(saveuser,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Usermanagemant>(HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}
	
	
	@GetMapping("/getall")
	ResponseEntity<List<Usermanagemant>>getAll(){
		try {
			List<Usermanagemant> all = this.usermanagemantService.getAll();
			return new ResponseEntity<List<Usermanagemant>>(all,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Usermanagemant>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}
	
	@GetMapping("/get/{id}")
	ResponseEntity<Usermanagemant>getById(@PathVariable String id){
		try {
			Usermanagemant byId = this.usermanagemantService.getById(id);
			return new ResponseEntity<Usermanagemant>(byId, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Usermanagemant>( HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	

}
