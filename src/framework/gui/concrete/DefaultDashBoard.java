package framework.gui.concrete;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JPanel;

import framework.gui.IDashBoard;
import framework.gui.SwingDashBoardBlock;
import framework.module.IModuleFactory;

import javax.swing.*;

/**
 * A basic JFC based application.
 */
public class DefaultDashBoard extends javax.swing.JFrame implements IDashBoard
{
    /****
     * init variables in the object
     ****/
    private IModuleFactory factory = null;
    private ControllerFactory cfactory = null;
    private Properties prop = null;
	public DefaultDashBoard()
	{
		setTitle("Uniform Bank Application.");
		setDefaultCloseOperation(javax.swing.JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0,0));
		setSize(575,310);
		setVisible(false);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing() {
				setVisible(false);
				dispose();
				System.exit(0);
			}
		});
		
	}

	public void addToolBox(JPanel panel) {
		Logger.getGlobal().log(Level.INFO, "dashboard header " + prop.getProperty(HEADER));
		try {
			((SwingDashBoardBlock)(Class.forName(
					prop.getProperty(HEADER)
				).newInstance())).addBlock(panel, factory, cfactory);
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
	
	public void addTransactionOperations(JPanel panel) {
		try {
			((SwingDashBoardBlock)(Class.forName(
					prop.getProperty(TOOLS)
				).newInstance())).addBlock(panel, factory, cfactory);
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
	
	public void addContent(JPanel panel) {
		try {
			((SwingDashBoardBlock)(Class.forName(
					prop.getProperty(CONTENT)
				).newInstance())).addBlock(panel, factory, cfactory);
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
	
	@Override
	public void showDashBoard() {
		setVisible(true);
	}
	
	public final static String HEADER = "defaultdashboard.header";
	public final static String CONTENT = "defaultdashboard.content";
	public final static String TOOLS = "defaultdashboard.tools";
	
	@Override
	public void setProperties(Properties prop) {
		this.prop = prop;
		if(prop.getProperty(HEADER) == null) {
			prop.setProperty(HEADER, DefaultDashBoardHeader.class.getName());
		}
		if(prop.getProperty(CONTENT) == null) {
			prop.setProperty(CONTENT, DefaultDashBoardContent.class.getName());
		}
		if(prop.getProperty(TOOLS) == null) {
			prop.setProperty(TOOLS, DefaultDashBoardTransactionOperation.class.getName());
		}
	}

	@Override
	public void setModuleFactory(IModuleFactory factory) {
		this.factory = factory;
		cfactory = new ControllerFactory(); // TODO load controller as DI
	}

	@Override
	public void init() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		getContentPane().add(BorderLayout.CENTER, panel);
		panel.setBounds(0,0,575,310);

		addToolBox(panel);
		addTransactionOperations(panel);
		addContent(panel);
	}
}
