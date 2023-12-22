package org.example.Models;

import org.example.Services.LibrarianServiceImpl;

import java.util.*;

public class Librarian {

    private String name;

    public Librarian(String name) {
        this.name = name;
    }

    public Librarian() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void giveOutBook(Library library, Queue<OrderUser> orderUserPriorityQueue) {

        List<Book> libraryBookList = library.getBooks();

        for (OrderUser orderUser: orderUserPriorityQueue){
            String bookName= orderUser.getBookName();
            if (bookName != null){
                for (Book libraryBook: libraryBookList){
                    if (bookName.equals(libraryBook.getTitle())) {
                        if (libraryBook.getCopies()< 1){
                            System.out.println(orderUser.getUserName() + ", "
                                    +bookName + " has been taken already.");
                        } else {
                            int remainingCopies = libraryBook.getCopies();
                            remainingCopies --;
                            libraryBook.setCopies(remainingCopies);
                            System.out.println(bookName + " has been borrowed by " + orderUser.getUserName()
                                    + "." );
                        }

                    }
                }
            }
        }

    }

    public void giveOutBook2 (Library library, Queue<OrderUser> orderUserPriorityQueue) {

        List<Book> libraryBookList = library.getBooks();
        orderUserPriorityQueue.forEach(user -> libraryBookList.stream()
                .filter(book -> book.getTitle().equals(user.getBookName()))
                .findFirst().ifPresent(book -> {
                    if (book.getCopies()< 1){
                        System.out.println(user.getUserName() + ", "
                                +book.getTitle() + " has been taken already.");
                    } else {
                        int remainingCopies = book.getCopies();
                        remainingCopies --;
                        book.setCopies(remainingCopies);
                        System.out.println(book.getTitle() + " has been borrowed by " + user.getUserName()
                                + "." );
                    }
                }));
    }



        @Override
    public String toString() {
        return "Librarian{" +
                "name='" + name + '\'' +
                '}';
    }

}
