package net.hb.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;


public class RevervationFunction {
	private String msg;
	private Connection CN;
	private Statement ST;
	private ResultSet RS;
	private Scanner sc = new Scanner(System.in);
	private PreparedStatement PST = null;
	
	public RevervationFunction() {
		CN = HotelDB.dbConnection();
	}
	

	
//	public ArrayList<Customer> Search() {//조회 고개정보 조회 필요없음
//		ArrayList<Customer> alist = new ArrayList<>();
//		try {
//
//			msg ="select * from Cumtomer ";
//			ST = CN.createStatement();
//			RS = ST.executeQuery(msg);
//			
//			while(RS.next()) {
//				Customer  CO = new Customer();
//				
//				int id = RS.getInt("cid");
//				int pw = RS.getInt("cpw");
//				String name = RS.getString("name");
//				
//				CO.setCid(id);;
//				CO.setCpw(pw);
//				CO.setCname(name);
//
//				alist.add(CO);
//				
//			}
//			
//		}catch(Exception ex) {System.out.println("Errsor"+ex);}  
//		return alist;
//	
//	}
	


}
