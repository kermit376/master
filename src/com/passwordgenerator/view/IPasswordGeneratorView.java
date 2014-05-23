package com.passwordgenerator.view;

/**
 * 
 * @author mike
 *
 */
public interface IPasswordGeneratorView {
	public int getNumPasswords();
	public int getPasswordLength();
	public Integer[] getPasswordOptions();
	public void setResults(String[] results);
	public void clearResults();
}
