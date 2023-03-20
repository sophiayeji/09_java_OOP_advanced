package step9_01.atm_분석;

public class Account {
	
	String number;
	private int money;
	public String accNumber;
	
	void printOwnAccount() {
		System.out.println(this.number +  " : " + this.getMoney());
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
}
