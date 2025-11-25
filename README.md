📦 Inventory Manager (Java CLI Application)

A simple, beginner-friendly command-line inventory management system written in Java.
This project demonstrates fundamental Object-Oriented Programming (OOP) concepts such as classes, objects, encapsulation, lists, and user interaction via the console.

🚀 Features

➕ Add New Items
Add products with name, quantity, and price. Each item gets a unique auto-incremented ID.

📃 View Inventory
Displays all items in a clean, readable format.

✏️ Update Item Details
Modify the quantity and price of any product using its ID.

🔎 Find Items by ID
Internal helper method used for searching items in the list.

🛠 Object-Oriented Design
Uses a dedicated Item class (as an inner class) to store product details neatly.

🎯 Beginner-friendly Code Structure
Includes input validation and organized handler methods.

🗂️ Project Structure
| Component                   | Description                                           |
| --------------------------- | ----------------------------------------------------- |
| `InventoryManager`          | Main class of the application                         |
| `Item` (inner class)        | Stores product details like ID, name, quantity, price |
| `addItem()`                 | Adds new items to the inventory                       |
| `viewInventory()`           | Displays all items                                    |
| `findItemById(int)`         | Searches inventory by ID                              |
| `updateItemDetails()`       | Updates quantity and price                            |
| `run()`                     | Main CLI loop with menu                               |
| `handleAddItem()`           | Input handler for adding items                        |
| `handleUpdateItemDetails()` | Input handler for updating items                      |
| `main()`                    | Entry point                                           |


📥 How to Run

1.Clone this repository:

git clone https://github.com/your-username/inventory-manager.git
cd inventory-manager


2.Compile the Java file:

javac InventoryManager.java


3.Run the application:

java InventoryManager

📊 Application Menu

When you run the app, you will see:

Inventory Management System
1. View Inventory
2. Add New Item
3. Update Item Details (Quantity & Price)
4. Exit
Enter choice:

📘 Example Output
--- Current Inventory ---
ID: 1 | Name: Laptop | Quantity: 10 | Price: $899.99
ID: 2 | Name: Mouse  | Quantity: 50 | Price: $15.50
-------------------------

🧱 Code Concepts Used
✔ Object-Oriented Programming

Class & Objects: Item class represents each product.

Encapsulation: Private fields + getters/setters.

Composition: InventoryManager holds a List<Item>.

✔ Java Collections

Uses ArrayList to store items dynamically.

✔ Input Handling

Clean and robust user input validation with Scanner.

✔ Modular Methods

Separate handler methods improve readability and maintainability.

🔮 Future Improvements

You can enhance this project by adding:

❗ Delete item by ID

💾 Save inventory to a file

📥 Load inventory at startup

🧮 Calculate total inventory value

🖥 Convert into GUI app (JavaFX/Swing)
