package org.example.Models;

import org.example.Enums.Category;

import java.util.*;

public class User {

    private String userName;
    private Category category;
    private String bookName;

    public User(String userName, Category category, String bookName) {
        this.userName = userName;
        this.category = category;
        this.bookName = bookName;
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
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                '}';
    }
}
