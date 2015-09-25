package framework.account;

public interface IAccountList {
	int count();
	IAccount get(int rowIndex);
	void add(IAccount account);
	void addChangeListener(ModelChangeListener<IAccountList> listener);
	void notifyModelChange();
}
