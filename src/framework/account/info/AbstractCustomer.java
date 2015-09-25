package framework.account.info;

import framework.account.IAccount;
import framework.account.ModelVisitor;

public abstract class AbstractCustomer implements ICustomer {
	String name;
	IAddress addr = null;
	
	protected AbstractCustomer(String name) {
		this.name = name;
	}
	
	@Override
	public IAddress setAddress(String street
			, String city
			, String state
			, String zipCode
			, String country, String email) {
	
		this.addr = new DefaultAddress(
				street
				, city
				, state
				, zipCode
				, country
				, email
			);
		return addr;
	}
	
	@Override
	public IAddress getAddress() {
		return addr;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void visit(ModelVisitor<ICustomer> visitor) {
		visitor.accept(this);
	}
	
}
