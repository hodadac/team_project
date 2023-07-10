package net.hb.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.util.ArrayList;

public class ReservationInfo {
	private int login_user_id;
	private int login_user_pwd;
	
	public ReservationInfo(int userid, int userpwd) {
		this.login_user_id = userid;
		this.login_user_pwd = userpwd;
		
		//HotelFunction join, login 등의 method 모음
		RevervationMenu rvm = new RevervationMenu();
		
		//Customer class 호출 = gettersetter 호출
		Room RO = new Room();
		
		//while 구문에 필요한 변수들 = 1.회원가입 2.로그인 9.종료 등에 필요한 변수
		Scanner sc = new Scanner(System.in);	
		int sel = 9;
		
 		//고객관리 페이지 (회원가입 , 로그인 , 탈퇴 )
		while(true) {
			System.out.println("1.예약 2.퇴실 3.조회  4.유저 예약 현황 9.종료");
			sel = Integer.parseInt(sc.nextLine());
			if (sel == 9) {
				break;
			}
			switch (sel) {
			case 1:
				System.out.print("예약하실 호수를 입력하세요 >>> ");
				int roomNumber = Integer.parseInt(sc.nextLine());
				while(rvm.isDuplicated(roomNumber)) {//중복 여부 체크실행
					System.out.println("이미 예약된 방입니다! 다시 입력해주세요");
					System.out.print("예약하실 호수를 다시 입력하세요 >>> ");
					roomNumber = Integer.parseInt(sc.nextLine());
				}
				int userId = login_user_id;
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
				System.out.print("예약하신 호수를 입력하세요 >>> ");
				int reservedRoomNumber = sc.nextInt();
				sc.nextLine();
				rvm.checkOut(reservedRoomNumber);
				break;
			
			case 3:

				ArrayList<Reservation> reservationList = rvm.reservationStatus();
				System.out.println("ROOMNUM\tID\tSTART_DATE\tEND_DATE");
				for(Reservation listRvo : reservationList ) {
					System.out.print(listRvo.getRoom_num()+"\t"+listRvo.getId()+"\t");
					System.out.println(listRvo.getStart_date()+"\t"+listRvo.getEnd_date());
				}// for END
				System.out.println();
				break;
			case 4:
				rvm.userRoom(login_user_id);
				break;
			
			}
			
			
		}
		
	
	}

}
