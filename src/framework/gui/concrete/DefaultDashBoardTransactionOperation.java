package framework.gui.concrete;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Function;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import framework.account.IAccount;
import framework.account.transaction.ITransaction;
import framework.gui.SwingDashBoardBlock;
import framework.module.IModuleFactory;

public class DefaultDashBoardTransactionOperation implements SwingDashBoardBlock {

	public void addBlock(JPanel panel, IModuleFactory factory, ControllerFactory cfactory) {
		JTextField amount = new JTextField();
		panel.add(amount);
		amount.setBounds(468, 220, 96, 33);
		
		// deposite
		JButton deposite = new JButton();
		deposite.setText("Deposit");
		panel.add(deposite);
		deposite.setBounds(468, 100, 96, 33);
		deposite.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String amountString = amount.getText();
				if(amountString == null || amountString.isEmpty())
					return;
				double amountValue = Double.valueOf(amountString);
				cfactory
				.getTransactionController(factory)
				.onTransaction(new Function<IAccount, ITransaction>() {
					
					@Override
					public ITransaction apply(IAccount account) {
						return factory
								.getTransactionFactory()
								.createDeposite(account, amountValue);
					}
				});
			}
		});

		// withdaraw
		JButton withdraw = new JButton();
		withdraw.setText("Withdraw");
		panel.add(withdraw);
		withdraw.setBounds(468, 140, 96, 33);
		withdraw.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String amountString = amount.getText();
				if(amountString == null || amountString.isEmpty())
					return;
				double amountValue = Double.valueOf(amountString);
				cfactory
				.getTransactionController(factory)
				.onTransaction(new Function<IAccount, ITransaction>() {
					
					@Override
					public ITransaction apply(IAccount account) {
						
						return factory
								.getTransactionFactory()
								.createWithdraw(account, amountValue);
					}
				});
			}
		});
		
		// interest
		JButton interest = new JButton();
		interest.setText("Add interest");
		panel.add(interest);
		interest.setBounds(468, 180, 96, 33);
		interest.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String amountString = amount.getText();
				if(amountString == null || amountString.isEmpty())
					return;
				double amountValue = Double.valueOf(amountString);
				cfactory
				.getTransactionController(factory)
				.onTransaction(new Function<IAccount, ITransaction>() {
					
					@Override
					public ITransaction apply(IAccount account) {
						
						return factory
								.getTransactionFactory()
								.createConfigureInterest(account, amountValue);
					}
				});
			}
		});
	}
}
