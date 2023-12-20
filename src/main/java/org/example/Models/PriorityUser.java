package org.example.Models;

import org.example.Enums.Category;

import java.util.Comparator;

public class PriorityUser implements Comparator<OrderUser> {

    @Override
    public int compare(OrderUser o1, OrderUser o2) {
        return o1.getOrderId() < o2.getOrderId() ? 1 : -1;
    }
}
