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
	private boolean flag = false;
	
	public CustomerFunction() {
		CN = HotelDB.dbConnection();
	}
	
	public void join(Customer CO) {
		try {
			msg = "insert into customer values(?,?,?)";
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
	

	
	//로그인
	public boolean login(int id, int pwd) {
		boolean check = customerCheck(id,pwd);
	
		if (check) {
			flag = true;
			System.out.println("로그인 성공");
		}else {
			flag = false;
			System.out.println("로그인 실패");
		}
		return flag;
	}
	
	//로그인시에 체크
	public boolean customerCheck(int id ,int pwd) {
		int count = 0;
		try {
			msg = "select * from customer where id ="+ id + " and pwd ="+ pwd;
			ST = CN.createStatement();
			RS = ST.executeQuery(msg);
			if(RS.next()) {
				return true;
			}else {
				return false;
			}
		}catch(Exception e) {System.out.println("Error gusestCountAll");}
		
		return false;
	}// guestCountAll()
	
	
	public void terminate(Customer CO) {
		try {
			msg = "delete from customer where id = ? and pwd = ?";
			PST = CN.prepareStatement(msg);
				PST.setInt(1, CO.getCid());
				PST.setInt(2, CO.getCpw());
				
			int success =  PST.executeUpdate();
			if (success != 0) {
				System.out.println("탈퇴 성공");
			}else {
				System.out.println("가입되지 않은 아이디입니다.");
			}
			
		}catch(Exception ex) {System.out.println("Error"+ex);}
	}
	
	
	// user 정보가 삭제되면 reservation 테이블에서 지워지게 한다.
	// 동기화 생각해보기 reservation , customer
	// 로그인 실패
	
	
	
	
	
	
	
	
	
//	public ArrayList<Customer> Search() {//조회 고개정보 조회 필요없음
//	ArrayList<Customer> alist = new ArrayList<>();
//	try {
//
//		msg ="select * from Cumtomer ";
//		ST = CN.createStatement();
//		RS = ST.executeQuery(msg);
//		
//		while(RS.next()) {
//			Customer  CO = new Customer();
//			
//			int id = RS.getInt("cid");
//			int pw = RS.getInt("cpw");
//			String name = RS.getString("name");
//			
//			CO.setCid(id);;
//			CO.setCpw(pw);
//			CO.setCname(name);
//
//			alist.add(CO);
//			
//		}
//		
//	}catch(Exception ex) {System.out.println("Errsor"+ex);}  
//	return alist;
//}

}
