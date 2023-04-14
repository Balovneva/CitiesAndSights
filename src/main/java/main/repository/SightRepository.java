package main.repository;

import main.model.City;
import main.model.Sight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SightRepository extends JpaRepository<Sight, Integer> {
    Sight findById(int id);

    Sight findByName(String name);
}
