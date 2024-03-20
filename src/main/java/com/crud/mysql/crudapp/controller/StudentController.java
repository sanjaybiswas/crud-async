package com.crud.mysql.crudapp.controller;

import java.util.List;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.mysql.crudapp.entity.Student;
import com.crud.mysql.crudapp.repository.StudentRepository;

@RestController
@RequestMapping("/student")
public class StudentController {

	private final Logger logger = LoggerFactory.getLogger(StudentController.class);

	@Autowired
	StudentRepository studentRepo;

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
	//@Async
	public List<Student> getAllStudents() {
		return  studentRepo.findAll();
	}

	// creating a delete mapping that deletes a specified book
	@DeleteMapping("/delete/{studentid}")
	private void deleteStudent(@RequestBody Student student) {
		studentRepo.delete(student);
	}

	// creating post mapping that post the book detail in the database
	@PostMapping(value="/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	private long saveStudent(@RequestBody Student student) {
		if(studentRepo==null) {
			System.out.println("studentService is null");
		} else {
			System.out.println("studentService is not null");
		}
		studentRepo.save(student);
		return student.getId();
	}

	// creating put mapping that updates the book detail
	@PutMapping("/update")
	private Student updateStudent(@RequestBody Student student) {
		studentRepo.save(student);
		return student;
	}
}
