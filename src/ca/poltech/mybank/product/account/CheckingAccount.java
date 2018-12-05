package ca.poltech.mybank.product.account;

import java.util.Date;

import ca.poltech.mybank.misc.Utilities;
import ca.poltech.mybank.product.Product;

public class CheckingAccount extends Product implements Account {

	private double serviceFee;
	private double limit;
	private double balance;
	private double monthlyFee;

	public CheckingAccount(Date openingDate, double balance, double limit, double serviceFee, double monthlyFee) {
		super(openingDate, monthlyFee);

		this.balance = balance;
		this.serviceFee = serviceFee;
		this.limit = limit;
	}

	public double getServiceFee() {
		return serviceFee;
	}

	public void setServiceFee(double serviceFee) {
		this.serviceFee = serviceFee;
	}

	public double getLimit() {
		return limit;
	}

	public void setLimit(double limit) {
		this.limit = limit;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getMonthlyFee() {
		return monthlyFee;
	}

	public void setMonthlyFee(double monthlyFee) {
		this.monthlyFee = monthlyFee;
	}

	@Override
	public final boolean transferTo(Account destination, double value) {
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
		final double finalBalance = this.balance - value - this.serviceFee;

		if (finalBalance < 0) {

			if (finalBalance >= this.limit) {
				this.balance = finalBalance;
				return true;
			}
		} else if (finalBalance >= 0) {
			this.balance = finalBalance;
			return true;
		}
		// TODO at home - Before showing the message, check if the user is already using
		// his limit and show the information
		System.out.println("You dont have enough funds to execute this transaction. Your current balance is :"
				+ (this.balance + this.limit));
		return false;
	}

	@Override
	public String toString() {
		return "CheckingAccount [serviceFee=" + serviceFee + ", limit=" + limit + ", balance=" + balance
				+ ", monthlyFee=" + monthlyFee + ", id=" + id + ", openingDate=" + openingDate + ", lastUpdate="
				+ lastUpdate + ", status=" + status + "]";
	}
}
