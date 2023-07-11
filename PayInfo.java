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
		int say=2;
		int paymoney=0;
		boolean payisEnd = false;
		while (!payisEnd) {
			System.out.println("1.결재 9.결재 취소");
			sel = Integer.parseInt(sc.nextLine());
			if(sel==9) {
				PF.PayCancle(userid, roomnum);
				break;
			}
			switch (sel) {
			case 1:
				System.out.println(roomnum+"의 가격은 "+PF.roomPrice(roomnum) +"원 입니다.");
				System.out.println("포인트로 결재하시겠습니까?\n 1.예 2.아니오");
				say = Integer.parseInt(sc.nextLine());
	
				if (say ==1) {
					System.out.println("고객님의 보유 포인트는 "+PF.userbonus(userid));
					System.out.println("결재할 돈을 넣어주세요");
					paymoney = Integer.parseInt(sc.nextLine());
					paymoney =  paymoney + (int) PF.userbonus(userid);
				}else {
					System.out.println("결재할 돈을 넣어주세요");
					paymoney = Integer.parseInt(sc.nextLine());
					paymoney = paymoney;
				}
				
				if (PF.pay(userid, roomnum, paymoney)) {
					PF.bonus(userid, roomnum);
				}else {
					PF.PayCancle(userid, roomnum);
				}
				
				payisEnd = true;
				break;
	
			default:
				PF.PayCancle(userid, roomnum);
				break;
			}
			
		}
	
	}

}
