package ru.inno.ec.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.inno.ec.models.Customer;
import ru.inno.ec.models.Session;

import java.util.List;
import java.util.Optional;

public interface CustomersRepository extends JpaRepository<Customer, Long> {

    List<Customer> findAllByStateNot(Customer.State state);

    List<Customer> findAllBySessionsNotContains(Session session);

    List<Customer> findAllBySessionsContains(Session session);

    Optional<Customer> findByEmail(String email);

}
