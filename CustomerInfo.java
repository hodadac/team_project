package net.hb.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class CustomerInfo {
	
	
	public static void main(String[] args) {
		
		//HotelFunction join, login 등의 method 모음
		CustomerFunction CF = new CustomerFunction();
		
		//Customer class 호출 = gettersetter 호출
		Customer CO = new Customer();
		
		//while 구문에 필요한 변수들 = 1.회원가입 2.로그인 9.종료 등에 필요한 변수
		Scanner sc = new Scanner(System.in);	
		int id; int pwd; String name;
		int sel = 9; 
	
		//고객관리 페이지 (회원가입 , 로그인 , 탈퇴 )
		while(true) {
			System.out.println("1.회원가입 2.로그인 9.종료");
			sel = Integer.parseInt(sc.nextLine());
			if (sel == 9) {
				break;
			}
			switch (sel) {
			case 1:
				System.out.print("id");
				id = Integer.parseInt(sc.nextLine());
				System.out.print("pwd");
				pwd = Integer.parseInt(sc.nextLine());
				System.out.print("name");
				name = sc.nextLine();
				
				CO.setCid(id);
				CO.setCpw(pwd);
				CO.setCname(name);
				CF.join(CO);
				break;	
			
			
			case 2:
				System.out.print("id");
				id = Integer.parseInt(sc.nextLine());
				System.out.print("pwd");
				pwd = Integer.parseInt(sc.nextLine());
				
				CF.login(id, pwd);
				break;
				
			case 3:
				break;
			}
			
			
		}
		
		
		
		
		
	
	}

}
