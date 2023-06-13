package com.example.sburrestdemo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class RestApiDemoController {

    private List<Coffee> coffees = new ArrayList<>();

    public RestApiDemoController() {
        coffees.addAll(List.of(
                new Coffee("아메리카노"),
                new Coffee("카페라떼"),
                new Coffee("바닐라라떼"),
                new Coffee("카푸치노"),
                new Coffee("카라멜마끼야토")
        ));
    }

    @GetMapping("/coffees")
    Iterable<Coffee> getCoffees() {
        return coffees;
    }

    @GetMapping("/coffees/{id}")
    Optional<Coffee> getCoffeeById(@PathVariable String id) {

        for (Coffee menu : coffees) {
            if (menu.getId().equals(id)) {
                return Optional.of(menu);
            }
        }
        return Optional.empty();
    }

    // 상태코드 사용 권장
    @PostMapping("/coffees")
    Coffee postCoffee(@RequestBody Coffee coffee) {

        coffees.add(coffee);
        return coffee;
    }

    // 상태코드 사용 필수
    @PutMapping("/coffees/{id}")
    ResponseEntity<Coffee> putCoffee(@PathVariable String id, @RequestBody Coffee coffee) {
        int coffeeIndex = -1;

        for (Coffee menu : coffees) {
            if (menu.getId().equals(id)) {
                coffeeIndex = coffees.indexOf(menu);
                coffees.set(coffeeIndex, coffee);
            }
        }

//        return coffeeIndex == -1 ? postCoffee(coffee) : coffee;
        return coffeeIndex == -1 ?
                new ResponseEntity<>(postCoffee(coffee), HttpStatus.CREATED) :
                new ResponseEntity<>(coffee, HttpStatus.OK);
    }

    // 상태코드 사용 권장
    @DeleteMapping("/coffees/{id}")
    void deleteCoffee(@PathVariable String id) {
        coffees.removeIf(menu -> menu.getId().equals(id));
    }

} // end
