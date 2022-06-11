package com.fizzbuzz.demo.api;

import com.fizzbuzz.demo.service.FizzBuzzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/fizzbuzz")
@RestController
public class FizzBuzzController {
    private final FizzBuzzService fizzBuzzService;

    @Autowired
    public FizzBuzzController(FizzBuzzService fizzBuzzService) {
        this.fizzBuzzService = fizzBuzzService;
    }

    @GetMapping(path = "{n}")
    public List<String> generateSequence(@PathVariable("n") int n) {
        return fizzBuzzService.generateSequence(n);
    };
}
