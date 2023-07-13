package com.demo.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.demo.jpa.model.JPAModel;

@Repository
public interface JPARepository extends JpaRepository<JPAModel,String>{

	//nothing	
}

