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
		String[]b = {"l","b","c","m","e","f","g","n","i","p","k"};
		String[]c = {"s", "t","u","w","v","o","x","n","q","p","r"};
		
		for (int i = 0; i < userCount; i++) {
			String id = "";
			int rNum = ATM.ran.nextInt(a.length);
			id+=a[rNum];
			rNum = ATM.ran.nextInt(b.length);
			id+=b[rNum];
			rNum = ATM.ran.nextInt(c.length);
			id+=c[rNum];
			
			userList[i].id = id;
		}
		
		String[] d = {"1", "8", "9", "4"};
		String[] e = {"2", "7", "0", "6"};
		String[] f = {"5", "3", "2", "7"};
		
		for (int i = 0; i < userCount; i++) {
			String pw = "";
			int rNum = ATM.ran.nextInt(d.length);
			pw += d[rNum];
			rNum= ATM.ran.nextInt(e.length);
			pw += e[rNum];
			rNum= ATM.ran.nextInt(f.length);
			pw += f[rNum];
			
			userList[i].password = pw;
		}
		System.out.println("[메세지]더미 파일이 추가되었습니다.\n");
	}

	int checkId(String id) {
		
		int check = -1;
		for (int i = 0; i < userCount; i++) {
			if(userList[i].id.equals(id)) {
				check = i; 
			}
		}		
		return check;
			
	}

	void joinUser() {

		System.out.println("[가입]아이디를 입력하세요: ");
		String id = ATM.scan.next();
		
		int checkedId = checkId(id);
		if(checkedId !=-1) {
			System.out.println("[메세지]아이디가 중복됩니다.\\n");
			return;
		}
		
		System.out.println("[가입]패스워드를 입력하세요: ");
		String password = ATM.scan.next();
		
		if(userCount == 0) {
			userList = new User[1];
			userList[0] = new User(id,password);
			
		}
		else if (userCount >0) {
			User[] temp = userList;
			
			userList = new User[userCount+1];
			for (int i = 0; i < userCount; i++) {
				userList[i] = temp[i];
			}
			userList[userCount] = new User(id,password);
			
			temp = null;
		}
		userCount++;
		System.out.println("[메세지]회원가입을 완료하였습니다.\\n");
		
		FileManager.getInstance().saveData();
		
		printAllUserInfo();
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
