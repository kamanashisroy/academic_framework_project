package framework.account;

public interface IAccount {
	int getAccountType();
	String getAccountId();
	double getInterestRate();
	void setInterestRate(double rate);
	double getAmount();
	boolean withdraw(double amount); // NOTE: this is a security leak
	boolean deposite(double amount); // NOTE: this is a security leak
	String getName();
	void addModelChangeListener(ModelChangeListener<IAccount> listener);
	void visit(ModelVisitor<IAccount> visitor);
	void addRule(IAccountRule rule);
}
