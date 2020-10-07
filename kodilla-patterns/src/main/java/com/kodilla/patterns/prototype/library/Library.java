package com.kodilla.patterns.prototype.library;

import java.util.HashSet;
import java.util.Set;

public final class Library extends Prototype<Library> {
    String name;
    Set<Book> books = new HashSet<>();

    public Library(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public Library shallowCopy() throws CloneNotSupportedException {
        return super.clone();
    }

    public Library deepCopy() throws CloneNotSupportedException {
        Library clonedLibrary = super.clone();
        clonedLibrary.books = new HashSet<>();
        books.stream()
                .forEach(book -> clonedLibrary.books.add(new Book(book.getTitle(), book.getAuthor(), book.getPublicationDate())));
        return clonedLibrary;
    }

    @Override
    public String toString() {
        return name + '\n' + books + "\n";
    }
}