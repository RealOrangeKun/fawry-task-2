package com.task.services;

import com.task.interfaces.Buyable;
import com.task.models.Book;

public class PurchaseService {
    
    public static double calculateTotal(Book book, int quantity) {
        return book.getPrice() * quantity;
    }
    
    public static void processPurchase(Buyable buyableBook, int quantity, String address, String email) {
        if (!buyableBook.hasStock(quantity)) {
            throw new IllegalArgumentException("Insufficient stock");
        }
        
        buyableBook.buy(quantity, address, email);
    }
}
