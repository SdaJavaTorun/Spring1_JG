package com.example.bookstore.model;

        import java.util.List;


public class BookListing {

    private List<Book> books;
    private int count;

    public BookListing(List<Book> books, int count) {
        this.books = books;
        this.count = count;
    }

    public List<Book> getBooks() {
        return books;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "BookListing{" +
                "books=" + books +
                ", count=" + count +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookListing that = (BookListing) o;

        if (count != that.count) return false;
        return books != null ? books.equals(that.books) : that.books == null;
    }

    @Override
    public int hashCode() {
        int result = books != null ? books.hashCode() : 0;
        result = 31 * result + count;
        return result;
    }
}