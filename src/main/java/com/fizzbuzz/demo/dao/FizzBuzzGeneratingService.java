package com.fizzbuzz.demo.dao;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("FizzBuzzDAO")
public class FizzBuzzGeneratingService implements FizzBuzzDAO {
    private static List<String> fb = new ArrayList<>();
    @Override
    public List<String> generateSequence(int n) {
        fb.clear();
        for (int i = 0; i < n; i++) {
            if ((i+1) % 15 == 0) {
                fb.add("FizzBuzz");
            } else if ((i+1) % 5 == 0) {
                fb.add("Buzz");
            } else if ((i+1) % 3 == 0) {
                fb.add("Fizz");
            } else {
                fb.add(String.valueOf(i+1));
            }
        }
        return fb;
    };
}
