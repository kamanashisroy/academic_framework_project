package framework.bootstrap;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.UIManager;

import framework.gui.IDashBoard;
import framework.module.IModuleFactory;

public class Finco {
	public static final String MODULE_FACTORY = "module.factory";
	public static final String MODULE_DASH_BOARD = "module.dashboard";
	Properties prop = null;
	IModuleFactory factory = null; // new DefaultModuleFactory();
	
	public void setDefaults(Properties prop) {
		prop.setProperty(MODULE_FACTORY, framework.module.concrete.DefaultModuleFactory.class.getName());
		prop.setProperty(MODULE_DASH_BOARD, framework.gui.concrete.DefaultDashBoard.class.getName());
	}
	
	public Properties loadProperty(String propertyFile) { // template method
		Properties prop = new Properties();
		setDefaults(prop);
		try {
			prop.load(new FileInputStream(new File(propertyFile)));
		} catch (IOException e) {
			try {
				prop.load(new FileInputStream(new File("framework.properties")));
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return prop;
	}
	
	public IModuleFactory getFactory() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		return (IModuleFactory)(Class.forName(
				prop.getProperty(MODULE_FACTORY)
			).newInstance());
	}
	
	public IDashBoard getDashBoard() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		return (IDashBoard)(Class.forName(
				prop.getProperty(MODULE_DASH_BOARD)
			).newInstance());		
	}
	
	public void load(String propertyFile) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		prop = loadProperty(propertyFile);
		// load the modules.properties
		// get the module.factory = bank.a.BankAModule
		// load the module.factory dynamically
		
		// TODO load the dashboard from property file
		IDashBoard board = getDashBoard();
		board.setProperties(prop);
		board.setModuleFactory(getFactory());
		board.init();
		
	    // Add the following code if you want the Look and Feel
	    // to be set to the Look and Feel of the native system.
	    
	    try {
	        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	    } 
	    catch (Exception e) { 
	    }
		    
		board.showDashBoard();
		
	}
	
	public static void main(String args[]) {
		try {
			String propertyFile = "framework.properties";
			if(args.length != 0) {
				propertyFile = args[0];
			}
			Logger.getGlobal().log(Level.INFO, "configuration file " + propertyFile);
			(new Finco()).load(propertyFile);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
