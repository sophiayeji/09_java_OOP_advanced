package step9_02.atm_연습1;

public class User {
	
	Account[] acc = new Account[UserManager.getInstance().ACC_MAX_CNT];	
	private int accCnt;	
	String id;											
	String pw;
	public int getAccCnt() {
		return accCnt;
	}
	public void setAccCnt(int accCnt) {
		this.accCnt = accCnt;
	}											
	
}


