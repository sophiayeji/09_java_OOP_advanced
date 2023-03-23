package step9_03.atm_v3;

public class AccountManager_연습 {

	private AccountManager_연습() {}
	private static AccountManager_연습 instance = new AccountManager_연습();
	public static AccountManager_연습 getInstacne() {
		return instance;
	}
	
	UserManager userManager = UserManager.getInstance();
	private int money;
	private int transUserIndex;
	private int transAccIndex;
	
	void createAccunt() {
		
		User loginUser = userManager.userList[userManager.identifier]; 

		if	(loginUser.accCount == 3) {
			System.out.println("[메세지]더 이상 계좌를 생성할 수 없습니다.\n");
			return;
		}
		
		if	(loginUser.accCount == 0) {
			 loginUser.accList = new Account[loginUser.accCount+1];
		}
		else if(loginUser.accCount >0) {
			Account[] temp = loginUser.accList;
			
			loginUser.accList = new Account[loginUser.accCount+1];
			for (int i = 0; i < loginUser.accCount; i++) {
				loginUser.accList[i] = temp[i];
			}
			temp = null;
		}
		loginUser.accList[loginUser.accCount] = new Account();
	
		String makeAccount = ATM.ran.nextInt(90000000) + 10000001 + "";
		loginUser.accList[loginUser.accCount].number = makeAccount;
		loginUser.accList[loginUser.accCount].money = 0;
		
		loginUser.accCount++;
		System.out.println("[메세지]계좌가 생성되었습니다.\n");
		
		FileManager.getInstance().saveData();
				
	}
	
	int showAccList(String msg) {
		
		int loginAccIndex = -1;
		
		User loginUser = userManager.userList[userManager.identifier];
		
		if(loginUser.accCount>0) {
			for (int i = 0; i < loginUser.accCount; i++) {
				System.out.println("[" + (i+1) + "]" + loginUser.accList[i].number);
			}
			
			System.out.println("[" + msg + "] 내 계좌를 메뉴에서 선택하세요:");
			loginAccIndex = ATM.scan.nextInt();
			loginAccIndex--;
		}
		
		return loginAccIndex ;
		
	}
	
	void income() {
		
		int loginAccIndex= showAccList("입금");
		if(loginAccIndex == -1) {
			System.out.println("[메세지]계좌를 먼저 생성해주세요.\n");
			return;
		}
		System.out.println("[입금]금액을 입력하세요 : ");
		int monney =ATM.scan.nextInt();
		
		userManager.userList[userManager.identifier].accList[loginAccIndex].money += money;
		userManager.userList[transUserIndex].accList[transAccIndex].money += money;
		System.out.println("[메세지]이체를 완료하였습니다.\n");
		
		FileManager.getInstance().saveData();
		
	}

	void lookupAcc() {
		userManager.userList[userManager.identifier].printOneUserAllAccounts();
	}
	
	void deleteAcc() {
		
		int loginAccIndex = showAccList("삭제");
		if(loginAccIndex == -1) {
			System.out.println("[메세지]계좌를 먼저 생성해주세요.\n");
			return;
		}
		
		User user = userManager.userList[userManager.identifier];
		
		if(user.accCount ==1 ) {
			user.accList = null;
		}
		else if (user.accCount>1) {
			Account[] acc = user.accList;
			
			user.accList = new Account[user.accCount-1];
			int j =0;
			for (int i = 0; i < user.accCount; i++) {
				if(i != loginAccIndex) {
					user.accList[j] = acc[i];
					j =j +1;
				}
			}
			acc= null;
		}
		user.accCount--;
		
		System.out.println("[메세지]계좌삭제를 완료하였습니다.\n");
		
		FileManager.getInstance().saveData();
	}




}

