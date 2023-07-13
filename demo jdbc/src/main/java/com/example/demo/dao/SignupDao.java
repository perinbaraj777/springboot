
package com.example.demo.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Component;
import com.example.demo.model.Response;
import com.example.demo.model.SignupModel;
import com.example.demo.service.SignupService;

@Component
public class SignupDao implements SignupService {

	Response res = new Response();

	String url = "jdbc:mysql://127.0.0.1:3306/kgm";
	String username = "root";
	String password = "Root";

	@Override
	public Response addUsers(SignupModel data) {

		String uuid = UUID.randomUUID().toString(); // uuid is universal unique id creation
		data.setsNo(uuid);
		data.setCreatedBy(uuid);
		data.setUpdatedBy(uuid);
		Date date = new Date(Calendar.getInstance().getTime().getTime());
		data.setCreatedDate(date);
		data.setUpdatedDate(date);

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// con , st are objects reference new keyword is not necessary for manadatory
			// for creating object for db connection

			try (Connection con = DriverManager.getConnection(url, username, password); // connnection and statement are
																						// predefined class and
																						// innterface

					Statement st = con.createStatement();) {

				if (data.getMailId().contains("@gmail.com")) {
					char firstValue = String.valueOf(data.getMobileNumber()).charAt(0);

					// if (String.valueOf(data.getMobileNumber()).length()==10 && firstValue=='6' ||
					// firstValue=='7' || firstValue=='8' ||firstValue=='9') {

					// second method of number validation
					if (data.getMobileNumber() >= 6000000000L && data.getMobileNumber() <= 9999999999L) {
						String insertQuery = "INSERT INTO user_details (s_no , first_name , last_name , age , mail_Id , password , mobile_number , dob , updated_date , created_date , created_by , updated_by )VALUES('"
								+ data.getsNo() + "','" + data.getFirstName() + "','" + data.getLastName() + "',"
								+ data.getAge() + ",'" + data.getMailId() + "','" + data.getPassword() + "',"
								+ data.getMobileNumber() + "," + data.getDob() + "," + data.getUpdatedDate() + ","
								+ data.getCreatedDate() + ",'" + data.getCreatedBy() + "','" + data.getUpdatedBy()
								+ "');"; // ''
											// for
											// database,""for
											// java,++for
											// adding
											// value

						System.out.println(insertQuery);
						st.executeUpdate(insertQuery); // for insert update delete (executeUpdate) is used (for which
														// modifies
														// the data table)
														// while using get only use (executeQurey)

						res.setData("Created Successfully!!");
						res.setResponseCode(200);

						res.setResponseMsg("success");
					} else {
						res.setData("Invalid mail!!");
						res.setResponseCode(500);
						res.setResponseMsg("error");
					}

				} else {
					res.setData("Invalid mail!!");
					res.setResponseCode(500);
					res.setResponseMsg("error");
				}
			} catch (Exception e) {
				e.printStackTrace();
				res.setData("Not Created Successfully!!");
				res.setResponseCode(500);
				res.setResponseMsg("error");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public Response deleteUsers(SignupModel remove) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			try (Connection con = DriverManager.getConnection(url, username, password); // connnection and statement are
																						// predefined class and
																						// innterface

					Statement st = con.createStatement();) {

				String deleteQuery = "delete from user_details where s_no='" + remove.getsNo() + "';";
				System.out.println(deleteQuery);
				st.executeUpdate(deleteQuery);

				res.setData("data deleted Successfully!!");
				res.setResponseCode(200);

				res.setResponseMsg("success");

			} catch (Exception e) {
				e.printStackTrace();
				res.setData("process failed!!");
				res.setResponseCode(500);
				res.setResponseMsg("error");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return res;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Response getAllUsers() {

		JSONArray jsonArray = new JSONArray(); // json arry is used to get all users detail in json format in a single
												// array

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try (Connection con = DriverManager.getConnection(url, username, password);
					Statement st = con.createStatement();) {

				String getallQuery = "select * from user_details";
				ResultSet rs = st.executeQuery(getallQuery);
				while (rs.next()) {
					JSONObject jsonObject = new JSONObject();
					jsonObject.put("sNo", rs.getString("s_no"));
					jsonObject.put("firstName", rs.getString("first_name"));
					jsonObject.put("lastName", rs.getString("last_name"));
					jsonObject.put("emailId", rs.getString("mail_Id"));
					jsonObject.put("password", rs.getString("password"));
					jsonObject.put("dob", rs.getString("dob"));
					jsonObject.put("age", rs.getInt("age"));
					jsonObject.put("mobileNumber", rs.getLong("mobile_number"));
					jsonObject.put("createdDate", rs.getString("created_date"));
					jsonObject.put("updatedDate", rs.getString("updated_date"));
					jsonObject.put("createdBy", rs.getString("created_by"));
					jsonObject.put("updatedBy", rs.getString("updated_by"));

					jsonArray.add(jsonObject);

				}
				res.setData("users fetched successfully");
				res.setjData(jsonArray);
				res.setResponseMsg("success");
				res.setResponseCode(200);
			} catch (Exception e) {
				e.printStackTrace();
				res.setData("users not fetched successfully");
				res.setResponseMsg("error");
				res.setResponseCode(500);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return res;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Response getUsersById(String sNo) {

		JSONArray jsonArray = new JSONArray(); // json arry is used to get all users detail in json format in a single
		// array

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try (Connection con = DriverManager.getConnection(url, username, password);
					Statement st = con.createStatement();) {

				String getallQuery = "select * from user_details where s_no = '"+sNo+"'";
				ResultSet rs = st.executeQuery(getallQuery);
				while (rs.next()) {
					JSONObject jsonObject = new JSONObject();
					jsonObject.put("sNo", rs.getString("s_no"));
					jsonObject.put("firstName", rs.getString("first_name"));
					jsonObject.put("lastName", rs.getString("last_name"));
					jsonObject.put("emailId", rs.getString("mail_Id"));
					jsonObject.put("password", rs.getString("password"));
					jsonObject.put("dob", rs.getString("dob"));
					jsonObject.put("age", rs.getInt("age"));
					jsonObject.put("mobileNumber", rs.getLong("mobile_number"));
					jsonObject.put("createdDate", rs.getString("created_date"));
					jsonObject.put("updatedDate", rs.getString("updated_date"));
					jsonObject.put("createdBy", rs.getString("created_by"));
					jsonObject.put("updatedBy", rs.getString("updated_by"));

					jsonArray.add(jsonObject);
					

				}
				res.setData("users fetched successfully");
				res.setjData(jsonArray);
				res.setResponseMsg("success");
				res.setResponseCode(200);
			} catch (Exception e) {
				e.printStackTrace();
				res.setData("users not fetched successfully");
				res.setResponseMsg("error");
				res.setResponseCode(500);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return res;
	}

	@Override
	public Response updatetUsers(SignupModel modify) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try (Connection con = DriverManager.getConnection(url, username, password);
					Statement st = con.createStatement();) {

				String updateQuery = "update user_details set first_name='" + modify.getFirstName() + "',last_name='"
						+ modify.getLastName() + "' where s_no='" + modify.getsNo() + "';";
				System.out.println(updateQuery);
				st.executeUpdate(updateQuery);

				res.setData("updated successfully");
				res.setResponseCode(200);
				res.setResponseMsg("success");

			} catch (Exception e) {

				e.printStackTrace();
				res.setData("process failed");
				res.setResponseCode(500);
				res.setResponseMsg("error");
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		return res;
	}

}
