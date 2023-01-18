package com.revature.model;
import com.revature.constants.Constant;
import com.revature.dao.imp.UserDaoImpl;
import com.revature.util.SymbolPrint;

import java.sql.*;
import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//System.out.println("Driver Loaded");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BRMS","root","Noor@12345");
			//System.out.println("Connection Established");
		}
		catch(ClassNotFoundException | SQLException e) {
			System.out.println("Exception"+e.getMessage());
		}
		Scanner sc = new Scanner(System.in);
		UserDaoImpl  ud = new UserDaoImpl();
		
		do {
			String ch;
			int choice=0;
			System.out.println();
			SymbolPrint.symbolPrint();
			System.out.println("\t\t"+(char)0x2764+""+Constant.greeting+""+(char)0x2764);
			SymbolPrint.symbolPrint();
			System.out.println("\n\t1. LogIn\n\t2. Exit");
			System.out.print("\n\tEnter choice :\t");
			ch = sc.nextLine();
			try
		      {
				choice = Integer.parseInt(ch);
				
		      }
		      catch(Exception e)
		      {
		        choice=1000;
		      }

			switch(choice) {
			case 1:ud.logIn(); break;
			case 2:

				try {
					sc.close();
					con.close();
				}
				catch(SQLException e) {
				}
				System.out.println("\n\n\n\n\n\t\t\t"+(char)0x2764+ ""+Constant.thankYou+""+(char)0x2764);
				System.out.println("\t\t\t#############");
				System.exit(0);
			default: System.out.println("\t"+Constant.wrongInput+"\n\n");
			}
			
		}while(true);
		
	}

}
