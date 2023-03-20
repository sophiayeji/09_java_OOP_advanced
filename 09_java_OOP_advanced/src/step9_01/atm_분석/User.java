package step9_01.atm_분석;

public class User {
	
	public static final int accCnt = 0;
	public static final String pw = null;
	private String id;
	int accCount;
	private Account[] acc;
	public int Pw;
	
	void printAccount() {
		
		for (int i = 0; i < accCount; i++) {
			getAcc()[i].printOwnAccount();
		}	
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Account[] getAcc() {
		return acc;
	}

	public void setAcc(Account[] acc) {
		this.acc = acc;
	}
	
}
