package ca.poltech.mybank.product;

import java.util.Date;
import java.util.UUID;

public class Product {
	public static int PRODUCT_STATUS_ACTIVE = 1;
	public static int PRODUCT_STATUS_INACTIVE = 0;

	protected String id;
	protected Date openingDate;
	protected Date lastUpdate;
	protected int status;
	protected double monthlyFee;

	public Product(Date openingDate, double monthlyFee) {
		super();
		this.id = UUID.randomUUID().toString();
		this.openingDate = openingDate;
		this.lastUpdate = new Date();
		this.status = PRODUCT_STATUS_ACTIVE;
		this.monthlyFee = monthlyFee;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(Date openingDate) {
		this.openingDate = openingDate;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public double getMonthlyFee() {
		return monthlyFee;
	}

	public void setMonthlyFee(double monthlyFee) {
		this.monthlyFee = monthlyFee;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", openingDate=" + openingDate + ", lastUpdate=" + lastUpdate + ", status="
				+ status + ", monthlyFee=" + monthlyFee + "]";
	}
}
