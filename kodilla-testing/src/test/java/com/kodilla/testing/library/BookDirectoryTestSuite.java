package com.kodilla.testing.library;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
    public class BookDirectoryTestSuite {

    @Nested
    @DisplayName("Book tests")
    class TestBooks {

        @Mock
        private LibraryDatabase libraryDatabaseMock;

        @Test
        void testListBooksWithConditionsReturnList() {

            // Given
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            List<Book> resultListOfBooks = new ArrayList<>();
            Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
            Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);
            Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);
            Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);
            resultListOfBooks.add(book1);
            resultListOfBooks.add(book2);
            resultListOfBooks.add(book3);
            resultListOfBooks.add(book4);
            when(libraryDatabaseMock.listBooksWithCondition("Secret"))
                    .thenReturn(resultListOfBooks);

            // When
            List<Book> theListOfBooks = bookLibrary.listBooksWithCondition("Secret");

            // Then
            assertEquals(4, theListOfBooks.size());
        }

        private List<Book> generateListOfNBooks(int booksQuantity) {
            List<Book> resultList = new ArrayList<>();
            for (int n = 1; n <= booksQuantity; n++) {
                Book theBook = new Book("Title " + n, "Author " + n, 1970 + n);
                resultList.add(theBook);
            }
            return resultList;
        }

        @Test
        void testListBooksWithConditionMoreThan20() {
            // Given
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            List<Book> resultListOf0Books = new ArrayList<Book>();
            List<Book> resultListOf15Books = generateListOfNBooks(15);
            List<Book> resultListOf40Books = generateListOfNBooks(40);
            when(libraryDatabaseMock.listBooksWithCondition(anyString()))
                    .thenReturn(resultListOf15Books);
            when(libraryDatabaseMock.listBooksWithCondition("ZeroBooks"))
                    .thenReturn(resultListOf0Books);
            when(libraryDatabaseMock.listBooksWithCondition("FortyBooks"))
                    .thenReturn(resultListOf40Books);

            // When
            List<Book> theListOfBooks0 = bookLibrary.listBooksWithCondition("ZeroBooks");
            List<Book> theListOfBooks15 = bookLibrary.listBooksWithCondition("Any title");
            List<Book> theListOfBooks40 = bookLibrary.listBooksWithCondition("FortyBooks");

            // Then
            assertEquals(0, theListOfBooks0.size());
            assertEquals(15, theListOfBooks15.size());
            assertEquals(0, theListOfBooks40.size());
        }

        @Test
        void testListBooksWithConditionFragmentShorterThan3() {
            // Given
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            List<Book> resultListOf10Books = generateListOfNBooks(10);
            //when(libraryDatabaseMock.listBooksWithCondition(anyString()))
            //        .thenReturn(resultListOf10Books);

            // When
            List<Book> theListOfBooks10 = bookLibrary.listBooksWithCondition("An");

            // Then
            assertEquals(0, theListOfBooks10.size());
            verify(libraryDatabaseMock, times(0)).listBooksWithCondition(anyString());
        }
    }

    @Nested
    @DisplayName("User tests - task 6.6")
    class TestUser {

        private List<Book> generateListOfNBooks(int booksQuantity) {
            List<Book> resultList = new ArrayList<>();
            for (int n = 1; n <= booksQuantity; n++) {
                Book theBook = new Book("Title " + n, "Author " + n, 1970 + n);
                resultList.add(theBook);
            }
            return resultList;
        }

        @Mock
        private LibraryDatabase libraryDatabaseMock;

        @Test
        void testUserHasNotAnyBooks() {
            //Given
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            LibraryUser user = new LibraryUser("Adam","Tomys", "91043003934");
            List<Book> emptyList = new ArrayList<>();
            when(libraryDatabaseMock.listBooksInHandsOf(user)).thenReturn(emptyList);

            //When
            List<Book> finalTestList = bookLibrary.listBooksInHandsOf(user);

            //Then
            assertEquals(0, finalTestList.size());
        }

        @Test
        void testUserHasOneBook() {
            //Given
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            LibraryUser user = new LibraryUser("Marcin","Kowalski", "90021036548");
            List<Book> oneBookList = new ArrayList<>();
            oneBookList.add(new Book("Clean Code", "Robert Martin", 2014));
            when(libraryDatabaseMock.listBooksInHandsOf(user)).thenReturn(oneBookList);

            //When
            List<Book> finalTestList = bookLibrary.listBooksInHandsOf(user);

            //Then
            assertEquals(1, finalTestList.size());
        }

        @Test
        void testUserHasFiveBooks() {
            //Given
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            LibraryUser user = new LibraryUser("Dawid","Nowak", "88051211589");
            List<Book> fiveBookList = generateListOfNBooks(5);
            when(libraryDatabaseMock.listBooksInHandsOf(user)).thenReturn(fiveBookList);

            //When
            List<Book> finalTestList = bookLibrary.listBooksInHandsOf(user);

            //Then
            assertEquals(5, finalTestList.size());
        }

    }
}