package services;

import models.Book;
import java.util.ArrayList;


public class DefaultBookService {

    private ArrayList<Book> bookList = new ArrayList<>();

    /**
     * Testmethode
     * @return default book
     */
    public Book getDummy() {
        final Book book = new Book();
        book.setId(1l);
        book.setTitle("Titel des Testbuches");
        book.setIsbn13("978-3-16-148410-0");
        book.setIsbn10("3161484100");
        book.setDescription("Testbuch Beschreibung mit interessatem Text");
        book.setPublisher("Verlag XYZ");
        book.setPages(225);
        return book;
    }

    /**
     * Return's list of all books.
     *
     * @return list of all books
     */
    public Book get() {
        return null;
    }

    /**
     * Returns book with given identifier.
     *
     * @param id book identifier
     * @return book with given identifier or {@code null}
     */
    public Book get(final Long id) {
        for (Book book : bookList) {
            if (id == book.getId()) {
                return book;
            }
        }
        return null;
    }

    /**
     * Removes book with given identifier.
     *
     * @param id book identifier
     * @return {@code true} on success  {@code false} on failure
     */
    public Boolean delete(final Long id) {
        for (Book book : bookList) {
            if (id == book.getId()) {
                bookList.remove(book);
                return true;
            }
        }
        return false;
    }

    /**
     * Updates book with given identifier.
     *
     * @param bookToUpdate book with updated fields
     * @return updated book
     */
    public Book update(final Book bookToUpdate) {
        return bookToUpdate;
    }

    /**
     * Adds the given book.
     *
     * @param newBook to add
     * @return added book
     */
    public Book add(final Book newBook) {
        bookList.add(newBook);
        return newBook;
    }
}
