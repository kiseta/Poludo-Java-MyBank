package ca.poltech.mybank.product.account;

	public interface Account {
	
		public abstract boolean transferTo(Account destination, double value);
	
		public abstract boolean deposit(double value);
	
		public abstract boolean withdraw(double value);
		
		public abstract double getBalance();
	}

	
	