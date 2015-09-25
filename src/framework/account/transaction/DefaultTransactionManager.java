package framework.account.transaction;

public class DefaultTransactionManager implements ITransactionManager {

	@Override
	public void execute(ITransaction trans) {
		trans.execute();
	}

}
