package net.hb.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class RoomInfo {
	
	
	public static void main(String[] args) {
		
		//HotelFunction join, login 등의 method 모음
		RoomFunction CF = new RoomFunction();
		
		//Customer class 호출 = gettersetter 호출
		Room CO = new Room();
		
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
				break;
			case 2:
				break;
			case 3:
				break;
			}
			
			
		}
		
	
	}

}
