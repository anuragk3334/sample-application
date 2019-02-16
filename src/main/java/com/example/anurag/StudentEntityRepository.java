package com.example.anurag;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentEntityRepository extends CrudRepository<StudentEntity, Integer>,JpaRepository<StudentEntity, Integer>{
	
	Optional<List<StudentEntity>> findByName(String name);
	
	
	
	public List<StudentEntity> findByNameOrderByAge(String name);
	
	public List<StudentEntity> findByNameAndAge(String name, int age);
	
	

}
