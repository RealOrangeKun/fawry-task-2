package com.task;

import com.task.models.EBook;
import com.task.models.PaperBook;
import com.task.models.ShowcaseBook;
import com.task.services.InventoryService;

public class TestClass {

    public static void main(String[] args) {
        System.out.println("Testing book store...\n");

        // Run all test scenarios
        addingBooksSuccessful();
        buyingBookSuccess();
        buyingBookFailure();
        buyingShowcaseBookFailure();
        buyingWithInsufficientStock();

        System.out.println("\nDone!");
    }

    private static void addingBooksSuccessful() {
        System.out.println("Test: Adding Books");

        // Create different book types
        PaperBook book1 = new PaperBook("paper1", "Paper Book 1", 2020, 25.99, "Author 1", 10);
        EBook book2 = new EBook("ebook1", "E-Book 1", 2021, 19.99, "Author 2", "PDF");
        ShowcaseBook book3 = new ShowcaseBook("showcase1", "Showcase Book 1", 2022, 35.99, "Author 3");

        InventoryService.add(book1);
        InventoryService.add(book2);
        InventoryService.add(book3);

        System.out.println("Added 3 books\n");
    }

    private static void buyingBookSuccess() {
        System.out.println("Test: Buying Books");

        try {
            InventoryService.buy("paper1", 2, null, "123 Main St, City");
            InventoryService.buy("ebook1", 1, "user@email.com", null);
            System.out.println("Books purchased\n");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() + "\n");
        }
    }

    private static void buyingBookFailure() {
        System.out.println("Test: Buying Non-existent Book");

        try {
            InventoryService.buy("nonexistent1", 1, null, "123 Main St");
            System.out.println("Should have thrown an exception\n");
        } catch (Exception e) {
            System.out.println("Expected error: " + e.getMessage() + "\n");
        }
    }

    private static void buyingShowcaseBookFailure() {
        System.out.println("Test: Buying Showcase Book (Should Fail)");

        try {
            InventoryService.buy("showcase1", 1, null, "123 Main St");
            System.out.println("Should have thrown an exception\n");
        } catch (Exception e) {
            System.out.println("Expected error: " + e.getMessage() + "\n");
        }
    }

    private static void buyingWithInsufficientStock() {
        System.out.println("Test: Buying More Than Available Stock");

        try {
            InventoryService.buy("paper1", 20, null, "123 Main St"); // Only 8 left after previous purchase
            System.out.println("Should have thrown an exception\n");
        } catch (Exception e) {
            System.out.println("Expected error: " + e.getMessage() + "\n");
        }
    }
}
