package ru.inno.ec.services;

import ru.inno.ec.models.Customer;
import ru.inno.ec.models.Movie;
import ru.inno.ec.models.Session;

import java.util.List;

public interface SessionsService {
    void addMovieToSession(Long sessionId, Long movieId);

    void addCustomerToSession(Long sessionId, Long customerId);

    Session getSession(Long sessionId);

    List<Customer> getNotInSessionCustomers(Long sessionId);

    List<Customer> getInSessionCustomers(Long sessionId);

    List<Movie> getInSessionMovies(Long sessionId);

    List<Movie> getNotInSessionMovies(Long sessionId);

    List<Session> getAllSessions();

    void addSession(Session session);

    void deleteSession(Long sessionId);

    void updateSession(Long sessionId, Session session);

}
