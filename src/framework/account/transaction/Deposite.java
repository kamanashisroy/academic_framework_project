package framework.account.transaction;

import framework.account.IAccount;

public class Deposite implements ITransaction {
	double amount;
	IAccount account;
	boolean isSuccessful = false;
	public Deposite(IAccount target, double amount) {
		this.account = target;
		this.amount = amount;
	}

	@Override
	public void execute() {
		// NOTE This is a security leak
		isSuccessful = account.deposite(amount);
	}

	@Override
	public boolean isSuccessful() {
		return isSuccessful;
	}

	@Override
	public String getStatus() {
		return null;
	}

}
