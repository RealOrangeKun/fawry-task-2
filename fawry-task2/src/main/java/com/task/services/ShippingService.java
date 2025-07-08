package com.task.services;

import com.task.models.PaperBook;

public class ShippingService {

    public static void ship(PaperBook book, String address, int quantity) {
        System.out.println("Shipping book: " + book.getTitle() + " to address: " + address + " with quantity: " + quantity);
    }
}
