package framework.account;

import java.util.ArrayList;
import java.util.List;

class DefaultAccountList implements IAccountList {

	ArrayList<IAccount> list = new ArrayList<IAccount>();
	List<ModelChangeListener<IAccountList>> changeListeners = new ArrayList<ModelChangeListener<IAccountList>>();
	@Override
	public int count() {
		return list.size();
	}

	@Override
	public IAccount get(int rowIndex) {
		return list.get(rowIndex);
	}

	@Override
	public void add(IAccount account) {
		list.add(account);
		notifyModelChange();
	}

	@Override
	public void addChangeListener(ModelChangeListener<IAccountList> listener) {
		changeListeners.add(listener);
	}
	
	@Override
	public void notifyModelChange() {
		for(ModelChangeListener<IAccountList> lis : changeListeners) {
			lis.changed(this);
		}
	}

}
