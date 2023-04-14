package main.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Sight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private String city;

    private String country;

    @Column(name = "year_of_foundation")
    private int yearOfFoundation;

    private String founder;
}
