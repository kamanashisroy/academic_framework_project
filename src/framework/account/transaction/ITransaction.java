package framework.account.transaction;

public interface ITransaction {
	void execute();
	boolean isSuccessful();
	String getStatus();
}
