package com.revature.dao.imp;
import java.util.LinkedHashSet;
import java.util.Scanner;
import com.revature.dao.UserDao;
import com.revature.model.User;

public class UserDaoImpl implements UserDao{
	
	public static LinkedHashSet<User>  usersList;
	static {
		usersList = new LinkedHashSet<User>();
	}
	
	Scanner sc=new Scanner(System.in);
	@Override
	public void addUserDetails(){
		User u1 = new User();
		System.out.println("Enter User Id :");
		u1.setUserId(sc.nextLine());
	
		System.out.println("Enter password :");
		u1.setPassword((sc.nextLine()));
	
		System.out.println("Enter User name :");
		u1.setUsername(sc.nextLine());
	
		System.out.println("Enter email  :");
		u1.setEmail(sc.nextLine());
	
		System.out.println("Enter phone number :");
		u1.setPhoneNo((sc.nextLine()));
	
		System.out.println("Enter address :");
		u1.setAddress((sc.nextLine()));
	
		System.out.println("Enter date of birth :");
		u1.setDateOfBirth((sc.nextLine()));
	
		System.out.println("Enter physical disability :");
		u1.setPhysicalDisability((sc.nextLine()));
	
		System.out.println("Enter identity proof :");
		u1.setIdentityProof((sc.nextLine()));
	
		System.out.println("Enter login Id :");
		u1.setLoginId((sc.nextLine()));
	
		System.out.println("Enter password :");
		u1.setPassword((sc.nextLine()));
	
		System.out.println("Enter age :");
		u1.setAge(Integer.parseInt(sc.nextLine()));
	
		usersList.add(u1);
	}
	
	@Override
	public  void updateUserDetails(User u) {
		
			System.out.println("----Select from below options for User registration Update----");
			System.out.println("1.Update password");
			System.out.println("2.Update email");
			System.out.println("3.Update phoneNo");
			System.out.println("4.Update identityProof");
			System.out.println("5.Exit\n");
			System.out.println("Enter your choice: ");
			
			int choice = sc.nextInt();
			sc.nextLine();
			switch(choice)
			{
			case 1:
				u.setPassword(sc.nextLine());
				System.out.println("Password is updated");
				break;
			case 2:
				u.setEmail(sc.nextLine());
				System.out.println("Email is updated");
				break;
			case 3:
				u.setPhoneNo(sc.nextLine());
				System.out.println("PhoneNo is updated");
				break;
			case 4:
				u.setIdentityProof(sc.nextLine());
				System.out.println("Identity Proof is updated");
				break;
			
			default:
				System.out.println("enter between 1 and 4 only");
				break;
			}
		
		
	}
	
	@Override
	public  void deleteUserDetails(User u) {
		usersList.remove(u);
		System.out.println("User is deleted");
	}
	
	@Override
	public  void displayUserDetails() {
		
		for(User i : usersList )
		{
			System.out.println(i);
		}
		

	}

}
