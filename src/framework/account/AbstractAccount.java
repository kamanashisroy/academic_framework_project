package framework.account;

import framework.account.info.ICustomer;

public abstract class AbstractAccount implements IAccount {
	double rate;
	double amount;
	int accountType;
	IAccountRule rule = null;
	protected AbstractAccount(double rate, double amount, int accountType) {
		this.rate = rate;
		this.amount = amount;
		this.accountType = accountType;
	}
	@Override
	public double getInterestRate() {
		return rate;
	}

	@Override
	public void setInterestRate(double rate) {
		this.rate = rate;
		notifyModelChange();
	}

	@Override
	public double getAmount() {
		return amount;
	}

	@Override
	public boolean deposite(double deposite) {
		double toAmount = this.amount + deposite;
		
		if(rule != null && rule.beforeDeposite(this, deposite) == false) {
			return false;
		}
		
		this.amount = toAmount;
		if(rule != null) {
			rule.afterDeposite(this, deposite);
		}
		
		notifyModelChange();
		return true;
	}
	
	@Override
	public boolean withdraw(double withdraw) {
		double toAmount = this.amount - withdraw;

		if(rule != null && rule.beforeWithdraw(this, withdraw) == false) {
			return false;
		}
		
		this.amount = toAmount;
		
		if(rule != null) {
			rule.afterWithdraw(this, withdraw);
		}
		
		notifyModelChange();
		return true;
	}

	public abstract ICustomer getCustomer();
	
	protected abstract void notifyModelChange();

	@Override
	public void addRule(IAccountRule rule) {
		this.rule = rule;
	}

}
