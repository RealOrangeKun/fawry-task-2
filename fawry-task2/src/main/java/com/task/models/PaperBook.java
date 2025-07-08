package com.task.models;

import com.task.interfaces.Buyable;
import com.task.services.ShippingService;

public class PaperBook extends Book implements Buyable {
    private int stock; // Physical inventory count

    public PaperBook(String isbn, String title, int publishYear, double price, String author, int stock) {
        super(isbn, title, publishYear, price, author);
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    @Override
    public void buy(int quantity, String address, String emailAddress) throws IllegalArgumentException {

        if(!hasStock(quantity)) {
            throw new IllegalArgumentException("Not enough stock available");
        }

        stock -= quantity; // Reduce inventory
        ShippingService.ship(this, address, quantity);
        System.out.println("Paper book purchased: " + getTitle() + ". Quantity: " + quantity);
    }

    @Override
    public boolean hasStock(int quantity) {
        return stock >= quantity;
    }


}
