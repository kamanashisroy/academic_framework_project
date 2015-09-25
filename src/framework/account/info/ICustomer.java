package framework.account.info;

import framework.account.IAccount;
import framework.account.ModelVisitor;

public interface ICustomer {
	IAddress getAddress();
	String getName();
	IAddress setAddress(String street,String city, String state, String zipCode, String country, String email);
	IAccount createAccount(double rate, double amount, int accountType);
	void visit(ModelVisitor<ICustomer> visitor);
}
