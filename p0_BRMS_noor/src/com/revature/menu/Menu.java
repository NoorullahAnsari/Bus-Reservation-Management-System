package com.revature.menu;
import java.util.Scanner;

public class Menu {
	private String userid=null;
	private String password=null;
	Scanner sc = new Scanner(System.in);

	public void signIn() {
		System.out.print("\tPlease enter Userid :\t");
		userid = sc.nextLine();
		
		System.out.print("\tPlease enter password :\t");
		password = sc.nextLine();		

	}

	public void signUp() {
		

	}
}
