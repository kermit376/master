package com.passwordgenerator.view;

public interface IPasswordGeneratorView {
	public int getNumPasswords();
	public int getPasswordLength();
	public Integer[] getPasswordOptions();
	public void setResults(String[] results);
	public void clearResults();
}
