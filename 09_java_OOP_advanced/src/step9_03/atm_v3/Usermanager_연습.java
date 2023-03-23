package step9_03.atm_v3;

public class Usermanager_연습 {

	private Usermanager_연습() {} 
	private static Usermanager_연습 instance = new Usermanager_연습();
	public static Usermanager_연습 getInstance() {
		return instance;		
	}
	
	User[] userList;
	int userCount;
	int identifier = -1;
	
	void printAllUserInfo() {
		
		System.out.println("아이디\t패스워드\t계좌정보");
		for (int i = 0; i < userCount; i++) {
			userList[i].printOneUserAllAccounts();
		}
		System.out.println("======================");
	}
	
	void setDummy() {
		
		userCount = 5;
		userList = new User[userCount];
		for (int i = 0; i < userCount; i++) {
			userList[i] = new User(); 
		}
		String[]a = {"a","b","c","d","e","f","g","h","i","j","k"};
		String[]b = {"l",};
		String[]c = {};
	}
}
