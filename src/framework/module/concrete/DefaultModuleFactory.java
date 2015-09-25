package framework.module.concrete;

import framework.account.DefaultAccountListFactory;
import framework.account.IAccountListFactory;
import framework.account.info.ICustomerFactory;
import framework.account.info.DefaultCustomerFactory;
import framework.account.transaction.DefaultTransactionFactory;
import framework.account.transaction.ITransactionFactory;
import framework.module.IModuleFactory;

public class DefaultModuleFactory implements IModuleFactory {
	private ITransactionFactory transactionFactory = null;
	private ICustomerFactory customerFactory = null;
	private IAccountListFactory accountFactory = null;

	@Override
	public ITransactionFactory getTransactionFactory() {
		if(transactionFactory == null) {
			transactionFactory = new DefaultTransactionFactory();
		}
		return transactionFactory;
	}

	@Override
	public ICustomerFactory getCustomerFactory() {
		if(customerFactory == null) {
			customerFactory = new DefaultCustomerFactory();
		}
		return customerFactory;
	}

	@Override
	public IAccountListFactory getAccountListFactory() {
		if(accountFactory == null)
			accountFactory = new DefaultAccountListFactory();
		return accountFactory;
	}

}
