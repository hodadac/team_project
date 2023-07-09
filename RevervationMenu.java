package net.hb.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;

public class RevervationMenu {
	private String msg;
	private Connection CN;
	private Statement ST;
	private ResultSet RS;
	private Scanner sc = new Scanner(System.in);
	private PreparedStatement PST = null;
	
	public RevervationMenu() {
		try {
			CN = HotelDB.dbConnection();
		} catch (Exception ex) { System.out.println("Error" + ex);}
	}// 기본생성자 DB연결 
	
	public boolean isDuplicated(int roomNumber) {//예약 중복 체크
		try {
			msg = "select * from reservation where roomnum= "+ roomNumber;
			ST = CN.createStatement();
			RS = ST.executeQuery(msg);
			if(RS.next()) {
				return true;
			}else {
				return false;
			}
		}catch(Exception ex)  { System.out.println("Error" + ex);}
		return false;
	}//isDuplicated END
	
	
	
	public void checkIn(Reservation RV) {// 입실
		try {
			msg = "insert into reservation values(?,?,?,?)";
			PST = CN.prepareStatement(msg);
				PST.setInt(1, RV.getRoom_num());
				PST.setInt(2, RV.getId());
				PST.setString(3, RV.getStart_date() );
				PST.setString(4, RV.getEnd_date());
			int checkInSuccess = PST.executeUpdate();
			if(checkInSuccess > 0 )
				System.out.println(RV.getId() +"님 예약되셨습니다. ");
			else
				System.out.println(RV.getId() +"님 이미 예약된 방입니다");
		}
		catch(Exception ex){ System.out.println("Error" + ex);}
	}// checkIn END
	
	public void checkOut(int reservedRoomNumber) { // 퇴실
		try {
			msg = "delete from reservation where roomnum =?";
			PST = CN.prepareStatement(msg);
				PST.setInt(1, reservedRoomNumber);
			int checkOutSuccess = PST.executeUpdate();	
			if(checkOutSuccess > 0 )
				System.out.print("퇴실처리되었습니다.");
			else
				System.out.print("이미 퇴실처리된 방입니다");
			System.out.println();
		}
		catch(Exception ex){ System.out.println("Error" + ex);}
	}// checkOut END
	
	public ArrayList<Reservation> reservationStatus() {//예약조회
		ArrayList<Reservation> reservationList = new ArrayList<>();
		try {
			msg = "select * from reservation order by roomnum";
			ST = CN.createStatement();
			RS = ST.executeQuery(msg);
			while(RS.next()==true) {
				Reservation RV = new Reservation();
				RV.setRoom_num(RS.getInt("roomnum"));
				RV.setId(RS.getInt("id"));
				RV.setStart_date(RS.getString("start_date"));
				RV.setEnd_date(RS.getString("end_date"));
	
				reservationList.add(RV);
			}
			
		}
		catch(Exception ex){ System.out.println("Error" + ex);}
		return reservationList;
	}// reservationStatus END
	
	public void totalResevationList() {
		
	}

	
}

