package com.fizzbuzz.demo.dao;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("FizzBuzzDAO")
public class FizzBuzzGeneratingService implements FizzBuzzDAO {
    private static List<String> sequence = new ArrayList<>();
    @Override
    public List<String> generateSequence(int n) {

        for (int i = 0; i < n; i++) {
            if ((i+1) % 15 == 0) {
                sequence.add("FizzBuzz");
            } else if ((i+1) % 5 == 0) {
                sequence.add("Buzz");
            } else if ((i+1) % 3 == 0) {
                sequence.add("Fizz");
            } else {
                sequence.add(String.valueOf(i+1));
            }
        }
        return sequence;
    };
}
