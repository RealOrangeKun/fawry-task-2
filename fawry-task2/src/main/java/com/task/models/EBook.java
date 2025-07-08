package com.task.models;

import com.task.interfaces.Buyable;
import com.task.services.MailService;

public class EBook extends Book implements Buyable{
    private final String fileType;

    public EBook(String isbn, String title, int publishYear, double price, String author, String fileType) {
        super(isbn, title, publishYear, price, author);
        this.fileType = fileType;
    }

    public String getFileType() {
        return fileType;
    }

    @Override
    public void buy(int quantity, String address, String emailAddress) {
        System.out.println("Ebook being sent to email address: " + emailAddress);
        MailService.mail(this, emailAddress);
        System.out.println("Ebook sent to email address: " + emailAddress);
        System.out.println("EBook purchased: " + getTitle() + " in " + fileType + " format.");
    }

    @Override
    public boolean hasStock(int quantity) {
        return true; // Digital books have unlimited stock
    }


}
