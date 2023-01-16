package com.revature.menu;
import java.sql.Connection;
import java.sql.*;
import java.util.Scanner;

import com.revature.constants.Constant;

public class Menu {
	private String userid = null;
	private String password = null;
	Scanner sc = new Scanner(System.in);

	// ************************* LogIn For Both Admin and User  ************************************

	public void LogIn() {
		do {
			String ch;
			int choice = 0;

			System.out.println("===============================================================");
			System.out.println("\t1. LogIn as admin\n\t2. LogIn as user\n\t3. back");
			System.out.print("\n\tEnter choice :\t");
			ch = sc.nextLine();
			try {
				choice = Integer.parseInt(ch);

			} catch (Exception e) {
				choice = 4;
			}

			switch (choice) {
			case 1:
				LogInAsAdmin();
				break;
			case 2:
				LogInAsUser();
				break;
			case 3:
				return;
			default:
				System.err.println("\t"+Constant.wrongInput+"\n\n");
			}
		} while (true);
	}

	// ******************* LogIn As Admin  **********************************************************

	public void LogInAsAdmin() {

		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BRMS", "root", "Noor@12345");
			// System.out.println("Connection Established");

			System.out.println("\tPlease enter userId :\t");
			userid = sc.nextLine();

			System.out.println("\tPlease enter password :\t");
			password = sc.nextLine();

			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("SELECT * FROM Admin");
			if (rs.next()) {
				if (userid.equals(rs.getString(1)) && password.equals(rs.getString(2))) {
					System.out.println("\n\n\n\tWelcome Sir");
					menuForAdmin();
				} else {
					System.err.println("\t"+Constant.error);
				}
			} else {
				System.err.println("\t"+Constant.error);
			}

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Exception" + e.getMessage());
		}
		try {
			con.close();
		} catch (SQLException e) {}

	}

	// ******************** Menu For Admin  *************************************************

	public void menuForAdmin() {
		do {
			String ch;
			int choice = 0;

			System.out.println("===============================================================");
			System.out.println("\t1. Bus \n\t2. Route\n\t3. Trip \n\t4. back");
			System.out.print("\n\tEnter choice :\t");
			ch = sc.nextLine();
			try {
				choice = Integer.parseInt(ch);

			} catch (Exception e) {
				choice = 4;
			}

			switch (choice) {
			// case 1: busInformation(); break;
			// case 2: routeInformation(); break;
			// case 3: tripInformation(); break;
			 case 4: return;
			default:
				System.err.println("\t"+Constant.wrongInput+"\n\n");
			}
		} while (true);

	}

	// ************************* LogIn As User  *********************************************

	public void LogInAsUser() {

		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BRMS", "root", "Noor@12345");
			// System.out.println("Connection Established");

			System.out.println("\tPlease enter userId");
			userid = sc.nextLine();
			System.out.println("\tPlease enter password");
			password = sc.nextLine();

			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("SELECT * FROM UserRegistration");
			if (rs.next()) {
				if (userid.equals(rs.getString(1)) && password.equals(rs.getString(2))) {
					System.out.println("\n\n\n\t\tWelcome Sir");
					//tripUser();   //*************************  tripUser
				} else {
					System.err.println("\t"+Constant.greeting);
				}
			} else {
				System.err.println("\t"+Constant.greeting);
			}

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Exception" + e.getMessage());
		}
		try {
			con.close();
		} catch (SQLException e) {}

	}

	

	// **********************For Register**********************************
	public void register() {
		// signUp(); //call this method of UserRegistration class

	}

}
