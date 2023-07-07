package net.hb.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;


public class CustomerFunction {
	private String msg;
	private Connection CN;
	private Statement ST;
	private ResultSet RS;
	private Scanner sc = new Scanner(System.in);
	private PreparedStatement PST = null;
	
	public CustomerFunction() {
		CN = HotelDB.dbConnection();
	}
	
	public void join(Customer CO) {
		try {
			msg = "insert into Customer values(?,?,?)";
			PST = CN.prepareStatement(msg);
				PST.setInt(1, CO.getCid());
				PST.setInt(2, CO.getCpw());
				PST.setString(3, CO.getCname());
				
			int success =  PST.executeUpdate();
			if (success != 0) {
				System.out.println(CO.getCname() + " 회원가입 성공");
			}else {
				System.out.println(CO.getCname() + " 회원가입 실패");
			}
			
		}catch(Exception ex) {System.out.println("Error"+ex);}
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
//	}
	
	//로그인
	public void login(int id, int pwd) {
		int check = customerCheck(id,pwd);
		boolean flag = false;
		if (check == 1) {
			flag = true;
			System.out.println("로그인 성공");
		}else {
			System.out.println("로그인 실패");
		}
		
	}
	
	//로그인시에 체크
	public int customerCheck(int id ,int pwd) {
		int count = 0;
		try {
			msg = "select count(*) as cnt from Customer where cid ="+ id + " and cpw ="+ pwd;
			ST = CN.createStatement();
			RS = ST.executeQuery(msg);
			while(RS.next()) {
				count =RS.getInt("cnt");
			}
		}catch(Exception e) {System.out.println("Error gusestCountAll");}
		
		return count;
	}// guestCountAll()

}
