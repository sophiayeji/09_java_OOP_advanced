package step9_02.atm_연습1;

import java.util.Random;
import java.util.Scanner;

public class AccountManager { // 계정관리자 
    //싱글턴 패턴 
	private AccountManager() {} // private 기본생성자 
	private static AccountManager instance = new AccountManager();// 내부에서 static으로 자기자신의 인스턴스를 생성
	public static AccountManager getInstance() { // instance를 반환할 getter를 만들어준다 
		return instance;
	}
	
	Scanner scan = new Scanner(System.in);
	Random ran = new Random();
	UserManager um = UserManager.getInstance(); // 유저관리자(um) 자료를 가져옴 

	void createAcc(int identifier) { // 계정생성하기 
		
		int accCntByUser = um.userList[identifier].getAccCnt();
			//accCntByUser -> 유저관리자의 유저리스트에 있는 계정 수 
		if (accCntByUser == um.ACC_MAX_CNT) { // accCntByUser가 유저관리자의 최대개설가능한 계좌의 수와 같을 떄 
			System.out.println("[메세지]계좌개설은 3개까지만 가능합니다.");
			return;
		}
		
		um.userList[identifier].acc[accCntByUser] = new Account();
		// 유저사용자의 유저 리스트에 있는 계정 => 새로운 Account 
		String makeAccount = "";
		while (true) {
			makeAccount = ran.nextInt(9000000) + 1000001 + "";	// 랜덤한 숫자로 계정번호가 나옴 	
			if (!um.getCheckAcc(makeAccount)){ // 유저관리자에 있는 getCheckAcc와 makeAccount가 다른 경우 
				break; // 종료 
			}
		}
		um.userList[identifier].acc[accCntByUser].accNumber = makeAccount;
		um.userList[identifier].setAccCnt(um.userList[identifier].getAccCnt() + 1);
		System.out.println("[메세지]'" + makeAccount + "'계좌가 생성되었습니다.\n");
		
	}
	
	
	void printAcc(int identifier) { // 계정프린트
		
		User temp = um.userList[identifier]; // temp 유저 => 유저관리자에 있는 유저리스트 
		System.out.println("====================");
		System.out.println("ID : " + temp.id);
		System.out.println("====================");
		for (int i = 0; i < temp.getAccCnt(); i++) {
			System.out.println("accNumber:" +temp.acc[i].accNumber + " / money: " + temp.acc[i].money);
		}
		System.out.println("=============================\n");
		
	}
	
}
