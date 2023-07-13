package com.demo.jpa.service;


import java.sql.Date;
import java.util.Calendar;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.jpa.model.JPAModel;
import com.demo.jpa.model.Response;
import com.demo.jpa.repository.JPARepository;

@Service
public class JPAService {

	// method implementation

	
	@PersistenceContext
	private EntityManager entitymanager;
	
	Response res = new Response();
	@Autowired
	private JPARepository jpaRepository;
	
	


	public Response addUser(JPAModel add) {
          String uuid = UUID.randomUUID().toString();
          add.setsNo(uuid);
          
          Date date = new Date(Calendar.getInstance().getTime().getTime());
          add.setCreatedDate(date);
          add.setUpdatedDate(date);
          add.setCreatedBy(uuid);
          add.setUpdatedBy(uuid);
           
          try {
			 jpaRepository.save(add);
			res.setData("user created Successfully");
			res.setResponseCode(200);
			res.setResponseMsg("Success");
			
		} catch (Exception e) {
			
			e.printStackTrace();
			res.setData("cannot able to insert user");
			res.setResponseCode(500);
			res.setResponseMsg("error");
		}
		return res;
	}

	public Response getAllUser() {
		return res;

	}

	public Response getUser(String sNo) {
		
		
		  try {
				 jpaRepository.getReferenceById(sNo);
				res.setData("user created Successfully");
				res.setResponseCode(200);
				res.setResponseMsg("Success");
				
			} catch (Exception e) {
				
				e.printStackTrace();
				res.setData("cannot able to insert user");
				res.setResponseCode(500);
				res.setResponseMsg("error");
			}
		return res;

	}

	public Response updateUser(JPAModel update) {
		return res;

	}

	public Response deleteUser(String delete) {
		
		   try {
				 jpaRepository.deleteById(delete);;
				res.setData("user created Successfully");
				res.setResponseCode(200);
				res.setResponseMsg("Success");
				
			} catch (Exception e) {
				
				e.printStackTrace();
				res.setData("cannot able to insert user");
				res.setResponseCode(500);
				res.setResponseMsg("error");
			}
		
		return res;

	}

}
