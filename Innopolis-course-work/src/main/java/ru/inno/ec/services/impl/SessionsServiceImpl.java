package ru.inno.ec.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.inno.ec.models.Customer;
import ru.inno.ec.models.Movie;
import ru.inno.ec.models.Session;
import ru.inno.ec.repositories.CustomersRepository;
import ru.inno.ec.repositories.MoviesRepository;
import ru.inno.ec.repositories.SessionsRepository;
import ru.inno.ec.services.SessionsService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SessionsServiceImpl implements SessionsService {

    private final SessionsRepository sessionsRepository;
    private final MoviesRepository moviesRepository;
    private final CustomersRepository customersRepository;

    @Override
    public void addMovieToSession(Long sessionId, Long movieId) {
        Session session = sessionsRepository.findById(sessionId).orElseThrow();
        Movie movie = moviesRepository.findById(movieId).orElseThrow();

        movie.getSessions().add(session);

        moviesRepository.save(movie);
    }

    @Override
    public void addCustomerToSession(Long sessionId, Long customerId) {
        Session session = sessionsRepository.findById(sessionId).orElseThrow();
        Customer customer = customersRepository.findById(customerId).orElseThrow();

        customer.getSessions().add(session);

        customersRepository.save(customer);
    }

    @Override
    public Session getSession(Long sessionId) {
        return sessionsRepository.findById(sessionId).orElseThrow();
    }

    @Override
    public List<Customer> getNotInSessionCustomers(Long sessionId) {
        Session session = sessionsRepository.findById(sessionId).orElseThrow();
        return customersRepository.findAllBySessionsNotContains(session);
    }

    @Override
    public List<Customer> getInSessionCustomers(Long sessionId) {
        Session session = sessionsRepository.findById(sessionId).orElseThrow();
        return customersRepository.findAllBySessionsContains(session);
    }

    @Override
    public List<Movie> getInSessionMovies(Long sessionId) {
        Session session = sessionsRepository.findById(sessionId).orElseThrow();
        return moviesRepository.findAllBySessionsContains(session);
    }

    @Override
    public List<Movie> getNotInSessionMovies(Long sessionId) {
        Session session = sessionsRepository.findById(sessionId).orElseThrow();
        return moviesRepository.findAllBySessionsNotContains(session);
    }

    @Override
    public List<Session> getAllSessions() {
        return sessionsRepository.findAllByStateNot(Session.State.DELETED);
    }

    @Override
    public void addSession(Session session) {
        Session newSession = Session.builder()
                .hall(session.getHall())
                .price(session.getPrice())
                .startTime(session.getStartTime())
                .state(Session.State.CONFIRMED)
                .build();

        sessionsRepository.save(newSession);
    }

    @Override
    public void deleteSession(Long sessionId) {
        Session sessionForDelete = sessionsRepository.findById(sessionId).orElseThrow();
        sessionForDelete.setState(Session.State.DELETED);

        sessionsRepository.save(sessionForDelete);
    }

    @Override
    public void updateSession(Long sessionId, Session session) {
        Session sessionForUpdate = sessionsRepository.findById(sessionId).orElseThrow();
        sessionForUpdate.setHall(session.getHall());
        sessionForUpdate.setStartTime(session.getStartTime());
        sessionForUpdate.setPrice(session.getPrice());

        sessionsRepository.save(sessionForUpdate);
    }
}
