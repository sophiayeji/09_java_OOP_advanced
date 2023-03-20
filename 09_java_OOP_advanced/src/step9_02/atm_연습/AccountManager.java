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
}	
		
		
		

	
	
	void printAcc(int identifier) { 
	
	}

}