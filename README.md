# Warehouse Management System

## Project Overview
A comprehensive, console-based Java application designed to simulate a complete online warehouse workflow. This system handles everything from inventory management and complex discount logic to customer order processing, dynamic shipping calculations, and shipment tracking.

## Key Features

### Staff Interface
* **Inventory Management:** Add and categorize products (Books, Electronics, Groceries) with specific stock limits, prices, and weights.
* **Discount Management:** Create percentage-based or fixed-amount discounts. The system automatically enforces business rules to prevent overlapping active discounts.
* **Shipment Tracking:** Update customer shipment statuses through a structured pipeline (Created, Packed, In Transit, Out for Delivery, Delivered).
* **Comprehensive Reporting:** Generate detailed operational reports, including daily sales, top-selling items by volume, low-stock/out-of-stock alerts, discount usage analytics, inventory valuation, and total system revenue.
* **Customer Registry:** Register new customers to the warehouse system and view their details.

### Customer Interface
* **Product Browsing:** View available warehouse stock neatly organized by product category.
* **Shopping Cart Management:** Add or remove items while the system dynamically validates available warehouse stock in real-time.
* **Dynamic Checkout System:** Automatically calculates subtotals, applies active system discounts, and computes shipping fees based on the cumulative weight of the cart.
* **Payment Processing:** Supports mock transactions via Credit/Debit Card or Cash, generating a detailed order summary upon completion.

## Technical Architecture
This application is heavily rooted in core Object-Oriented Programming (OOP) principles and Java fundamentals:
* **Inheritance & Polymorphism:** Utilizes abstract base classes (`Product`, `Discount`) extended by specific implementations (`BookProduct`, `ElectronicProduct`, `GroceryProduct`, `PercentageDiscount`, `FixedAmountDiscount`).
* **Interfaces:** Implements a `Payment` interface to standardize `CashPayment` and `CardPayment` processing.
* **Data Persistence:** Uses Java Object Serialization to securely read and write system state to `.dat` files (e.g., `Customer_Data.dat`, `Product_Data.dat`, `Order_Data.dat`), ensuring data is preserved between sessions.
* **State Management:** Utilizes Enums for strictly managing `ShipmentStatus` states.

## Getting Started

### Prerequisites
* Java Development Kit (JDK) 17 or higher.
* A Java-compatible IDE (Eclipse, IntelliJ IDEA, VS Code) or terminal environment.

### Installation & Execution
1. Clone the repository to your local machine.
2. Open the project in your preferred IDE and ensure the `src` directory is set as the Sources Root.
3. Compile and run the `App.java` file located in the `main` package.
4. **Initial Setup:** On the first execution, if the system does not detect existing `.dat` files, it will automatically generate comprehensive Seed Data (dummy customers, products, and active discounts). This allows you to immediately test and explore the application's features without manual data entry.

## Contributors
Developed for CMPS 251 (Object-Oriented Programming):
* **Abdelrahman Moursi**
* **Anas Ali Khan** 
* **Salih Alhaj** 
