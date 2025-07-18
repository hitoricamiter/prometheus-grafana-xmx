package ru.zaikin.metrics.controller;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.zaikin.metrics.presentation.GreetingPresentationV1;

import java.util.List;

@RestController
@RequestMapping("/api/greetings")
public class GreetingsRestController {

    MeterRegistry registry;

    public GreetingsRestController(MeterRegistry registry) {
        this.registry = registry;
    }

    @GetMapping
    public ResponseEntity<GreetingPresentationV1> getGreeting(
            @RequestParam(name = "name", defaultValue = "user") String name) {

        this.registry.counter("greetings_count", List.of()).increment();
        this.registry.counter("greetings_count_by_name", List.of(Tag.of("name", name))).increment();
        return ResponseEntity.ok(new GreetingPresentationV1("Hello, %s!".formatted(name)));
    }

}
