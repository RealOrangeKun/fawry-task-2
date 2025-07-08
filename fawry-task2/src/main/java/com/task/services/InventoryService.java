package com.task.services;

import java.time.Year;
import java.util.HashMap;
import java.util.Map;

import com.task.interfaces.Buyable;
import com.task.models.Book;

public class InventoryService {
    private static final Map<String, Book> inventory = new HashMap<>(); // Store books by ISBN
    
    public static void add(Book book) {
        inventory.put(book.getIsbn(), book);
    }

    public static Book find(String isbn) {
        return inventory.get(isbn);
    }
    
    public static boolean exists(String isbn) {
        return inventory.containsKey(isbn);
    }

    public static void removeOutdatedBooks(int years) {
        int currentYear = Year.now().getValue();
        inventory.values().removeIf(book -> currentYear - book.getPublishYear() > years);
    }
    
    public static void removeBook(String isbn) {
        if (!inventory.containsKey(isbn)) {
            throw new RuntimeException("Book not found");
        }
        inventory.remove(isbn);
    }

    public static double buy(String isbn, int quantity, String email, String address) {
        Book book = find(isbn);

        if (book == null) {
            throw new RuntimeException("Book not found");
        }

        // Only buyable books can be purchased
        if (!(book instanceof Buyable buyable)) {
            throw new RuntimeException("Book is not buyable");
        }
        
        PurchaseService.processPurchase(buyable, quantity, address, email);
        double total = PurchaseService.calculateTotal(book, quantity);
        
        System.out.println("Total price for " + quantity + " copies of " + book.getTitle() + ": " + total);
        return total;
    }
}
