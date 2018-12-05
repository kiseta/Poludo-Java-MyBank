package ca.poltech.mybank.customer;

import java.util.Arrays;
import java.util.Date;

import ca.poltech.mybank.address.Address;
import ca.poltech.mybank.product.Product;
import ca.poltech.mybank.product.account.Account;

public class Customer {

	private String id;
	private String name;
	private String gender;
	private Date birthDate;
	private Address address;
	private Product[] products;

	public Customer(String id, String name, String gender, Date birthDate, Address address, Product[] products) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.birthDate = birthDate;
		this.address = address;
		this.products = products;
	}

	// GETTERS AND SETTERS

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

	public Product[] getProducts() {
		return products;
	}

	public void setProducts(Product[] products) {
		this.products = products;
	}

	/**
	 * Add a new account to the existing accounts array
	 * 
	 * @param product
	 */
	public void addProduct(Product product) {
		// creates an array with one more position so it can hold the new Account
		Product newArray[] = new Product[this.products.length + 1];

		// Copy all the old array accounts to the new array
		System.arraycopy(this.products, 0, newArray, 0, this.products.length);

		// putting the newly created account into the last position of the new array
		newArray[newArray.length - 1] = product;

		// Pointing the account memory address to the same memory address as the created
		// array
		this.products = newArray;

	}

	/**
	 * Inserts one or more account in the existing account array
	 * 
	 * @param accounts
	 */
	public void addAccounts(Product[] products) {

		if (products.length > 0) {

			int newArraySize = this.products.length + products.length;

			Product newArray[] = new Product[newArraySize];

			// Copy all the old arrays accounts to the new array
			System.arraycopy(this.products, 0, newArray, 0, this.products.length);
			System.arraycopy(products, 0, newArray, this.products.length, products.length);

			this.products = newArray;

		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Customer [id=" + id + ", name=" + name + ", gender=" + gender
				+ ", birthDate=" + birthDate + ",\naddress=" + address + ", products=");

		for (Product prod : products) {
			sb.append("[").append(prod).append("]");
		}

		sb.append("]");

		return sb.toString();
	}
}
