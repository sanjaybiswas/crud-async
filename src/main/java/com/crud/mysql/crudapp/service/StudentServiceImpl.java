package com.crud.mysql.crudapp.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;

import com.crud.mysql.crudapp.entity.Student;
import com.crud.mysql.crudapp.repository.StudentRepository;

public class StudentServiceImpl //implements StudentService 
{

	@Autowired
	StudentRepository repository;

	public List<Student> getAllStudents() {
		List<Student> students = new ArrayList<>();
		repository.findAll().forEach(books1 -> students.add(books1));
		
		return students;
	}

	public Student getById(long studentId) {
		return repository.findById(studentId).get();
	}

	public void delete(long studentId) {
		repository.deleteById(studentId);
	}

	public void saveOrUpdate(Student student) {
		repository.save(student);
	}
	
}
