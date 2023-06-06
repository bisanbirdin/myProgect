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
@EqualsAndHashCode(exclude = "customers")
@ToString(exclude = "customers")
public class Product {

    public enum State {
        CONFIRMED, DELETED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Check(constraints = "price>0")
    private Integer price;

    @ManyToMany(mappedBy = "products", fetch = FetchType.EAGER)
    private Set<Customer> customers;

    @Enumerated(value = EnumType.STRING)
    private State state;
}
