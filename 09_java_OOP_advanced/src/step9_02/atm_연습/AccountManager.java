package step9_02.atm_연습;

import java.util.Random;
import java.util.Scanner;

import step9_02.atm_분석.UserManager;

public class AccountManager { 

	private AccountManager() {} 
	private static AccountManager instance = new AccountManager();
	public static AccountManager getInstacne() {
		return instance;
	}
	
	Scanner scan = new Scanner(System.in);
	Random ran = new Random();
	UserManager um = UserManager.getInstance();
	
	
	void createAcc(int identifier) { 

		int accCntByUser = um.userList[identifier].getAccCnt();
		
		if(accCntByUser == um.ACC_MAX_CNT) {
			System.out.println("[메세지]계좌개설은 3개까지만 가능합니다.");
			return;
		}
		
		um.userList[identifier].acc[accCntByUser] = new Account();
		String makeAccount = "";
		while(true) {
			
		}
}	
		
		
		

	
	
	void printAcc(int identifier) { 
	
	}

}