package com.task.services;

import com.task.models.EBook;

public class MailService {
    public static void mail(EBook eBook, String emailAddress)
    {
        System.out.println("Mailing eBook: " + eBook.getTitle() + " to email address: " + emailAddress);
    }
}
