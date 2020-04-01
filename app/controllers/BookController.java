package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import play.libs.Json;

import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;

import models.Book;
import services.DefaultBookService;


public class BookController extends Controller {
    private final DefaultBookService bookService = new DefaultBookService();


    /**
     * Testmethode
     *
     * @return Default Buch
     */
    public Result dummy() {
        final JsonNode json = Json.toJson(bookService.getDummy());
        return ok(json);
    }

    /**
     * Alle Bücher abfragen
     *
     * @param q Suchparameter
     * @return Buch Liste als JSON
     */
    public Result getAll(String q) {
        final JsonNode json = Json.toJson(bookService.get(q));
        return ok(json);
    }

    /**
     * Neues Buchdetail erfassen
     *
     * @param request
     * @return neues Buch als JSON
     */
    public Result add(Http.Request request) {
        final JsonNode json = request.body().asJson();
        final Book newBook = Json.fromJson(json, Book.class);
        bookService.add(newBook);
        return ok(Json.toJson(newBook));
    }

    /**
     * Buchdetail für Buch mit ID aktualisieren
     *
     * @param id Buch ID
     * @param request Buch
     * @return updated book als JSON
     */
    public Result update(Long id, Http.Request request) {
        final JsonNode json = request.body().asJson();
        final Book bookToUpdate = Json.fromJson(json, Book.class);
        bookToUpdate.setId(id);
        bookService.update(bookToUpdate);
        return ok(Json.toJson(bookToUpdate));
    }

    /**
     * Abfragen der Buchdetails für ein Buch mit ID
     *
     * @param id Buch ID
     * @return gesuchtes Buch als JSON
     */
    public Result getSpecific(Long id) {
        final JsonNode json = Json.toJson(bookService.get(id));
        return ok(json);
    }

    /**
     * Buch mit entsprechender ID löschen
     *
     * @param id Buch ID
     * @return boolean
     */
    public Result remove(Long id) {
        if (bookService.delete(id)) {
            return ok();
        }
        return badRequest();
    }

}
