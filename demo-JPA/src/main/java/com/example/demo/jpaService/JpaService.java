package com.example.demo.jpaService;

import java.sql.Date;
import java.util.Calendar;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.jpaRepository.JPARepository;
import com.example.demo.model.JpaModel;
import com.example.demo.model.Response;

@Service
public class JpaService {
	@PersistenceContext
	private EntityManager entitymanager;

	Response res = new Response();
	@Autowired
	private JPARepository jpaRepositry;

	public Response addUsers(JpaModel add) {
		String uuid = UUID.randomUUID().toString();
		add.setsNo(uuid);
		add.setCreatedBy(uuid);
		add.setUpdatedBy(uuid);

		Date date = new Date(Calendar.getInstance().getTime().getTime());
		add.setCreatedDate(date);
		add.setUpdatedDate(date);

		try {
			jpaRepositry.save(add);
			res.setData(" user inserted successfully");
			res.setResponseCode(200);
			res.setResponseMsg("success");

		} catch (Exception e) {
			e.printStackTrace();
			res.setData("cannot able to insert user");
			res.setResponseCode(500);
			res.setResponseMsg("error");

		}

		return res;
	}

	public Response deleteUsers(String remove) {

		return res;
	}

	public Response updateUsers(JpaModel modify) {

		return res;
	}

	public Response getAllUsers() {

		return res;
	}

	public Response getUsers(String sNo) {

		return res;
	}

}
