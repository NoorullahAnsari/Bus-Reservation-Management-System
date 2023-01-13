package com.revature.app;
import com.revature.menu.Menu;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Menu menu = new Menu();
		
		do {
			String ch;
			int choice=0;
			System.out.println("--------------------------------------------");
			System.out.println("	WELCOME TO IN MY BUS SERVICE");
			System.out.println("--------------------------------------------");
			System.out.println("\t1. LogIn\n\t2. Register\n\t3. Exit");
			System.out.print("\n\tEnter choice :\t");
			ch = sc.nextLine();
			try
		      {
				choice = Integer.parseInt(ch);
				
		      }
		      catch(Exception e)
		      {
		        choice=4;
		      }

			switch(choice) {
			case 1: menu.signIn(); break;
			//case 2: signUp(); break;
			case 3: System.exit(0);
			default: System.out.println("\tWrong input!!!!!!please choose correct option\n\n");
			}
			
		}while(true);

	}

}
