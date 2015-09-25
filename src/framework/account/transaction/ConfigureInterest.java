package framework.account.transaction;

import framework.account.IAccount;

public class ConfigureInterest implements ITransaction {
	double rate;
	IAccount account;
	public ConfigureInterest(IAccount account, double rate) {
		this.account = account;
		this.rate = rate;
	}

	@Override
	public void execute() {
		account.setInterestRate(rate);
	}

	@Override
	public boolean isSuccessful() {
		return true;
	}

	@Override
	public String getStatus() {
		return null;
	}

}
