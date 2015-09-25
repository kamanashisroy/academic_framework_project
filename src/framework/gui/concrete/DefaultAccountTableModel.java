package framework.gui.concrete;

import javax.swing.event.TableModelListener;
import javax.swing.table.*;

import framework.account.IAccount;
import framework.account.IAccountList;
import framework.account.ModelChangeListener;

public class DefaultAccountTableModel extends AbstractTableModel implements ModelChangeListener<IAccountList> {
	IAccountList list = null;
	public DefaultAccountTableModel(IAccountList list) {
		this.list = list;
		list.addChangeListener(this);
	}
	
	@Override
	public int getRowCount() {
		return list.count();
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	static final String[] columnNames = {"id", "name", "amount", "interest"};
	@Override
	public String getColumnName(int columnIndex) {
		return columnNames[columnIndex];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		IAccount acc = list.get(rowIndex);
		switch(columnIndex) {
		case 0:
			return acc.getAccountId();
		case 1:
			return acc.getName();
		case 2:
			return acc.getAmount();
		case 3:
			return acc.getInterestRate();
		}
		return "unknown";
	}

	@Override
	public void changed(IAccountList x) {
		fireTableDataChanged();
	}
}
