package framework.gui.concrete;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import framework.gui.SwingDashBoardBlock;
import framework.module.IModuleFactory;

public class DefaultDashBoardHeader implements SwingDashBoardBlock {
	@Override
	public void addBlock(JPanel panel, IModuleFactory factory, ControllerFactory cfactory) {
		
		
		JButton add = new JButton();
		add.setText("Add account");
		panel.add(add);
		add.setBounds(24,20,192,33);
		
		add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DefaultAccountDialog dialog = new DefaultAccountDialog(factory);
				dialog.setBounds(450, 20, 300, 330);
				dialog.setVisible(true);
			}
		});
	}
}
