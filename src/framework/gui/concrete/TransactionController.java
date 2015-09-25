package framework.gui.concrete;

import java.util.function.Function;

import framework.account.IAccount;
import framework.account.ModelChangeListener;
import framework.account.transaction.ITransaction;
import framework.module.IModuleFactory;

public class TransactionController implements ModelChangeListener<IAccount> {

	IModuleFactory factory = null;
	IAccount selected = null;
	public TransactionController(IModuleFactory factory) {
		this.factory = factory;
	}
	
	public void onTransaction(Function<IAccount, ITransaction> creator) {
		/* sanity check */
		if(selected == null)
			return;
		ITransaction trans = creator.apply(selected);
		factory.getTransactionFactory().getTransactionManager().execute(trans);
	}

	@Override
	public void changed(IAccount x) {
		this.selected = x;
	}
}
