package com.devsuperior.aulajparepository.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.aulajparepository.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

	List<User> findAll();

	/*JPQL*/
	
	@Query("SELECT obj FROM User obj WHERE obj.salary >= :minSalary AND obj.salary <= :maxSalary")
	Page<User> searchSalary(Double minSalary, Double maxSalary, Pageable pageable);
	
	@Query("SELECT obj FROM User obj WHERE LOWER(obj.name) LIKE LOWER(CONCAT('%',:name,'%'))")
	Page<User> searchName(String name, Pageable pageable);
	
	
	/*Query Methods*/
	
	Page<User> findBySalaryBetween(Double minSalary, Double maxSalary, Pageable pageable);
	
	Page<User> findByNameContainingIgnoreCase(String name, Pageable pageable);
	
}
