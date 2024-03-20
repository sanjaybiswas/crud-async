package com.crud.mysql.crudapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.crud.mysql.crudapp.entity.Student;
import com.crud.mysql.crudapp.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository repository;
	
	@Cacheable(cacheNames = "students")
	public List<Student> getAllStudents() {
		List<Student> students = new ArrayList<>();
		repository.findAll().forEach(books1 -> students.add(books1));

		return students;
	}

	@Cacheable(cacheNames = "studentId")
	public Student getById(long studentId) {
		return repository.findById(studentId).get();
	}

	@Cacheable(cacheNames = "student", key = "#id")
	public void delete(long studentId) {
		repository.deleteById(studentId);
	}

	public void saveOrUpdate(Student student) {
		repository.save(student);
	}
}
