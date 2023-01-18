package com.revature.menu;
import java.util.Scanner;
import com.revature.constants.Constant;
import com.revature.dao.imp.UserDaoImpl;

public class Menu {

	Scanner sc = new Scanner(System.in);


	public void menuForReservation() {
		UserDaoImpl udi = new UserDaoImpl();
		do {
			String ch;
			int choice = 0;

			System.out.println("===============================================================");
			System.out.println("\t1. Ticket cancellation \n\t2. Home Page");
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
				System.out.println("\t"+Constant.wrongInput+"\n\n");
			}
		} while (true);
	}
	
}
