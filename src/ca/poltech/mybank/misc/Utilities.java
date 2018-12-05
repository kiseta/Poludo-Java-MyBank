package ca.poltech.mybank.misc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ca.poltech.mybank.address.Address;
import ca.poltech.mybank.customer.Customer;
import ca.poltech.mybank.product.Product;
import ca.poltech.mybank.product.account.Account;
import ca.poltech.mybank.product.account.CheckingAccount;
import ca.poltech.mybank.product.account.SavingsAccount;

public class Utilities {
	private static Pattern canadaZipCodePattern = Pattern.compile(Constants.CANADA_POSTAL_CODE_REGEX);
	private static Pattern decimalNumberPattern = Pattern.compile(Constants.DECIMAL_NUMBER_REGEX);
	private static Pattern datePattern = Pattern.compile(Constants.BIRTH_DATE_REGEX);
	private static SimpleDateFormat dateFormatter = new SimpleDateFormat(Constants.BIRTH_DATE_ACCEPTED_FORMAT);

	/**
	 * This method returns a Date out of a Calendar
	 * 
	 * @param year
	 * @param month
	 *            (first month of the year is 0)
	 * @param dayOfMonth
	 * @return the Date
	 */
	public static Date getDate(int year, int month, int dayOfMonth) {
		final Calendar myCalendar = Calendar.getInstance();
		myCalendar.set(Calendar.YEAR, year);
		myCalendar.set(Calendar.MONTH, month);
		myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

		return myCalendar.getTime();
	}

	public static Account createAccountFromUserInput(final Scanner scan) throws ParseException {
		String accountType;
		final Date openingDate;
		String dateString = "";

		System.out.println("----------------------ACCOUNT INFORMATION----------------------");

		do {
			accountType = getUserInput("Please select the Account Type (C for checking and S for savings):", scan,
					false, false);
		} while (!accountType.matches("C|S"));

		do {
			dateString = getUserInput("Please enter the opening date (dd/mm/yyyy):", scan, false, false);
		} while (!validateDate(dateString));

		openingDate = dateFormatter.parse(dateString);

		final double balance = Double.parseDouble(getUserInput("Please enter the initial balance:", scan, true, true));

		Account account;

		if (accountType.equalsIgnoreCase("c")) {
			final double limit = Double.parseDouble(getUserInput("Please enter the account limit:", scan, true, true));
			final double serviceFee = Double
					.parseDouble(getUserInput("Please enter the service fee:", scan, true, true));
			final double monthlyFee = Double
					.parseDouble(getUserInput("Please enter the monthly fee:", scan, true, true));

			account = new CheckingAccount(openingDate, balance, limit, serviceFee, monthlyFee);
		} else {
			final double interestRate = Double
					.parseDouble(getUserInput("Please enter the interest rate:", scan, true, true));
			final double interestInterval = Double
					.parseDouble(getUserInput("Please enter the interest interva (in days):", scan, true, true));
			account = new SavingsAccount(openingDate, balance, interestRate, interestInterval);
		}
		System.out.println("----------------------------------------------------------------\n");

		return account;
	}

	public static Customer createCustomerFromUserInput(final Scanner scan) throws ParseException {

		System.out.println("----------------------CUSTOMER INFORMATION----------------------");
		final String id = getUserInput("Please enter the identification number:", scan, false, false);
		final String name = getUserInput("Please enter the name:", scan, false, false);
		final String gender = getUserInput("Please enter the gender:", scan, false, false);
		final Date birthDate;
		String dateString;

		do {
			dateString = getUserInput("Please enter the birth date (dd/mm/yyyy):", scan, false, false);
		} while (!validateDate(dateString));

		birthDate = dateFormatter.parse(dateString);

		final Address address = createAddressFromUserInput(scan);

		final Product[] products = new Product[] {};

		Customer customer = new Customer(id, name, gender, birthDate, address, products);
		String insertNewAccount;

		do {
			insertNewAccount = getUserInput("Do you want to add an account for this cusomer (yes | no)?", scan, false,
					false);

			if (insertNewAccount.equals("no")) {
				break;
			} else if (insertNewAccount.equals("yes")) {
				customer.addProduct((Product)createAccountFromUserInput(scan));
			}

		} while (!insertNewAccount.equals("no"));
		System.out.println("----------------------------------------------------------------\n");
		return customer;
	}

	public static Address createAddressFromUserInput(final Scanner scan) {

		String zipCode;
		System.out.println("----------------------ADDRESS INFORMATION----------------------\n");
		do {
			zipCode = getUserInput("Please enter the Zipcode:", scan, false, false);
		} while (!validatePostalCode(zipCode));

		final String address = getUserInput("Please enter the Address:", scan, false, false);
		final String unitNumber = getUserInput("Please enter the Unit number:", scan, true, false);
		final String city = getUserInput("Please enter the city:", scan, false, false);
		final String province = getUserInput("Please enter the province:", scan, false, false);
		final String country = getUserInput("Please enter the country:", scan, false, false);

		System.out.println("----------------------------------------------------------------\n");

		return new Address(zipCode, address, unitNumber, city, province, country);
	}

	public static String getUserInput(String message, Scanner scan, boolean acceptsEmptyValues, boolean numbersOnly) {

		String value;

		do {
			System.out.print(message);
			value = scan.nextLine();
		} while ((!acceptsEmptyValues && value.isEmpty()) || (numbersOnly && !validateDoubleValue(value)));

		return value;
	}

	public static boolean validatePostalCode(String postalCode) {
		if (null == postalCode) {
			return false;
		}

		final Matcher matcher = canadaZipCodePattern.matcher(postalCode);
		return matcher.matches();
	}

	public static boolean validateDoubleValue(String value) {
		if (null == value) {
			return false;
		}

		final Matcher matcher = decimalNumberPattern.matcher(value);
		return matcher.matches();
	}

	public static boolean validateDate(String value) {
		if (null == value) {
			return false;
		}
		final Matcher matcher = datePattern.matcher(value);
		return matcher.matches();
	}

	public static boolean transferMoney(Account src, Account destination, double value) {
		// dont accept null destinations
		if (destination == null) {
			return false;
		}
		// first withdraw from my account and then send it to the destination
		if (src.withdraw(value)) {
			destination.deposit(value);
			return true;
		}
		return false;
	}

}