package com.passwordgenerator.view;

public class PasswordGeneratorViewEvent implements IPasswordGeneratorViewEvent {

	private int flag;
	
	public PasswordGeneratorViewEvent(int flag) {
		this.flag = flag;
	}
	
	@Override
	public int getFlag() {
		return this.flag;
	}

}
