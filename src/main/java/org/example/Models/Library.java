package org.example.Models;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class Library {

    private List<Book> books = new ArrayList<>();

    public Library() {
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void availableBooks() {
        String booking = "";
        for (Book book : books) {
            booking = book.getTitle();
            if (book.getTitle() != null && book.getCopies() > 0) {
                System.out.println("We have " + book.getCopies() + " copies of " + book.getTitle() + " available");
            }else System.out.println(book.getTitle() + " can't be found in this Library...");
        }
    }

    public void addBooksToLibrary(String fileName, String shelfName) {

        try {
            FileInputStream inputStream = new FileInputStream(fileName);

            Workbook workbook = new XSSFWorkbook(inputStream);

            Sheet sheet = workbook.getSheet(shelfName);

            if (sheet != null) {

                for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                    Row row = sheet.getRow(i);
                    Cell bookTitleCell = row.getCell(0);
                    Cell bookAuthorCell = row.getCell(1);
                    Cell bookCopiesCell = row.getCell(2);

                    if (bookTitleCell != null && bookAuthorCell != null && bookCopiesCell != null) {
                        String bookTitle = bookTitleCell.getStringCellValue();
                        String bookAuthor = bookAuthorCell.getStringCellValue();
                        int bookCopies = (int) bookCopiesCell.getNumericCellValue();
                        Book book = new Book(bookTitle, bookAuthor, bookCopies);


                        books.add(book);

                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);

        }

    }

    @Override
    public String toString() {
        return "Library{" +
                "books=" + books +
                '}';
    }
}