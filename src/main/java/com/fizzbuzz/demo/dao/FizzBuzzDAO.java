package com.fizzbuzz.demo.dao;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.ArrayList;
import java.util.List;

public interface FizzBuzzDAO {

    List<String> generateSequence(int n);

}
