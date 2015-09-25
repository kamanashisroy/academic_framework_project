package framework.account.transaction;

public interface ITransactionManager {
	void execute(ITransaction trans);
	// TODO show history
	// TODO write a proxy to do logging 
	// TODO write a failed transaction
	// TODO apply security
}
