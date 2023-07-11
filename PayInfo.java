package net.hb.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashMap;

public class PayInfo {
	public int userid;
	public int roomnum;
	public Scanner sc = new Scanner(System.in);
	public PayFunction PF = new PayFunction();
	
	public PayInfo(int userid, int roomnum) {
		this.userid = userid;
		this.roomnum = roomnum;
		int sel=9;
		while (true) {
			System.out.println("1.결재 2.포인트 사용 결재 9.결재 취소");
			sel = Integer.parseInt(sc.nextLine());
			if(sel==9) {
				break;
			}
			switch (sel) {
			case 1:
				PF.PayPrice(roomnum);
				break;
			case 2:
				break;
			default:
				break;
			}
			
		}
	
	}

}
