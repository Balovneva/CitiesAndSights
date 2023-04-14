package main.controllers;

import org.json.simple.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DefaultController {
    @RequestMapping("/")
    public ResponseEntity<JSONObject> homePage() {
        JSONObject response = new JSONObject();
        response.put("result", true);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
