package ca.poltech.mybank.account;

import java.util.Date;

public class SavingsAccount extends Account {

	private double interstRate;
	private double intersInteral;

	public SavingsAccount(Date openingDate, double serviceFee, double limit, double balance) {
		super(openingDate, balance);
		this.interstRate = interstRate;
		this.intersInteral = intersInteral;
	}

}
