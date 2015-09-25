package framework.account;

import framework.account.info.ICustomer;

public class DefaultAccount extends AbstractAccount {
	ICustomer customer;
	String id;
	public DefaultAccount(long id, double rate, double amount, int accountType, ICustomer customer) {
		super(rate, amount, accountType);
		this.customer = customer;
		this.id = String.format("%3d", id);
	}
	
	@Override
	public String getAccountId() {
		return id;
	}
	
	@Override
	public ICustomer getCustomer() {
		return customer;
	}

	@Override
	public String getName() {
		if(customer == null)
			return "Unknown";
		return customer.getName();
	}

	@Override
	public void visit(ModelVisitor<IAccount> visitor) {
		visitor.accept(this);
	}

	ModelChangeListener<IAccount> listener = null; // TODO use list here
	@Override
	public void addModelChangeListener(ModelChangeListener<IAccount> listener) {
		this.listener = listener;
	}
	
	protected void notifyModelChange() {
		if(listener != null) listener.changed(this);
	}

	@Override
	public int getAccountType() {
		return accountType;
	}
}
