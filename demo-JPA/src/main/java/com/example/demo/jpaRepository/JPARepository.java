package com.example.demo.jpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.JpaModel;

@Repository
public interface JPARepository extends JpaRepository<JpaModel, String> {

}
