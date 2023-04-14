package main.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(unique = true)
    private String name;

    private String country;

    private String population;

    @Column(name = "year_of_foundation")
    private int yearOfFoundation;

    private String founder;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "city_id")
    private List<Sight> sights = new ArrayList<>();

    public void setSight(Sight sight) {
        if (!sights.contains(sight)) {
            sights.add(sight);
        }
    }

    public void removeSight(Sight sight) {
        sights.remove(sight);
    }
}
