package ca.poltech.mybank.misc;

import java.text.ParseException;
import java.util.Scanner;

import ca.poltech.mybank.customer.Customer;

public class Main {

	public static void main(String[] args) throws ParseException {

		Scanner scan = new Scanner(System.in);

		Customer c = Utilities.createCustomerFromUserInput(scan);

		System.out.println(c);

		scan.close();
	}
}
