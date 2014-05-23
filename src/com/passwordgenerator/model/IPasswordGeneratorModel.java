package com.passwordgenerator.model;

public interface IPasswordGeneratorModel {
	public String[] getPasswords(int numNeeded, int length, Integer[] options);
}
