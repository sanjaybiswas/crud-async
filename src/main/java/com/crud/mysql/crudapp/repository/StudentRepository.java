package com.crud.mysql.crudapp.repository;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import com.crud.mysql.crudapp.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	@Async
	Future<List<Student>> findByName(String name);
	@Async
	@Cacheable(cacheNames = "students")
	CompletableFuture<List<Student>> findByEnrlid(String enrlid);
}
