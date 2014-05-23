package com.passwordgenerator.controller;

import com.passwordgenerator.model.IPasswordGeneratorModel;
import com.passwordgenerator.model.PasswordGeneratorModel;
import com.passwordgenerator.util.PGUtil;
import com.passwordgenerator.view.IPasswordGeneratorView;
import com.passwordgenerator.view.IPasswordGeneratorViewEvent;
import com.passwordgenerator.view.IPasswordGeneratorViewListener;
import com.passwordgenerator.view.PasswordGeneratorView;

public class PasswordGeneratorController implements IPasswordGeneratorViewListener {

	private IPasswordGeneratorModel model;
	private IPasswordGeneratorView view;
	
	public PasswordGeneratorController() {
		this.model = new PasswordGeneratorModel();
		this.view = new PasswordGeneratorView(this);
	}
	
	private String[] getPasswordsFromModel() {
		int numPasswords = view.getNumPasswords();
		if (numPasswords == 0) {
			return null;
		}
		
		int passwordLength = view.getPasswordLength();
		if (passwordLength == 0) {
			return null;
		}
		
		Integer[] pwOptions = view.getPasswordOptions();
		if (pwOptions.length == 0) {
			return null;
		} 
		return model.getPasswords(numPasswords, passwordLength, pwOptions);
	}
	
	@Override
	public void viewActionPerformed(IPasswordGeneratorViewEvent e) {
		switch (e.getFlag()) {
		case PGUtil.Flags.EXIT:
			System.exit(0);
		case PGUtil.Flags.CLEAR:
			view.clearResults();
			break;
		case PGUtil.Flags.GET_PASSWORDS:
			handleGetPasswords();
			break;
		default:
			break;
		}
	}
	
	private void handleGetPasswords() {
		String[] passwords = getPasswordsFromModel();
		if (passwords != null) {
			view.setResults(passwords);
		}
	}
	
	public static void main(String[] args) {
		new PasswordGeneratorController();
	}
	
}
