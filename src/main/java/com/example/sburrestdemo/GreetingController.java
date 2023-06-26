package com.example.sburrestdemo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
@RequiredArgsConstructor
public class GreetingController {

    private final Greeting greeting;

    @GetMapping("/name")
    String getName() {
        return greeting.getName();
    }

    @GetMapping("/coffee")
    String getCoffee() {
        return greeting.getCoffee();
    }


}
