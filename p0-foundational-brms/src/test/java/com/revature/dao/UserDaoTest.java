package com.revature.dao;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.Test;
import com.revature.config.DataBaseConnection;


public class UserDaoTest {
	
	private static Connection con = DataBaseConnection.getConnection();
	@Test
	public void DataBaseConnectionTest() {
		assertNotNull(DataBaseConnection.getConnection());
	}

	@Test
	public void logInTest() throws SQLException {
		String userid="U001";
		String password = "eshu@123";

		Statement stm = con.createStatement();
		ResultSet rs = stm.executeQuery("SELECT user_id, password FROM registration");
		if(rs.next()) {
			assertEquals(rs.getString(1), userid);
			assertEquals(rs.getString(2), password);
		}
	}
	
	
	
	
	
	@Test
	public void cancellation() throws SQLException {
		String tID = "T0013";
		Statement stm = con.createStatement();
		ResultSet rs = stm.executeQuery("SELECT ticket_id FROM cancellation");
		if(rs.next()) {
			assertEquals(rs.getString(1),tID);
		}
		rs.close();
	}
	
}
