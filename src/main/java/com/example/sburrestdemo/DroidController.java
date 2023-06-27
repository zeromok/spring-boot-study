package com.example.sburrestdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/droid")
@RequiredArgsConstructor
public class DroidController {

    private final Droid droid;

    @GetMapping("/id")
    String getName() {
        return droid.getId();
    }

    @GetMapping("/description")
    String getCoffee() {
        return droid.getDescription();
    }


}
