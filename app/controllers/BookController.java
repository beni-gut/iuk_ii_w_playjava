package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.Book;

import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;

import services.BookService;
import services.DefaultBookService;

import javax.inject.Inject;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;

import play.mvc.Http;


public class BookController extends Controller {

    private final BookService bookService;

    @Inject
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    /**
     * Alle Bücher abfragen
     *
     * @param q Suchparameter
     * @return Buch Liste als JSON
     */
    public CompletionStage<Result> books(String q) {
        return bookService.get().thenApplyAsync(bookStream ->
                ok(Json.toJson(bookStream.collect(Collectors.toList())))
        );
    }


    /**
     * Neues Buchdetail erfassen
     *
     * @param request
     * @return neues Buch als JSON
     */
    public CompletionStage<Result> create(Http.Request request) {
        final JsonNode json = request.body().asJson();
        final Book newBook = Json.fromJson(json, Book.class);
        return bookService.add(newBook).thenApplyAsync(book -> ok(Json.toJson(book)));
    }

    /**
     * Buchdetail für Buch mit ID aktualisieren
     *
     * @param id Buch ID
     * @param request Buch
     * @return updated book als JSON
     */
    public CompletionStage<Result> update(Long id, Http.Request request) {
        final JsonNode json = request.body().asJson();
        final Book bookToUpdate = Json.fromJson(json, Book.class);
        bookToUpdate.setId(id);
        return bookService.update(bookToUpdate).thenApplyAsync(book -> ok(Json.toJson(book)));
    }

    /**
     * Abfragen der Buchdetails für ein Buch mit ID
     *
     * @param id Buch ID
     * @return gesuchtes Buch als JSON
     */
    public CompletionStage<Result> details(Long id) {
        return bookService.get(id).thenApplyAsync(book -> ok(Json.toJson(book)));
    }

    /**
     * Buch mit entsprechender ID löschen
     *
     * @param id Buch ID
     * @return boolean
     */
    public CompletionStage<Result> delete(Long id) {
        return bookService.delete(id).thenApplyAsync(removed -> removed ? ok() : internalServerError());
    }


    /**
     * Testmethode
     *
     * @return Default Buch
     */
    public Result dummy() {
        final JsonNode json = Json.toJson(bookService.getDummy());
        return ok(json);
    }
}
