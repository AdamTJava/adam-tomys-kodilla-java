package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclassifier.librarya.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class MedianAdapterTestSuite {

    @Test
    void testPublicationYearMedian() {
        //Given
        MedianAdapter adapter = new MedianAdapter();
        Set<Book> books = new HashSet<>();
        Book book1 = new Book("author1", "title1", 2005, "sig1");
        Book book2 = new Book("author2", "title2", 2011, "sig2");
        Book book3 = new Book("author3", "title3", 2018, "sig3");
        Book book4 = new Book("author4", "title4", 1997, "sig4");
        Book book5 = new Book("author5", "title5", 2013, "sig5");
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);

        //When
        int median = adapter.publicationYearMedian(books);

        //Then
        Assertions.assertEquals(2011, median);
    }
}
