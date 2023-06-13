package com.example.sburrestdemo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RestApiDemoController {

    private final CoffeeRepository coffeeRepository;

    public RestApiDemoController(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;

        coffeeRepository.saveAll(List.of(
                new Coffee("아메리카노"),
                new Coffee("카페라떼"),
                new Coffee("바닐라라떼"),
                new Coffee("카푸치노"),
                new Coffee("카라멜마끼야토")));
    }

    @GetMapping("/coffees")
    Iterable<Coffee> getCoffees() {
//        return coffees;
        return coffeeRepository.findAll();
    }

    @GetMapping("/coffees/{id}")
    Optional<Coffee> getCoffeeById(@PathVariable String id) {

        return coffeeRepository.findById(id);
    }

    // 상태코드 사용 권장
    @PostMapping("/coffees")
    Coffee postCoffee(@RequestBody Coffee coffee) {

        return coffeeRepository.save(coffee);
    }

    // 상태코드 사용 필수
    @PutMapping("/coffees/{id}")
    ResponseEntity<Coffee> putCoffee(@PathVariable String id, @RequestBody Coffee coffee) {

        return (!coffeeRepository.existsById(id)) ?
                new ResponseEntity<>(coffeeRepository.save(coffee), HttpStatus.CREATED)
                : new ResponseEntity<>(coffeeRepository.save(coffee), HttpStatus.OK);
    }

    // 상태코드 사용 권장
    @DeleteMapping("/coffees/{id}")
    void deleteCoffee(@PathVariable String id) {
        coffeeRepository.deleteById(id);
    }

} // end
