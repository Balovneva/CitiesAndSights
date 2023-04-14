package main.controllers;

import main.model.City;
import main.repository.CityRepository;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CityController {

    @Autowired
    private CityRepository cityRepository;

    @GetMapping("/city")
    public ResponseEntity<JSONObject> showAllCities() {
        JSONObject response = new JSONObject();
        List<City> allCities = cityRepository.findAll();

        if (allCities.isEmpty()) {
            response.put("result", false);
            response.put("error", "Список городов пуст");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } else {
            response.put("result", true);
            response.put("cities", allCities);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @PostMapping("/city")
    public ResponseEntity<JSONObject> addCity(City city) {
        JSONObject response = new JSONObject();

        if (city.getName().isBlank()) {
            response.put("result", false);
            response.put("error", "Не указано название города.");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } else {
            cityRepository.save(city);
            response.put("result", true);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @GetMapping("/city/{id}")
    public ResponseEntity<JSONObject> getCity(@PathVariable int id) {
        City city = cityRepository.findById(id);
        JSONObject response = new JSONObject();

        if (city == null) {
            response.put("result", false);
            response.put("error", "Города с таким ID не существует.");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } else {
            response.put("result", true);
            response.put("city", city);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @DeleteMapping("/city")
    public ResponseEntity<JSONObject> deleteAllCities() {
        JSONObject response = new JSONObject();
        cityRepository.deleteAll();
        response.put("result", true);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @DeleteMapping("/toDo/{id}")
    public ResponseEntity<JSONObject> deleteCity(@PathVariable int id) {
        JSONObject response = new JSONObject();
        if (!cityRepository.existsById(id)) {
            response.put("result", false);
            response.put("error", "Страница не найдена.");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } else {
            cityRepository.deleteById(id);
            response.put("result", true);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @PatchMapping("/city/{id}")
    public ResponseEntity<JSONObject> changeCity(@PathVariable int id, City newCity) {
        JSONObject response = new JSONObject();

        if (!cityRepository.existsById(id)) {
            response.put("result", false);
            response.put("error", "Город с таким ID не найден.");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } else {
            City city = cityRepository.findById(id);

            city.setName(newCity.getName());
            city.setCountry(newCity.getCountry());
            city.setFounder(newCity.getFounder());
            city.setYearOfFoundation(newCity.getYearOfFoundation());
            cityRepository.save(city);
            response.put("result", true);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }
}