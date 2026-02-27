package main;

import Data.SeedData;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.Scanner;


public class App {
	public static final LocalDate TODAY = LocalDate.of(2025, 10, 24);
	public final static String currency = "QAR";// extra added variable

	private static Scanner sc = new Scanner(System.in);
	private static WarehouseSystem sys = new WarehouseSystem(TODAY);

	// MENU
	// CONSTANTS==============================================================================================

	private static final String WHMENU = "\n=== Single-Warehouse System (" + currency + ") === \r\n"
			+ "1) Staff Menu \r\n" + "2) Customer Menu \r\n" + "0) Exit\r\n\n" + "Choice > ";

	// ============================================================================================================

	public static void main(String[] args) {

		SeedData.load(sys); // loading Data

		// Show System MENU----------------------
		int choice;
		do {
			System.out.print(WHMENU);
			choice = sc.nextInt();// do try catch for invalid input
			switch (choice) {
			case 1 -> StaffMenu.run(sc, sys);
			case 2 -> {
				if (sys.getCustomers().isEmpty())
					System.out.println("No customers in the system");
				else
					CustomerMenu.run(sc, sys);
			}
			case 0 -> exitSystem();
			default -> System.out.println("Invalid choice!, try again(Main Menu)");
			}
		} while (true);
	}

	public static void exitSystem() {
		System.out.println("=== Exiting the system ===");
		System.out.print("Saving Data... ");

        // FIXED: Used try-with-resources to ensure streams close safely
		try {
			if (!sys.getCustomers().isEmpty()) {
				try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Customer_Data.dat"))) {
					out.writeObject(sys.getCustomers());
				}
			}
			if (!sys.getProducts().isEmpty()) {
				try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Product_Data.dat"))) {
					out.writeObject(sys.getProducts());
				}
			}
			if (!sys.getDiscounts().isEmpty()) {
				try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Discount_Data.dat"))) {
					out.writeObject(sys.getDiscounts());
				}
			}
			if (!sys.getOrders().isEmpty()) {
				try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Order_Data.dat"))) {
					out.writeObject(sys.getOrders());
				}
			}
			if (!sys.getShipments().isEmpty()) {
				try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Shipment_Data.dat"))) {
					out.writeObject(sys.getShipments());
				}
			}
		} catch (IOException ioe) {
            System.out.println("Error saving data: " + ioe.getMessage());
		}

		sc.close(); 
		System.exit(0); 
	}
}
