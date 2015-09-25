package framework.gui;

import java.util.Properties;

import framework.module.IModuleFactory;

public interface IDashBoard {
	public void setModuleFactory(IModuleFactory factory);
	public void init();
	public void showDashBoard();
	void setProperties(Properties prop);
}
