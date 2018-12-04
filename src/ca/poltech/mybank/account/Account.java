package ca.poltech.mybank.account;

import java.util.Date;
import java.util.UUID;

public class Account {

	public static int ACCOUNT_STATUS_ACTIVE = 1;
	public static int ACCOUNT_STATUS_INACTIVE = 0;

	protected String accountNumber;
	protected Date openingDate;
	protected int status;
	protected double balance;

	public Account(Date openingDate, double balance) {
		super();
		this.accountNumber = UUID.randomUUID().toString();
		this.openingDate = openingDate;
		this.balance = balance;
		this.status = ACCOUNT_STATUS_ACTIVE;
	}

	public boolean withdraw(double value) {

		double finalBalance = this.balance - value;

		if (finalBalance >= 0) {
			this.balance = finalBalance;
			return true;
		}
		return false;
	}

	public boolean deposit(double value) {
		this.balance += value;
		return true;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Date getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(Date openingDate) {
		this.openingDate = openingDate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

//	public static String SAVINGS_ACCOUNT = "savings";
//	public static String CHECKING_ACCOUNT = "checking";
//	
//	private String accountNumber;
//	private String accountType;
//	private double balance;
//	private double limit;
//
//	public Account(String accountType) {
//		//Getting an universal Identifier for this account
//		this.accountNumber =  UUID.randomUUID().toString();
//		this.accountType = accountType;
//	}
//	
//	public Account(String accountType, double balance, double limit) {
//		super();
//		this.accountNumber = UUID.randomUUID().toString();
//		this.accountType = accountType;
//		this.balance = balance;
//		this.limit = limit;
//	}
//
//	public String getAccountNumber() {
//		return accountNumber;
//	}
//
//	public void setAccountNumber(String accountNumber) {
//		this.accountNumber = accountNumber;
//	}
//
//	public String getAccountType() {
//		return accountType;
//	}
//
//	public void setAccountType(String accountType) {
//		this.accountType = accountType;
//	}
//
//	public double getBalance() {
//		return balance;
//	}
//	
//	public double getBalanceWithLimit() {
//		return balance + limit;
//	}
//
//	public void setBalance(double balance) {
//		this.balance = balance;
//	}
//
//	public double getLimit() {
//		return limit;
//	}
//
//	public void setLimit(double limit) {
//		this.limit = limit;
//	}
//
//	@Override
//	public String toString() {
//		super.toString();
//
//		return "Account [accountNumber=" + accountNumber + ", accountType=" + accountType 
//				+ ", balance=" + balance + ", limit=" + limit + "]";
//	}

}
