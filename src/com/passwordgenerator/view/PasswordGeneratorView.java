package com.passwordgenerator.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class PasswordGeneratorView extends JFrame implements IPasswordGeneratorView {

	private static final long serialVersionUID = 407011067545066768L;
	
	private PasswordGeneratorOptionsPanel options;
	private PasswordGeneratorDisplayPanel display;
	private PasswordGeneratorControlPanel controls;
	
	public PasswordGeneratorView(IPasswordGeneratorViewListener listener) {
		super("Password Generator");
		setupFrame(listener);
	}
	
	@Override
	public int getNumPasswords() {
		int numPasswords = 0;
		try {
			int tempNum = options.getNumPasswords();
			if (tempNum > numPasswords) {
				numPasswords = tempNum;
			}
		} catch (NumberFormatException nfe) {
			showError("Number of passwords must be a number!");
		}
		return numPasswords;
	}

	@Override
	public int getPasswordLength() {
		int pwLength = 0;
		try {
			pwLength = options.getPasswordLength();
		} catch (NumberFormatException nfe) {
			showError("Password length must be a number!");
		}
		return pwLength;
	}

	@Override
	public Integer[] getPasswordOptions() {
		Integer[] pwOptions = options.getPasswordOptions();
		if (pwOptions.length == 0) {
			showError("You must choose at least one character class.\n" + "No passwords will be generated.");
		}
		return pwOptions;
	}
	
	private void setupFrame(IPasswordGeneratorViewListener listener) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultLookAndFeelDecorated(true);
		setResizable(false);
		setLayout(new BorderLayout());
		
		Rectangle bounds = getGraphicsConfiguration().getBounds();
		setLocation(50 + bounds.x, 50 + bounds.y);
		
		options = new PasswordGeneratorOptionsPanel();
		display = new PasswordGeneratorDisplayPanel();
		controls = new PasswordGeneratorControlPanel(listener);
		
		Container pane = this.getContentPane();
		pane.add(options, BorderLayout.NORTH);
		pane.add(display, BorderLayout.CENTER);
		pane.add(controls, BorderLayout.SOUTH);
		
		pack();
		setVisible(true);
	}
	
	@Override
	public void setResults(String[] results) {
		display.setResults(results);
	}
	
	@Override
	public void clearResults() {
		display.clearResults();
	}
	
	private void showError(String message) {
		JOptionPane.showMessageDialog(getParent(),
			    message,
			    "Invalid Value",
			    JOptionPane.ERROR_MESSAGE);
	}

}
