import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * InventoryManager - A simple command-line application for managing product inventory.
 * This class demonstrates basic object-oriented programming (OOP) principles 
 * by using a separate Item class and managing a collection of items.
 */
public class InventoryManager {

    // Inner class representing an Item in the inventory
    private static class Item {
        private int id;
        private String name;
        private int quantity;
        private double price;

        public Item(int id, String name, int quantity, double price) {
            this.id = id;
            this.name = name;
            this.quantity = quantity;
            this.price = price;
        }

        // Getters
        public int getId() { return id; }
        public String getName() { return name; }
        public int getQuantity() { return quantity; }
        public double getPrice() { return price; }

        // Setters (useful for updating items later)
        public void setQuantity(int quantity) { this.quantity = quantity; }
        public void setPrice(double price) { this.price = price; }

        @Override
        public String toString() {
            return String.format("ID: %d | Name: %s | Quantity: %d | Price: $%.2f",
                id, name, quantity, price);
        }
    }

    private List<Item> inventory;
    private Scanner scanner;
    private int nextId = 1;

    public InventoryManager() {
        this.inventory = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        // Add a few initial items for testing
        addItem("Laptop", 10, 899.99);
        addItem("Mouse", 50, 15.50);
    }

    // --- Core Functionality Methods ---

    /**
     * Adds a new item to the inventory.
     */
    public void addItem(String name, int quantity, double price) {
        Item newItem = new Item(nextId++, name, quantity, price);
        inventory.add(newItem);
        System.out.println("-> Added: " + newItem.getName());
    }

    /**
     * Displays all items currently in the inventory.
     */
    public void viewInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }
        System.out.println("\n--- Current Inventory ---");
        for (Item item : inventory) {
            System.out.println(item);
        }
        System.out.println("-------------------------\n");
    }

    /**
     * Finds an item by its ID.
     */
    private Item findItemById(int id) {
        for (Item item : inventory) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    /**
     * Updates the quantity and price of an existing item.
     */
    public void updateItemDetails(int id, int newQuantity, double newPrice) {
        Item item = findItemById(id);
        if (item != null) {
            item.setQuantity(newQuantity);
            item.setPrice(newPrice);
            System.out.printf("-> Updated details for ID %d. New Quantity: %d, New Price: $%.2f\n", id, newQuantity, newPrice);
        } else {
            System.out.println("Error: Item with ID " + id + " not found.");
        }
    }

    // --- Main Application Loop ---

    private void displayMenu() {
        System.out.println("Inventory Management System");
        System.out.println("1. View Inventory");
        System.out.println("2. Add New Item");
        System.out.println("3. Update Item Details (Quantity & Price)");
        System.out.println("4. Exit");
        System.out.print("Enter choice: ");
    }

    public void run() {
        int choice = 0;
        do {
            displayMenu();
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                
                switch (choice) {
                    case 1:
                        viewInventory();
                        break;
                    case 2:
                        handleAddItem();
                        break;
                    case 3:
                        handleUpdateItemDetails();
                        break;
                    case 4:
                        System.out.println("Exiting application. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Consume invalid input
                choice = 0; // Reset choice to keep loop running
            }
        } while (choice != 4);
    }
    
    // --- Input Handlers (for better organization) ---

    private void handleAddItem() {
        System.out.print("Enter item name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter item quantity: ");
        int quantity = 0;
        if (scanner.hasNextInt()) {
            quantity = scanner.nextInt();
            scanner.nextLine();
        } else {
            System.out.println("Invalid quantity format. Operation cancelled.");
            scanner.nextLine();
            return;
        }

        System.out.print("Enter item price: ");
        double price = 0.0;
        if (scanner.hasNextDouble()) {
            price = scanner.nextDouble();
            scanner.nextLine();
        } else {
            System.out.println("Invalid price format. Operation cancelled.");
            scanner.nextLine();
            return;
        }
        
        addItem(name, quantity, price);
    }
    
    private void handleUpdateItemDetails() {
        System.out.print("Enter Item ID to update: ");
        int id = 0;
        if (scanner.hasNextInt()) {
            id = scanner.nextInt();
            scanner.nextLine();
        } else {
            System.out.println("Invalid ID format. Operation cancelled.");
            scanner.nextLine();
            return;
        }

        System.out.print("Enter new quantity: ");
        int newQuantity = 0;
        if (scanner.hasNextInt()) {
            newQuantity = scanner.nextInt();
            scanner.nextLine();
        } else {
            System.out.println("Invalid quantity format. Operation cancelled.");
            scanner.nextLine();
            return;
        }

        System.out.print("Enter new price: ");
        double newPrice = 0.0;
        if (scanner.hasNextDouble()) {
            newPrice = scanner.nextDouble();
            scanner.nextLine();
        } else {
            System.out.println("Invalid price format. Operation cancelled.");
            scanner.nextLine();
            return;
        }
        
        updateItemDetails(id, newQuantity, newPrice);
    }

    /**
     * Main method to start the application.
     */
    public static void main(String[] args) {
        InventoryManager app = new InventoryManager();
        app.run();
    }
}