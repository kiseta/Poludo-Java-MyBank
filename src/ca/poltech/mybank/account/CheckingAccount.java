package ca.poltech.mybank.account;
import java.util.Date;

public class CheckingAccount extends Account {
	
	private double serviceFee;
	private double limit;
	
	public boolean payBill(double value) {
		return withdraw(value);
	}

	public CheckingAccount(Date openingDate, double serviceFee, double limit, double balance) {
		super(openingDate, balance);
		this.serviceFee = serviceFee;
		this.limit = limit;
	}

	public boolean transferTo(Account destination, double value) {
		
		if (destination == null) {
			return false;
		}
		
		//first withdraw from my account and then send to the destination
		if(this.withdraw(value)) {
			destination.deposit(value);
			return true;
		}
		
		System.out.println("***Not enough funds. Your current balance is: " + this.balance + this.limit);
		return true;
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


	@Override
	public boolean withdraw(double value) {
		
		final double finalBalanace = this.balance + this.limit - value - this.serviceFee;
		
		if(finalBalanace >=0) {
			this.balance = finalBalanace;
			return true;
		}
		return false;
	}




	
	
	
	
}
