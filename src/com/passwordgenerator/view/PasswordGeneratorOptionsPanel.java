package com.passwordgenerator.view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import com.passwordgenerator.util.PGUtil;

public class PasswordGeneratorOptionsPanel extends JPanel {

	private static final long serialVersionUID = -2866447702116553625L;
	
	private JTextField passwordLength;
	private JTextField numPasswords;
	private JCheckBox lowerAlpha;
	private JCheckBox upperAlpha;
	private JCheckBox numbers;
	private JCheckBox punctuation;
	
	public PasswordGeneratorOptionsPanel() {
		setupPanel();
	}
	
	private final void setupPanel() {
		setPreferredSize(new Dimension(305, 175));
		Border border = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		TitledBorder tBorder = BorderFactory.createTitledBorder(border, "Options");
		setBorder(tBorder);
		GridLayout layout = new GridLayout(0, 2);
		layout.setVgap(5);
		setLayout(layout);
		
		JLabel pnLabel = new JLabel("Quantity:");
		add(pnLabel);
		numPasswords = new JTextField(2);
		add(numPasswords);

		JLabel plLabel = new JLabel("Password Length:");
		add(plLabel);
		passwordLength = new JTextField(2);
		add(passwordLength);
		
		JLabel laLabel = new JLabel("Include Letters:");
		add(laLabel);
		lowerAlpha = new JCheckBox("(ie: abcdef)");
		lowerAlpha.setSelected(true);
		add(lowerAlpha);

		JLabel uaLabel = new JLabel("Include Mixed Case:");
		add(uaLabel);
		upperAlpha = new JCheckBox("(ie: AbcDEf)");
		upperAlpha.setSelected(false);
		add(upperAlpha);
		
		JLabel nLabel = new JLabel("Include Numbers:");
		add(nLabel);
		numbers = new JCheckBox("(ie: a7bc4E3f)");
		numbers.setSelected(false);
		add(numbers);
		
		JLabel pLabel = new JLabel("Include Punctuation:");
		add(pLabel);
		punctuation = new JCheckBox("(ie: a#bc@E3!)");
		punctuation.setSelected(false);
		add(punctuation);
		
	}
	
	public int getNumPasswords() throws NumberFormatException {
		return Integer.parseInt(numPasswords.getText());
	}
	
	public int getPasswordLength() throws NumberFormatException {
		return Integer.parseInt(passwordLength.getText());
	}
	
	public Integer[] getPasswordOptions() {
		ArrayList<Integer> options = new ArrayList<Integer>();
		if (lowerAlpha.isSelected()) {
			options.add(PGUtil.Options.ALPHA_LOWER);
		}
		
		if (upperAlpha.isSelected()) {
			options.add(PGUtil.Options.ALPHA_UPPER);
		}
		
		if (numbers.isSelected()) {
			options.add(PGUtil.Options.NUMBERS);
		}
		
		if (punctuation.isSelected()) {
			options.add(PGUtil.Options.PUNCTUATION);
		}
		Integer[] pgOptions = new Integer[options.size()];
		return options.toArray(pgOptions);
	}
	
	

}
