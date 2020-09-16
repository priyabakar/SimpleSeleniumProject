package com.Chiller.Pom.Utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.Chiller.Pom.Model.FormSignUp;

public class DatabaseConnect {

	private static Connection getMySQLConnection() {

		Connection connect = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			connect = DriverManager
					.getConnection("jdbc:mysql://localhost/bptdev?" + "user=root1&password=root1");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return connect;
	}

	public static Connection getFormSignupData() {
		
		return getMySQLConnection();
	}
	
    public static List<FormSignUp> getFormData(Connection con) {
		FormSignUp formSignUp = null;
		List<FormSignUp> list=new ArrayList<FormSignUp>(); 
    	Statement st;
		try {
			st = con.createStatement();
	    	String sql = ("SELECT * FROM bptdev.form_signup");
	    	ResultSet rs = st.executeQuery(sql);
  
	    	while(rs.next()) { 	 
	    		formSignUp = new FormSignUp();
	    	 formSignUp.setFirstName(rs.getString("first_name"));
	    	 formSignUp.setLastName(rs.getString("last_name"));
	    	 formSignUp.setAddress( rs.getString("address"));
	    	 formSignUp.setZipCode(rs.getInt("zipcode"));
	    	 list.add(formSignUp);
	    	}
            
	    	con.close();
	    	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    	return list;
	}
	
}
