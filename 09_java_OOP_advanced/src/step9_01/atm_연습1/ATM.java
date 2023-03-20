package step9_01.atm_연습1; // ATM 기능 
import java.util.Random;
import java.util.Scanner;

public class ATM { 

	Scanner scan = new Scanner(System.in);
	Random ran = new Random();
	UserManager userManager = new UserManager(); 
	int identifier = -1; 
	
	void printMainMenu() {
				
		while (true) {
			
			System.out.println("\n[ MEGA ATM ]");
			System.out.println("[1.로그인] [2.로그아웃] [3.회원가입] [4.회원탈퇴] [0.종료] : ");
			int sel = scan.nextInt();
			
			if(sel ==1) login();
			else if(sel==2) logout();
			else if(sel==3) join();
			else if(sel==4) leave();
			else if(sel==0) break;
		
		}
		
		System.out.println("[메시지] 프로그램을 종료합니다.");
		
	}
	
	
	void login() { // 로그인
		
		identifier = userManager.logUser();
		
		if(identifier !=-1) { 
			printAccountMenu();
		}
		else {
			System.out.println("[메세지] 로그인실패.");
		}
	}
		
	
	void join() {	//가입 
		
		userManager.addUser();
	
	}		
	
	void logout() { // 로그아웃 

		if(identifier == -1) {
			System.out.println("[메시지] 로그인을 하신 후 이용하실 수 있습니다.");
		}
		else {
			identifier = -1;
			System.out.println("[메시지] 로그아웃 되었습니다.");
			
		}
	}		
		
		
		
	void leave() {
		userManager.leave();
		
	}
	
	
	void printAccountMenu() {
		
		while(true) {
			
			System.out.println("[1.계좌생성] [2.계좌삭제] [3.조회] [0.로그아웃] :" );
			int sel = scan.nextInt();
			
			String makeAccount = Integer.toString(ran.nextInt(90001) + 10000); //*************
			
			if(sel == 1) {
				
				if(	userManager.user[identifier].accCount == 0) {
					userManager.user[identifier].acc = new Account[1];
					
					userManager.user[identifier].acc[0] = new Account();
					userManager.user[identifier].acc[0].number = makeAccount;
					
				}
				else {
					Account[]temp = userManager.getUser(identifier).acc;
					int tempAccCount = userManager.getUser(identifier).accCount;
					userManager.user[identifier].acc = new Account[tempAccCount+1];
					for(int i =0; i< tempAccCount; i++) {
							
					}
					
					
				}
				
				
			}
		}
	}
}
