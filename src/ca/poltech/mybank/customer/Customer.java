package ca.poltech.mybank.customer;
import java.util.Arrays;
import java.util.Date;

import ca.poltech.mybank.account.Account;
import ca.poltech.mybank.address.Address;

public class Customer {

	//declare variables (fields)
	private String id;
	private String name;
	private String gender;
	private Date birthDate;
	private Address address;
	private Account[] accounts;
	
	public Customer() {
		super();
	}
	
	
	// Constructor
	//->Right Click -> Source -> Generate Constructor using fields
	
	public Customer(String id, String name, String gender, Date birthDate, Address address, Account[] accounts) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.birthDate = birthDate;
		this.address = address;
		this.accounts = accounts;
	}
	
	//getters and setters
	//->Right Click -> Source -> Generate Getters and Setters
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Account[] getAccounts() {
		return accounts;
	}
	public void setAccounts(Account[] accounts) {
		this.accounts = accounts;
	}
	
	/**
	 * insert an account into existing accounts array
	 * @param account
	 */
	//method add account to the accounts array
	public void addAccount(Account account) {
		//create an array with one more position so it can hole the new Account
		Account newArray[] = new Account[accounts.length+1];
		
		//Copy all the old array accounts to the new array
		System.arraycopy(accounts, 0, newArray, 0, accounts.length);
		
		//putting the newly created account into the last position of the new array
		newArray[newArray.length-1] = account;
		
		//pointing the account memory address to the same memory address as the created array
		accounts = newArray;
	}
	
	/**
	 * insert one or more accounts into existing accounts array
	 * @param newAccounts
	 */
	//TO DO at home
	public void addAccounts(Account[] newAccounts) {
		
		int newArraySize = this.accounts.length + newAccounts.length;
		
		//create an array with as many positions as the passed account array
		Account newArray[] = new Account[newArraySize];
		
		System.arraycopy(this.accounts, 0, newArray, 0, this.accounts.length);
		//method 1 array
		//System.arraycopy(newAccounts, 0, newArray, this.accounts.length, newAccounts.length);
		//method 2 loop
		//putting the newly created accounts into the last position of the new array
		for(int i = 0; i < newAccounts.length; i++) {
			newArray[this.accounts.length+i] = newAccounts[i];
		}
				
		//pointing the account memory address to the same memory address as the created array
		accounts = newArray;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", gender=" + gender + ", birthDate=" + birthDate
				+ ", address=" + address + ", accounts=" + Arrays.toString(accounts) + "]";
	}


	
	
}
