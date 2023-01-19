package com.revature.dao.imp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.config.DataBaseConnection;
import com.revature.constants.Constant;

public class UserDaoImpl {
	private static Connection con = DataBaseConnection.getConnection();
	private static final Logger logger = Logger.getLogger(UserDaoImpl.class);
	private String userid = null;
	private String password = null;

	Scanner sc = new Scanner(System.in);

	/******************* Cancellation method 
	 * @throws SQLException **************************************/

	public void cancellation() throws SQLException {
		
		
		

			logger.info("\tPlease enter Ticket ID :\t");
			String tID = sc.nextLine();

			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("SELECT ticket_id FROM cancellation");
			boolean flag=true;

			while(rs.next()) {
				if (tID.equals(rs.getString(1))) {
					flag=false;
					logger.info("\n\n\n\t Your Ticket Details is :  ");
					rs = stm.executeQuery("SELECT * FROM cancellation where ticket_id='" + tID + "'");
					while (rs.next()) {
						logger.info(
								"\tUser_id\tBus_id\tTicket_id\tBooking_status\tBooked_date\tcurr_date\tTicket_charge\tRefund_amt\tReas_of_cancel");
						logger.info("\t" + rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3)
								+ "\t\t" + rs.getString(4) + "\t\t" + rs.getString(5)+"\t"+rs.getString(6) + "\t" + rs.getFloat(7) + "\t\t"
								+ rs.getFloat(8) + "\t\t" + rs.getString(9));
						if(rs.getString(4).equals(Constant.cancel)) {
							logger.info("\n\n\tYour Ticket Already Cancelled");
							return;
						}
					}
					
					rs.close();
					logger.info("\n\tDo You want to Cancell your ticket : yes|No  : ");
					String str = sc.next();
					str = str.toLowerCase();
					if (str.equals("yes")) {
						Date date = new Date();
						SimpleDateFormat dform = new SimpleDateFormat("yyyy-MM-dd");
						String str2 = dform.format(date);
						//logger.info("Current date: " + str2);
						Statement stmt = con.createStatement();
						ResultSet rs1 = stmt.executeQuery("SELECT ticket_id FROM cancellation");

						rs1 = stmt.executeQuery("select booked_date, booked_charge from cancellation where ticket_id='"+tID+"'");
						String resDate = null;
						double ticketCharge=0;
						double refundAmt=0;
						double fine = 0;
						while (rs1.next()) {
							resDate = rs1.getString(1);
							ticketCharge=rs1.getFloat(2);
						}
						String reasOfCancel=null;

						try {
							Scanner s=new Scanner(System.in);
							Date date1 = dform.parse(resDate);
							Date date2 = date;
							long time_difference = date2.getTime() - date1.getTime();
							long days_difference = (time_difference / (1000 * 60 * 60 * 24)) % 365;
							long hours_difference = (time_difference / (1000*60*60)) % 24;  
							//logger.info("\t"+days_difference + " days"+hours_difference+"hours");
							
							
							

							if(days_difference>=7) {
								refundAmt = ticketCharge - (ticketCharge*85/100);
								fine =(ticketCharge*85/100);
							}else if(days_difference>=4) {
								refundAmt = ticketCharge - (ticketCharge*50/100);
								fine = (ticketCharge*50/100);
							}else if(days_difference>=1) {
								refundAmt = ticketCharge - (ticketCharge*25/100);
								fine =(ticketCharge*25/100);
							}
							else if(hours_difference>=4) {
								refundAmt =  ticketCharge - (ticketCharge*10/100);
								fine = (ticketCharge*10/100);
							}
							else if(hours_difference>=1) {
								refundAmt = ticketCharge - (ticketCharge*5/100);
								fine = (ticketCharge*5/100);
							}
							else {
								refundAmt=0;
								fine = ticketCharge;
							}	
							
							
  							logger.info("\n\tYour ticket fine is\t:"+fine);

  							

							logger.info("\n\n\tAre you confirm  Yes :  ");
							String cfrm=s.next();
							cfrm=cfrm.toLowerCase();
  							if(!cfrm.equals("yes")) {
  								logger.info("\t\t THANK YOU");
								return;
 							}
							
							
							logger.info("\tReason of cancellation of ticket : ");
							reasOfCancel=sc.next();
							
  							
  							
							 Statement stmt2 = con.createStatement(); 
							 int k = stmt2.executeUpdate("update  cancellation set booking_status='"+Constant.cancel+"', curr_date = '"+str2+"', refund_amt='"+refundAmt+"',reas_of_cancel='"+reasOfCancel+"' where ticket_id='" + tID + "'");
							 if(k>0) {
								logger.info("\tTicket cancelled successfull");
								return;
							 }
							 
							
						}catch (ParseException excep) {
							excep.printStackTrace();
						}
					} else {
						logger.info("\t\tThank you");
						return;
					}

				} 
				
			}
			if(flag==true) {
				System.err.println("\t" + Constant.error2);
			}

	}

	/*************
	 * LogIn Method
	 * @throws SQLException 
	 *********************************************************/
	public void logIn() throws SQLException {
		boolean flag = true;

			logger.info("\tPlease enter userid :\t");
			userid = sc.nextLine();

			logger.info("\tPlease enter password :\t");
			password = sc.nextLine();

			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("SELECT user_id, password FROM registration");

			while (rs.next()) {
				if (userid.equals(rs.getString(1)) && password.equals(rs.getString(2))) {
					logger.info("\n\n\n\t\tWelcome user");
					flag = false;
					cancellation();
				}
			}
			if (flag == true) {
				System.err.println("\t" + Constant.error);
				logIn();
			}
				
				

	}

}
