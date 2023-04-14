package main.controllers;

import main.model.City;
import main.model.Sight;
import main.repository.CityRepository;
import main.repository.SightRepository;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SightController {
    @Autowired
    private SightRepository sightRepository;
    @Autowired
    private CityRepository cityRepository;

    @GetMapping("/sight")
    public ResponseEntity<JSONObject> showAllSights() {
        JSONObject response = new JSONObject();
        List<Sight> allSights = sightRepository.findAll();

        if (allSights.isEmpty()) {
            response.put("result", false);
            response.put("error", "Список достопримечательностей пуст");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } else {
            response.put("result", true);
            response.put("sights", allSights);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @PostMapping("/sight")
    public ResponseEntity<JSONObject> addSight(Sight sight, String cityName) {

        City city = cityRepository.findByName(cityName);
        JSONObject response = new JSONObject();

        if (sight.getName().isBlank() || city == null) {
            response.put("result", false);
            response.put("error", "Необходимо проверить корректность введенных данных.");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } else {
            city.setSight(sight);
            sight.setCity(cityName);
            sightRepository.save(sight);

            response.put("result", true);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @GetMapping("/sight/{id}")
    public ResponseEntity<JSONObject> getSight(@PathVariable int id) {
        Sight sight = sightRepository.findById(id);
        JSONObject response = new JSONObject();

        if (sight == null) {
            response.put("result", false);
            response.put("error", "Достопримечательности с таким ID не существует.");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } else {
            response.put("result", true);
            response.put("sight", sight);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @DeleteMapping("/sight")
    public ResponseEntity<JSONObject> deleteAllSight() {
        JSONObject response = new JSONObject();
        sightRepository.deleteAll();
        response.put("result", true);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @DeleteMapping("/sight/{id}")
    public ResponseEntity<JSONObject> deleteSight(@PathVariable int id) {
        JSONObject response = new JSONObject();
        if (!sightRepository.existsById(id)) {
            response.put("result", false);
            response.put("error", "Страница не найдена.");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } else {
            sightRepository.deleteById(id);
            response.put("result", true);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @PatchMapping("/sight/{id}")
    public ResponseEntity<JSONObject> changeSight(@PathVariable int id, Sight newSight) {
        JSONObject response = new JSONObject();

        if (!sightRepository.existsById(id)) {
            response.put("result", false);
            response.put("error", "Достопримечательность с таким ID не найдена.");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } else {
            Sight sight = sightRepository.findById(id);

            sight.setName(newSight.getName());
            sight.setCountry(newSight.getCountry());
            sight.setFounder(newSight.getFounder());
            sight.setYearOfFoundation(newSight.getYearOfFoundation());
            sightRepository.save(sight);

            response.put("result", true);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }
}
