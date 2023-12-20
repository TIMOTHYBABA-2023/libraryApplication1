package org.example.Models;

import org.example.Enums.Category;

import java.util.ArrayList;
import java.util.List;

public class OrderUser implements Comparable<OrderUser>{
    private Integer orderId;
    private String userName;
    private Category category;
    private String bookName;
    private User user;

    public OrderUser(User user) {
        this.user = user;
        this.userName = user.getUserName();
        this.category = user.getCategory();
        this.bookName = user.getBookName();
        if (category == Category.TEACHER){
            this.orderId = 3;
        } else if (category == Category.SENIOR_STUDENT){
            this.orderId = 2;
        } else this.orderId = 1;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public int compareTo(OrderUser o) {
        return o.orderId < this.orderId ? 1 : 0;
    }

    @Override
    public String toString() {
        return "OrderUser{" +
                "orderId=" + orderId +
                ", userName='" + userName + '\'' +
                ", category=" + category +
                ", user=" + user +
                '}';
    }
}
