package Orders;

import Discount.Discount;
import PaymentSystem.Payment;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import main.App;
import main.Customer;

public class Order implements Serializable {
	private String id;
	private LocalDate date;
	private double subtotal;
	private double discountAmount;
	private double shippingFee;
	private double total;
	private Customer customer;
	private ArrayList<OrderItem> items;
	private Discount appliedDiscount;
	private Payment payment;

	public Order(Customer customer, ArrayList<OrderItem> items, double subtotal,
			double discountAmount, double shippingFee, double total, Discount appliedDiscount, Payment payment) {
		this.id = OrderIdGenerator.nextId();
		this.customer = customer;
		this.date = App.TODAY;
		this.items = items;
		this.subtotal = subtotal;
		this.discountAmount = discountAmount;
		this.shippingFee = shippingFee;
		this.total = total;
		this.appliedDiscount = appliedDiscount;
		this.payment = payment;
	}

	public String getId() { return id; }
	public Customer getCustomer() { return customer; }
	public LocalDate getDate() { return date; }
	public ArrayList<OrderItem> getItems() { return items; }
	public double getSubtotal() { return subtotal; }
	public double getDiscountAmount() { return discountAmount; }
	
	public double getShippingFee() {
		return shippingFee; // FIXED: Removed the invalid modification here
	}

	public double getTotal() { return total; }
	public Discount getAppliedDiscount() { return this.appliedDiscount; }
	public Payment getPayment() { return payment; }
}