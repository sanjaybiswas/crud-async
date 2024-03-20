package com.crud.mysql.crudapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.crud.mysql.crudapp.entity.Guide;

@Repository
public interface GuideRepository extends CrudRepository<Guide, Long>{

}
