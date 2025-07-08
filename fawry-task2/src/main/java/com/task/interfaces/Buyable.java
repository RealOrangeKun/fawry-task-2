package com.task.interfaces;

public interface Buyable {
    void buy(int quantity, String address, String emailAddress);
    boolean hasStock(int quantity);
}
