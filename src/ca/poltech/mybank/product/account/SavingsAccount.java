package ca.poltech.mybank.product.account;

import java.util.Date;

import ca.poltech.mybank.misc.Utilities;
import ca.poltech.mybank.product.Product;

public class SavingsAccount extends Product implements Account {
	private double interestRate;
	private double interestInterval;
	private double balance;

	/**
	 * Creates a new Saving account object
	 * @param openingDate
	 * @param balance 
	 * @param interestRate
	 * @param interestInterval (in days)
	 */
	public SavingsAccount(Date openingDate, double balance, double interestRate, double interestInterval) {
		super(openingDate, 0D);
		this.balance = balance;
		this.interestInterval = interestInterval;
		this.interestRate = interestRate;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public double getInterestInterval() {
		return interestInterval;
	}

	public void setInterestInterval(double interestInterval) {
		this.interestInterval = interestInterval;
	}

	@Override
	public boolean transferTo(Account destination, double value) {
		return Utilities.transferMoney(this, destination, value);
	}

	@Override
	public boolean deposit(double value) {
		if (value < 0) {
			return false;
		}
		this.balance += value;
		return true;
	}

	@Override
	public boolean withdraw(double value) {
		final double finalBalance = this.balance - value;

		if (finalBalance >= 0) {
			this.balance = finalBalance;
			return true;
		}
		
		System.out.println(
				"You dont have enough funds to execute this transaction. Your current balance is :" + this.balance);
		return false;
	}

	@Override
	public double getBalance() {
		return balance;
	}

	@Override
	public String toString() {
		return "SavingsAccount [interestRate=" + interestRate + ", interestInterval=" + interestInterval + ", balance="
				+ balance + ", id=" + id + ", openingDate=" + openingDate + ", lastUpdate=" + lastUpdate + ", status="
				+ status + ", monthlyFee=" + monthlyFee + "]";
	}
}
