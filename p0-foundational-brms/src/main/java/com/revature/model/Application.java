package com.revature.model;
import com.revature.constants.Constant;
import com.revature.dao.imp.UserDaoImpl;
import com.revature.util.SymbolPrint;

import java.sql.*;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class Application {
private static final Logger logger=Logger.getLogger(Application.class);
	public static void main(String[] args) throws SQLException {		
		
		Scanner sc = new Scanner(System.in);
		UserDaoImpl  ud = new UserDaoImpl();
		
		do {
			String ch;
			int choice=0;
			System.out.println("\n");
			SymbolPrint.symbolPrint();
			logger.info("\t\t"+(char)0x2764+""+Constant.greeting+""+(char)0x2764);
			SymbolPrint.symbolPrint();
			logger.info("\n\t1. LogIn\n\t2. Exit");
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
				logger.info("\n\n\n\n\n\t\t\t"+(char)0x2764+ ""+Constant.thankYou+""+(char)0x2764);
				logger.info("\t\t\t#############");
				System.exit(0);
			default: logger.info("\t"+Constant.wrongInput+"\n\n");
			}
			
		}while(true);
		
	}

}
