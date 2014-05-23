package com.passwordgenerator.view;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class PasswordGeneratorDisplayPanel extends JPanel {

	private static final long serialVersionUID = -1668014499579298342L;
	
	private JTextArea resultsArea;

	public PasswordGeneratorDisplayPanel() {
		setupPanel();
	}
	
	private final void setupPanel() {
		setPreferredSize(new Dimension(305, 150));
		Border border = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		TitledBorder tBorder = BorderFactory.createTitledBorder(border, "Passwords");
		setBorder(tBorder);
		
		resultsArea = new JTextArea(7, 20);
		JScrollPane scroll = new JScrollPane(resultsArea);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		add(scroll);
			
	}
	
	public void setResults(String[] results) {
		resultsArea.setText("");
		for (int i = 0; i < results.length; ++i) {
			resultsArea.append(results[i] + "\n");
		}
	}
	
	public void clearResults() {
		resultsArea.setText("");
	}
	
}
