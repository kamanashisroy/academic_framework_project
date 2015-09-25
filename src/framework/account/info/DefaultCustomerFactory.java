package framework.account.info;

public class DefaultCustomerFactory implements ICustomerFactory {

	public ICustomer createCustomer(String name) {
		return new DefaultCustomer(name);
	}
	
}
