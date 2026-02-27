package Products;


public class ElectronicProduct extends Product {

	// -------------------------------------

	public ElectronicProduct(String id, String name, double price, double weightKg, int stockQty) {
		super(id, name, price, weightKg, stockQty);
	}

	// ---------------------------------------

	@Override
	public String getCategory() {
		return this.getClass().getSimpleName();
	}

	// -----------------------------

}
