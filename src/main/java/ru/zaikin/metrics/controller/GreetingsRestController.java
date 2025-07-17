package ru.zaikin.metrics.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.zaikin.metrics.presentation.GreetingPresentationV1;

@RestController
@RequestMapping("/api/greetings")
public class GreetingsRestController {

    @GetMapping
    public ResponseEntity<GreetingPresentationV1> getGreeting(
            @RequestParam(name = "name", defaultValue = "user") String name) {
        return ResponseEntity.ok(new GreetingPresentationV1("Hello, %s!".formatted(name)));
    }

}
