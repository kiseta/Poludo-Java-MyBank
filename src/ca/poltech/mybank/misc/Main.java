package ca.poltech.mybank.misc;

import java.text.ParseException;
import java.util.Date;

import ca.poltech.mybank.account.Account;
import ca.poltech.mybank.account.CheckingAccount;

public class Main {

	public static void main(String[] args) throws ParseException {

		Account checkingAccount = new CheckingAccount(new Date(), 2, 10, 100);
		System.out.println(checkingAccount);
		System.out.println("----------");
		CheckingAccount  acc = (CheckingAccount) checkingAccount;
		System.out.println(acc);
	}
}
