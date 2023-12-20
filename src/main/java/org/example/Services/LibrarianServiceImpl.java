package org.example.Services;

import org.example.Models.Library;
import org.example.Models.OrderUser;

import java.util.Queue;

@FunctionalInterface
public interface LibrarianServiceImpl {

    public void giveOutBook(Library library, Queue<OrderUser> orderUserPriorityQueue);

}

