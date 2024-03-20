package com.crud.mysql.crudapp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.crud.mysql.crudapp.dto.StudentRequest;
import com.crud.mysql.crudapp.entity.Student;
import com.crud.mysql.crudapp.repository.StudentRepository;

public class MappingService {

	@Autowired
	private StudentRepository studentRepository;

	// create getAllUsersLocation() method that returns a list of UserLocationDTO
	public List<StudentRequest> getAllUsersLocation() {
		return ((List<Student>) studentRepository.findAll()).stream().map(this::convertDataIntoDTO)
				.collect(Collectors.toList());
	}

	// create convertDataIntoDTO() method that returns UserLocationDTO
	private StudentRequest convertDataIntoDTO(Student userData) {

		// create instance of our UserLocationDTO class
		StudentRequest dto = new StudentRequest();

		// set username and userId in dto from the userData
		dto.setStudentId(userData.getId());
		dto.setStudentName(userData.getName());

		// create instance of the Location class
		//Location loc = userData.getLocation();

		// set latitude, longitude, and place in dto from location
//		dto.setLat(loc.getLat());
//		dto.setLng(loc.getLng());
//		dto.setPlace(loc.getPlace());
		return dto;
	}

}
