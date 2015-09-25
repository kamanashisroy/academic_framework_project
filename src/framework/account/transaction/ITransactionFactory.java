package framework.account.transaction;

import framework.account.IAccount;

public interface ITransactionFactory {
	ITransaction createWithdraw(IAccount target, double amount);
	ITransaction createDeposite(IAccount target, double amount);
	ITransaction createConfigureInterest(IAccount account, double rate);
	ITransactionManager getTransactionManager();
}
