package com.fizzbuzz.demo.service;

import com.fizzbuzz.demo.dao.FizzBuzzDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FizzBuzzService {
    private final FizzBuzzDAO fizzBuzzDAO;

    @Autowired
    public FizzBuzzService(@Qualifier("FizzBuzzDAO") FizzBuzzDAO fizzBuzzDAO) {
        this.fizzBuzzDAO = fizzBuzzDAO;
    }

    public List<String> generateSequence(int n) {
        return fizzBuzzDAO.generateSequence(n);
    }
}
