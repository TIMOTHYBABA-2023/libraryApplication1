package org.example;

import org.example.Enums.Category;
import org.example.Models.*;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.SortedSet;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");


        String fileName1 = "C:/Users/TIMOTHY O. BABA/IdeaProjects/LibraryBooks.xlsx";
        String sheetName1 = "graphic novels";

        Library library = new Library();
        library.addBooksToLibrary(fileName1,sheetName1);

        User user1 = new User("James", Category.JUNIOR_STUDENT, "Animal Stories");
        User user2 = new User("Comfort", Category.SENIOR_STUDENT, "Alone forever");
        User user3 = new User("Bob", Category.JUNIOR_STUDENT,"Alone forever");
        User user4 = new User("Timothy", Category.TEACHER,"Alone forever");
        User user5 = new User("Charles", Category.SENIOR_STUDENT,"Animal Stories");
        User user6 = new User("Tammy", Category.TEACHER,"Animal Stories");


        System.out.println("***********************");
        library.availableBooks();
        System.out.println("***********************");

        OrderUser orderUser1 = new OrderUser(user1);
        OrderUser orderUser2 = new OrderUser(user2);
        OrderUser orderUser3 = new OrderUser(user3);
        OrderUser orderUser4 = new OrderUser(user4);
        OrderUser orderUser5 = new OrderUser(user5);
        OrderUser orderUser6 = new OrderUser(user6);

        Queue<OrderUser> fifo = new PriorityQueue<>();
        Queue<OrderUser> priorityQueue = new PriorityQueue<>(new PriorityUser());

        fifo.add(orderUser1);
        fifo.add(orderUser2);
        fifo.add(orderUser3);
        fifo.add(orderUser4);
        fifo.add(orderUser5);
        fifo.add(orderUser6);

        priorityQueue.add(orderUser1);
        priorityQueue.add(orderUser2);
        priorityQueue.add(orderUser3);
        priorityQueue.add(orderUser4);
        priorityQueue.add(orderUser5);
        priorityQueue.add(orderUser6);

        Librarian librarian = new Librarian();

        System.out.println("***********************");
        System.out.println("***********************");
        librarian.giveOutBook2(library, fifo);

        System.out.println("***********************");
        librarian.giveOutBook2(library,priorityQueue);

        System.out.println("***********************");
        library.availableBooks();
        System.out.println("***********************");

        
        SortedSet<String> sortedSet = new TreeSet<>();
        sortedSet.add("pop");
        sortedSet.add("1");
        sortedSet.add("bob");
        sortedSet.add("five");
        System.out.println(sortedSet);
    }
}