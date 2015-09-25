package framework.account.transaction;

import framework.account.IAccount;

public class DefaultTransactionFactory implements ITransactionFactory {
	private ITransactionManager manager = null;
	
	@Override
	public ITransaction createWithdraw(IAccount target, double amount) {
		return new Withdraw(target, amount);
	}
	
	@Override
	public ITransaction createDeposite(IAccount target, double amount) {
		return new Deposite(target, amount);
	}

	@Override
	public ITransaction createConfigureInterest(IAccount account, double rate) {
		return new ConfigureInterest(account, rate);
	}
	
	@Override
	public ITransactionManager getTransactionManager() {
		if(manager == null) {
			manager = new DefaultTransactionManager();
		}
		return manager;
	}
}
