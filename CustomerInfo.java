package net.hb.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class CustomerInfo {
	private int login_id;
	private int login_pwd;
	private String login_name;
	
	public static void main(String[] args) {
		//HotelFunction join, login 등의 method 모음
		CustomerFunction CF = new CustomerFunction();
		
		//Customer class 호출 = gettersetter 호출
		Customer CO = new Customer();
		
		//while 구문에 필요한 변수들 = 1.회원가입 2.로그인 9.종료 등에 필요한 변수
		Scanner sc = new Scanner(System.in);	
		
		int id; int pwd; String name;
		int sel = 9; boolean next_page = false;

		//고객관리 페이지 (회원가입 , 로그인 , 탈퇴 )
		while(!next_page) {
			System.out.println("1.회원가입 2.로그인 3.회원탈퇴 9.종료");
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
				
				next_page =CF.login(id, pwd);
				break;
			case 3:
				System.out.print("id");
				id = Integer.parseInt(sc.nextLine());
				System.out.print("pwd");
				pwd = Integer.parseInt(sc.nextLine());
				
				CO.setCid(id);
				CO.setCpw(pwd);
				
				CF.terminate(CO);
				break;
			default :
				return;
			}
			if (next_page ==true) {
				ReservationInfo RI = new ReservationInfo();
			}
			
		}
		
	}

}
