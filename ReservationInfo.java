package net.hb.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashMap;

public class ReservationInfo {
	private int login_user_id;
	private int login_user_pwd;
	
	public ReservationInfo(int userid, int userpwd) {
		//로그인 한 고객의 id와 password
		this.login_user_id = userid;
		this.login_user_pwd = userpwd;
		
		
		//Revervation 오타임
		RevervationMenu rvm = new RevervationMenu();
		
		//Room 호출 = gettersetter 호출
		Room RO = new Room();
		
		//변수 선언
		Scanner sc = new Scanner(System.in);	
		int sel = 9;
		
 		//호텔 예약 페이지
		while(true) {
			System.out.println("1.예약 2.퇴실 3.조회  4.유저 예약 현황 9.종료");
			sel = Integer.parseInt(sc.nextLine());
			if (sel == 9) {
				break;
			}
			switch (sel) {
			case 1:		
				// room테이블 타입에 따른 공실 보여주기
				System.out.println("이코노미 공실");
				for (Room r: rvm.Search()) {
					if(r.getType().equals("a"))
					System.out.print(r.getRoomnum()+ " ");
				}
				System.out.println("\n");
				System.out.println("비지니스 공실");
				for (Room r: rvm.Search()) {
					if(r.getType().equals("b"))
					System.out.print(r.getRoomnum()+ " ");
				}
				System.out.println("\n");
				System.out.println("퍼스트 공실");
				for (Room r: rvm.Search()) {
					if(r.getType().equals("c"))
					System.out.print(r.getRoomnum()+ " ");
				}
				System.out.println("\n");
				
				
				//예약
				System.out.print("예약하실 호수를 입력하세요 >>> ");
				int roomNumber = Integer.parseInt(sc.nextLine());
				while(rvm.isDuplicated(roomNumber)) {//중복 여부 체크실행
					System.out.println("이미 예약된 방입니다! 다시 입력해주세요");
					System.out.print("예약하실 호수를 다시 입력하세요 >>> ");
					roomNumber = Integer.parseInt(sc.nextLine());
				}
				int userId = login_user_id;
				// 날짜에 대한 기능은 구현하지 않음
				System.out.print("예약하실 시작 날짜를 입력하세요 ex) 2023-07-07 >>> ");
				String startDate = sc.nextLine(); 
				System.out.print("예약하실 끝 날짜를 입력하세요 ex) 2023-07-10 >>> ");
				String endDate = sc.nextLine();
				
				Reservation checkInRvo = new Reservation();
				checkInRvo.setRoom_num(roomNumber);
				checkInRvo.setId(userId);
				checkInRvo.setStart_date(startDate);
				checkInRvo.setEnd_date(endDate);
				rvm.checkIn(checkInRvo);
				break;
			
			case 2:
				//퇴실
				System.out.print("예약하신 호수를 입력하세요 >>> ");
				int reservedRoomNumber = sc.nextInt();
				sc.nextLine();
				rvm.checkOut(reservedRoomNumber);
				break;
			
			case 3:
				//전체조회
				ArrayList<Reservation> reservationList = rvm.reservationStatus();
				System.out.println("ROOMNUM\tID\tSTART_DATE\tEND_DATE");
				for(Reservation listRvo : reservationList ) {
					System.out.print(listRvo.getRoom_num()+"\t"+listRvo.getId()+"\t");
					System.out.println(listRvo.getStart_date()+"\t"+listRvo.getEnd_date());
				}// for END
				System.out.println();
				break;
			case 4:
				//예약조회
				rvm.userRoom(login_user_id);
				break;
			}
			
			
		}
		
	
	}

}
