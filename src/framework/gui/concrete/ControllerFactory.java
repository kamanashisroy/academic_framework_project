package framework.gui.concrete;

import framework.module.IModuleFactory;

public class ControllerFactory {

	TransactionController tcontroller = null;
	public TransactionController getTransactionController(IModuleFactory factory) {
		if(tcontroller == null)
			tcontroller = new TransactionController(factory);
		return tcontroller;
	}
}
