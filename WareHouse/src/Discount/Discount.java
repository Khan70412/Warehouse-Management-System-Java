package Discount;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class Discount implements Serializable {

	private String code;
	private LocalDate startDate;
	private LocalDate endDate;
	private boolean active;

	protected Discount(String code, LocalDate start, LocalDate end, boolean active) {
		super();
		this.code = code;
		startDate = start;
		endDate = end;
		this.active = active;
	}

	public String getCode() { return code; }
	public LocalDate getStartDate() { return startDate; }
	public LocalDate getEndDate() { return endDate; }
	public boolean isActive() { return active; }
	public void setActive(boolean a) { active = a; }

	public abstract double calculateDiscount(double subtotal);
	public abstract String getDetails();
	public abstract String detailsTail();
	public abstract String ActiveDiscounts();

	public static boolean overlaps(Discount a, Discount b) {
		if (a == null || b == null)
			return false;
		else if (a == b)
			return false;
		// FIXED: Uses correct date overlap logic
		return !a.startDate.isAfter(b.endDate) && !a.endDate.isBefore(b.startDate);
	}
}