package ru.inno.ec.models;

import javax.persistence.*;

import lombok.*;
import org.hibernate.annotations.Check;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@EqualsAndHashCode(exclude = {"sessions", "products"})
@ToString(exclude = {"sessions", "products"})
public class Customer {

    public enum State {
        NOT_CONFIRMED, CONFIRMED, DELETED
    }

    public enum Role {
        USER, ADMIN
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    private String password;

    @Column(name = "first_name", columnDefinition = "varchar(50) default 'name'")
    private String firstName;

    @Column(name = "last_name", columnDefinition = "varchar(50) default 'surname'")
    private String lastName;

    @Column(columnDefinition = "integer default 0")
    @Check(constraints = "age>=0 and age<=120")
    private Integer age;

    @ManyToMany
    @JoinTable(joinColumns = {@JoinColumn(name = "customer_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "session_id", referencedColumnName = "id")})
    private Set<Session> sessions;

    @ManyToMany
    @JoinTable(joinColumns = {@JoinColumn(name = "customer_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "product_id", referencedColumnName = "id")})
    private Set<Product> products;

    @Enumerated(value = EnumType.STRING)
    private State state;

    @Enumerated(value = EnumType.STRING)
    private Role role;
}
