package step9_02.atm_연습;

import java.util.Scanner;

import step9_01.atm_분석.User;

public class UserManager { // 유저관리자 
	
	private UserManager() {}
	static private UserManager instance = new UserManager();
	static public UserManager getInstance() {
		return instance;
	}
	
	Scanner scan= new Scanner(System.in);
	
	final int ACC_MAX_CNT = 3; // 최대 개설 가능한 계좌
	User[] userList = null; // 전체 회원 정보
	int userCnt =0;    		// 전체 회원 수
	
	
	void printAllUser() { // 전체 유저 프린트 
	
		for (int i = 0; i < userCnt; i++) {
			System.out.print((i+1) + ".ID(" + userList[i].getId() + ")\tPW(" + userList[i].Pw + ")\t");
			if(userList[i].accCnt !=0) {
				for (int j = 0; j < userList[i].accCnt; j++) {
					System.out.println("(" + userList[i].getAcc()[j].accNumber + ":" + userList[i].getAcc()[j].getMoney() + ")");
				}
			}
			System.out.println();
		}
	}
	
	
	boolean getCheckAcc(String account) {
		
		boolean isDuple = false;
		for (int i = 0; i < userCnt; i++) {
			for (int j = 0; j < userList[i].accCnt; j++) {
				if(account.equals(userList[i].getAcc()[j].accNumber)) {
				isDuple = true;
				}
			}
			
		}
		return isDuple; // 계좌확인 
	}
	
	
	int logUser() {
		
		int identifier = -1;
		
		System.out.println("[로그인]아이디를 입력하세요 : ");
		String id = scan.next();
		System.out.println("[로그인]패스워드를 입력하세요 : ");
		String pw = scan.next();
		
		for (int i = 0; i < UserManager.instance.userCnt; i++) {
			if(userList[i].getId().equals(id) && userList[i].pw.equals(pw)) {
				identifier = i;
			}	
		}	
		return identifier; // 로그인 사용자 				
	}
	
	boolean checkId(String id) {
		
		boolean isDuple =false; 
		for (int i = 0; i < userCnt; i++) {
			if(userList[i].getId().equals(id)) {
				isDuple = true;
			}
		}
		return isDuple;
	}
	
	
	
	void joinMember() {

		System.out.println("[회원가입]아이디를 입력하세요 : ");
		String id = scan.next();
		System.out.println("[회원가입]패스워드를 입력하세요 : ");
		String pw = scan.next();
		
		boolean isResult = checkId(id);
		
		if(isResult) {
			System.out.println("[메세지]아이디가 중복됩니다.");
			return;
		}
		if(userCnt == 0) {
		   userList = new User[userCnt + 1];
		   userList[userCnt] = new User();
		}
		else {
			User[]temp = userList;
			userList = new User[userCnt +1];
			userList[userCnt] = new User();
		}
		
	}

	
	int deleteMember(int identifier) {
		return identifier;
		
		
		
	}
	
	// (테스트생성용 메서드)  : 테스트 데이타 > 더미
	void setDummy() {
		
		
	}
	
}
