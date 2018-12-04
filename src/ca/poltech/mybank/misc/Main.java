package ca.poltech.mybank.misc;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import ca.poltech.mybank.account.Account;
import ca.poltech.mybank.account.CheckingAccount;
import ca.poltech.mybank.address.Address;
import ca.poltech.mybank.customer.Customer;

public class Main {

	public static void main(String[] args) throws ParseException {
		
//		final Scanner scan = new Scanner(System.in);	
//		Customer customer = Utilities.createCustomerFromUserInput(scan);	
//		scan.close();		
//		System.out.println(customer);
		
		
		Account account = new CheckingAccount(new Date(), 2, 45,100);
		
		Account account2 = new CheckingAccount(12345, new Date());
		
		System.out.println(customer);
		

	}

}
