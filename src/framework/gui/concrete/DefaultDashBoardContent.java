package framework.gui.concrete;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import framework.account.IAccount;
import framework.gui.SwingDashBoardBlock;
import framework.module.IModuleFactory;

public class DefaultDashBoardContent implements SwingDashBoardBlock {

	@Override
	public void addBlock(JPanel panel, IModuleFactory factory, ControllerFactory cfactory) {
		// TODO Auto-generated method stub
        JScrollPane scroll = new JScrollPane();
        //model = new DefaultTableModel();
        JTable table = new JTable(new DefaultAccountTableModel(factory.getAccountListFactory().getAccountList()));
        
        table
        	.getSelectionModel()
        	.addListSelectionListener(new ListSelectionListener() {

				@Override
				public void valueChanged(ListSelectionEvent e) {
					int selectedIndex = table.getSelectedRow();
					if(selectedIndex < 0)
						return;
					IAccount selected = factory.getAccountListFactory().getAccountList().get(selectedIndex);
					cfactory.getTransactionController(factory).changed(selected);
				}
            });
        
        panel.add(scroll);
        scroll.setBounds(12,92,444,160);
        scroll.getViewport().add(table);
        table.setBounds(0, 0, 420, 0);
	}

}
