package framework.account;

public interface IAccountRule {
	boolean beforeWithdraw(IAccount acc, double amount);
	void afterWithdraw(IAccount acc, double amount);
	boolean beforeDeposite(IAccount acc, double amount);
	void afterDeposite(IAccount acc, double amount);
}
