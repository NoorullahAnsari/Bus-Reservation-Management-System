package com.revature.menu;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.constants.Constant;
import com.revature.dao.imp.UserDaoImpl;

public class Menu {
	private static final Logger logger =Logger.getLogger(Menu.class);

	Scanner sc = new Scanner(System.in);


	public void menuForReservation() throws SQLException {
		UserDaoImpl udi = new UserDaoImpl();
		do {
			String ch;
			int choice = 0;

			logger.info("===============================================================");
			logger.info("\t1. Ticket cancellation \n\t2. Home Page");
			System.out.print("\n\tEnter choice :\t");
			ch = sc.nextLine();
			try {
				choice = Integer.parseInt(ch);

			} catch (Exception e) {
				choice = 4;
			}

			switch (choice) {
			case 1:
				udi.cancellation();
				break;
			case 2:
				return;
			default:
				logger.info("\t"+Constant.wrongInput+"\n\n");
			}
		} while (true);
	}
	
}
