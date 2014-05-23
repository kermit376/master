package com.passwordgenerator.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.passwordgenerator.util.PGUtil;

public class PasswordGeneratorControlPanel extends JPanel implements ActionListener {
	
	private static final long serialVersionUID = -3136660395110219220L;
	private IPasswordGeneratorViewListener listener;
	private JButton submit;
	private JButton clear;
	private JButton exit;
	
	public PasswordGeneratorControlPanel(IPasswordGeneratorViewListener listener) {
		this.listener = listener;
		setupPanel();
	}
	
	private final void setupPanel() {
		submit = new JButton("Generate");
		submit.addActionListener(this);
		add(submit);
		
		clear = new JButton("Clear");
		clear.addActionListener(this);
		add(clear);
		
		exit = new JButton("Exit");
		exit.addActionListener(this);
		add(exit);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		int flag;
		if (source.equals(exit)) {
			flag = PGUtil.Flags.EXIT;
		} else if (source.equals(clear)) {
			flag = PGUtil.Flags.CLEAR;
		} else if (source.equals(submit)) {
			flag = PGUtil.Flags.GET_PASSWORDS;
		} else {
			flag = -1;
		}
		
		if (flag != -1) {
			listener.viewActionPerformed(new PasswordGeneratorViewEvent(flag));
		}
	}

}
