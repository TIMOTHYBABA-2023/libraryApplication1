package org.example.Services;

import org.example.Models.Library;
import org.example.Models.OrderUser;

import java.util.Queue;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

@FunctionalInterface
public interface LibrarianServiceImpl {
    void giveOutBook(Library library, Queue<OrderUser> orderUserQueue);
}

