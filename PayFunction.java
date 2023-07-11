package net.hb.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;


public class PayFunction {
	private String msg;
	private Connection CN;
	private Statement ST;
	private ResultSet RS;
	private Scanner sc = new Scanner(System.in);
	private PreparedStatement PST = null;
	
	public PayFunction() {
		CN = HotelDB.dbConnection();
	}
	
	public void PayPrice(int roomnum) {
		int price = 0;
		try {
			msg = "select price from room where roomnum="+ roomnum;
			ST = CN.createStatement();
			RS = ST.executeQuery(msg);
			
			if(RS.next()) {
				price  = RS.getInt("price");
				System.out.println(price);
			}
		
		}catch(Exception ex) {System.out.println("error2");}
		
	}
	
	public double userbonus (int login_user_id) {
	      double point = 0;
	      try {
	         msg = "select points from customer where id =" + login_user_id ;
	         ST= CN.createStatement();
	         RS = ST.executeQuery(msg);
	         
	         if(RS.next()==true) {
	            point = RS.getInt("points");
	         }
	      }catch(Exception ex) {}
	      return point;
	   }
	   
	  public void bonus(int login_user_id, int price) {
	      double userpoint = userbonus(login_user_id);
	      double bonusRatio =0.01;
	      bonusPoint = price * bonusRatio;
	      userpoint += bonusPoint ;
	   
	      try {
	         msg = "update customer set points = " + userpoint + "where id =" + login_user_id ;
	         ST = CN.createStatement();
	         RS = ST.executeQuery(msg);
	         
	         while(RS.next()==true) {
	            System.out.println(login_user_id + "님 "+ bonusPoint +"포인트 적립되셨습니다!");
	         }
	      }catch(Exception ex) {}
	      
	   }//bonus end
	
	
	
	

}
