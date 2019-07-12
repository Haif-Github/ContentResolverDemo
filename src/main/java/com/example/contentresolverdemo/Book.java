package com.example.contentresolverdemo;

/**
 * Created by haif on 2019/7/13.
 */

public class Book {
    public int bookId;
    public String bookName;

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                '}';
    }
}
