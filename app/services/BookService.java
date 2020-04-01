package services;

import com.google.inject.ImplementedBy;
import models.Book;

import java.util.concurrent.CompletionStage;
import java.util.stream.Stream;


@ImplementedBy(DefaultBookService.class)
public interface BookService {

    /**
     * Return's list of all books.
     * @return list of all books
     */
    CompletionStage<Stream<Book>> get();

    /**
     * Returns book with given identifier.
     * @param id book identifier
     * @return book with given identifier or {@code null}
     */
    CompletionStage<Book> get(final Long id);

    /**
     * Removes book with given identifier.
     * @param id book identifier
     * @return {@code true} on success  {@code false} on failure
     */
    CompletionStage<Boolean> delete(final Long id);

    /**
     * Updates book with given identifier.
     * @param bookToUpdate book with updated fields
     * @return updated book
     */
    CompletionStage<Book> update(final Book bookToUpdate);

    /**
     * Adds the given book.
     * @param newBook to add
     * @return added book
     */
    CompletionStage<Book> add(final Book newBook);

    /**
     * Returns book with dummy data for testing purposes.
     * @return dummy book
     */
    Book getDummy();
}
