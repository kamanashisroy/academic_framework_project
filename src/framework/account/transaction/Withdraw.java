package framework.account.transaction;

import framework.account.IAccount;

public class Withdraw implements ITransaction {
	double amount;
	IAccount account;
	boolean successful = false;
	public Withdraw(IAccount target, double amount) {
		this.account = target;
		this.amount = amount;
	}

	@Override
	public void execute() {
		// NOTE This is a security leak
		// TODO check if it crosses the credit limit
		successful = account.withdraw(amount);
	}

	@Override
	public boolean isSuccessful() {
		return successful;
	}

	@Override
	public String getStatus() {
		// TODO Auto-generated method stub
		return null;
	}

}
