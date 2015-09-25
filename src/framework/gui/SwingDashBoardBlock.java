package framework.gui;

import javax.swing.JPanel;

import framework.gui.concrete.ControllerFactory;
import framework.module.IModuleFactory;

public interface SwingDashBoardBlock {
	void addBlock(JPanel panel, IModuleFactory factory, ControllerFactory cfactory);
}
