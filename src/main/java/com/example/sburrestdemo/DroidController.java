package com.example.sburrestdemo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
