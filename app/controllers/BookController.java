package controllers;

import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;


public class BookController extends Controller {

    /**
     * Alle Bücher abfragen
     *
     * @param q Suchparameter
     * @return
     */
    public Result getAll(String q) {
        return ok();
    }

    /**
     * Neues Buchdetail erfassen
     *
     * @param request
     */
    public Result add(Http.Request request) {
        return ok();
    }

    /**
     * Buchdetail für Buch mit ID aktualisieren
     *
     * @param id Buch ID
     * @param request
     */
    public Result update(Long id, Http.Request request) {
        return ok();
    }

    /**
     * Abfragen der Buchdetails für ein Buch mit ID
     *
     * @param id Buch ID
     */
    public Result getSpecific(Long id) {
        return ok();
    }

    /**
     * Buch mit entsprechender ID löschen
     *
     * @param id Buch ID
     */
    public Result remove(Long id) {
        return ok();
    }

}
