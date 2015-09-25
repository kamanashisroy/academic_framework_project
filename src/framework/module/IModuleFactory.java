package framework.module;

import framework.account.IAccountListFactory;
import framework.account.info.ICustomerFactory;
import framework.account.transaction.ITransactionFactory;

public interface IModuleFactory {
	ITransactionFactory getTransactionFactory();
	ICustomerFactory getCustomerFactory();
	IAccountListFactory getAccountListFactory();
}
