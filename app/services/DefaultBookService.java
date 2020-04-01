package services;

import models.Book;
import repository.BookRepository;

import javax.inject.Inject;
import java.util.concurrent.CompletionStage;
import java.util.stream.Stream;


public class DefaultBookService implements BookService {

    private BookRepository bookRepository;

    @Inject
    public DefaultBookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

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
     * @return booklist
     */
    public CompletionStage<Stream<Book>> get() {
        return bookRepository.list();
    }

    /**
     * Returns book with given identifier.
     *
     * @param id book identifier
     * @return book with given identifier or {@code null}
     */
    public CompletionStage<Book> get(final Long id) {
        return bookRepository.find(id);
    }

    /**
     * Removes book with given identifier.
     *
     * @param id book identifier
     * @return {@code true} on success  {@code false} on failure
     */
    public CompletionStage<Boolean> delete(final Long id) {
        return bookRepository.remove(id);
    }

    /**
     * Updates book with given identifier.
     *
     * @param bookToUpdate book with updated fields
     * @return updated book
     */
    public CompletionStage<Book> update(final Book bookToUpdate) {
        return bookRepository.update(bookToUpdate);
    }

    /**
     * Adds the given book.
     *
     * @param newBook to add
     * @return added book
     */
    public CompletionStage<Book> add(final Book newBook) {
        return bookRepository.add(newBook);
    }
}
