package prob05;

public class Account {
	private String accountNo;
	private int balance;
	
	public Account(String accountNo_disposable) {
		System.out.println(accountNo_disposable + " 계좌가 개설되었습니다.");
		accountNo = accountNo_disposable;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public void save(int i) {
		balance = balance + i;
		System.out.println(accountNo + " 계좌에 " + i + "만원이 입금되었습니다.");		
	}

	public void deposit(int i) {
		balance = balance - i;
		System.out.println(accountNo + " 계좌에 " + i + "만원이 출금되었습니다.");
	}

}