package ru.inno.ec.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.inno.ec.models.Session;

import java.util.List;

public interface SessionsRepository extends JpaRepository<Session, Long> {
    List<Session> findAllByStateNot(Session.State state);

}
