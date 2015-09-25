package framework.account;

public class DefaultAccountListFactory implements IAccountListFactory {
	private IAccountList singletonAccountList = null;

	@Override
	public IAccountList getAccountList() {
		if(singletonAccountList == null) 
				singletonAccountList = new DefaultAccountList();
		return singletonAccountList;
	}
}
