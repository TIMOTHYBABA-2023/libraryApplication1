package org.example.Models;

import org.example.Services.LibrarianServiceImpl;

import java.util.Queue;
import java.util.function.BiConsumer;

public class FunctionalLibrarian implements LibrarianServiceImpl {


    private BiConsumer<Library, Queue<OrderUser>> giveOutBook = (library, orderUserQueue) -> {

        orderUserQueue.forEach(user -> library.getBooks().stream()
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
    };

    @Override
    public void giveOutBook(Library library, Queue<OrderUser> orderUserQueue) {
        giveOutBook.accept(library, orderUserQueue);
    }

    @Override
    public String toString() {
        return "FunctionalLibrarian{" +
                "giveOutBook=" + giveOutBook +
                '}';
    }
}
