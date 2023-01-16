package com.revature.menu;
import java.util.Scanner;
import com.revature.dao.imp.UserDaoImpl;
import com.revature.model.User;

public class UserMenu {

	public static void main(String[] args) {
		UserDaoImpl user = new UserDaoImpl();
		Scanner scan = new Scanner(System.in);
		
		do {
			System.out.println("----Select from below options for User registration----");
			System.out.println("1.Add User Details");
			System.out.println("2.Update User Details");
			System.out.println("3.Delete User Details");
			System.out.println("4.Display User Details");
			System.out.println("5.Exit\n");
			System.out.println("Enter your choice: ");
			
			int choice = scan.nextInt();
			scan.nextLine();
			
			switch(choice)
			{
			case 1:
				user.addUserDetails();
				break;
			case 2:
				System.out.println("Enter UserId you want to update:");
				String uID=scan.nextLine();
				for(User i:UserDaoImpl.usersList) {
					if(i.getUserId().equals(uID)) {
						user.updateUserDetails(i);
						break;
					}
				}
				
				break;
			case 3:
				System.out.println("Enter UserId you want to delete:");
				String id=scan.nextLine();
				for(User i:UserDaoImpl.usersList) {
					if(i.getUserId().equals(id)) {
						user.deleteUserDetails(i);
						break;
					}
				}
				
				break;
			case 4:
				user.displayUserDetails();
				break;
			case 5:
				scan.close();
				System.exit(0);
			default:
				System.out.println("enter between 1 and 5 only");
				break;
			}
			
			
		}while(true);

	}

	
}

