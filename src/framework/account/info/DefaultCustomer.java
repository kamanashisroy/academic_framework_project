package framework.account.info;

import framework.account.DefaultAccount;
import framework.account.IAccount;

public class DefaultCustomer extends AbstractCustomer {
	static long autoIncrement = 1;
	
	protected DefaultCustomer(String name) {
		super(name);
	}

	@Override
	public IAccount createAccount(double rate, double amount, int accountType) {
		return new DefaultAccount(autoIncrement++, rate, amount, accountType, this);
	}
}
