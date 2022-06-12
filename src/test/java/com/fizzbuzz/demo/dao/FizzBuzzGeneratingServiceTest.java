package com.fizzbuzz.demo.dao;

import com.fizzbuzz.demo.service.FizzBuzzService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class FizzBuzzGeneratingServiceTest {
    @Autowired
    private FizzBuzzService fbs;

    @Test
    void correctSizeOfSequence() {
        assertThat(fbs.generateSequence(15).size()).isEqualTo(15);
    }

    @Test
    void startsFromOne() {
        assertThat(fbs.generateSequence(3).get(0)).isEqualTo("1");
    }

    @Test
    void multiplesOfOnlyThreeAreExactlyFizz() {
        List<String> given = fbs.generateSequence(153);

        for (int i = 0; i < given.size(); i++) {
            if ((i+1) % 3 == 0 && (i+1) % 5 != 0) {
                assertThat(given.get(i)).isEqualTo("Fizz");
            } else {
                assertThat(given.get(i)).isNotEqualTo("Fizz");
            }
        }
    }

    @Test
    void multiplesOfOnlyFiveAreExactlyBuzz() {
        List<String> given = fbs.generateSequence(153);

        for (int i = 0; i < given.size(); i++) {
            if ((i+1) % 3 != 0 && (i+1) % 5 == 0) {
                assertThat(given.get(i)).isEqualTo("Buzz");
            } else {
                assertThat(given.get(i)).isNotEqualTo("Buzz");
            }
        }
    }

    @Test
    void multipliesOfThreeAndFiveAreExactlyFizzBuzz() {
        List<String> given = fbs.generateSequence(153);

        for (int i = 0; i < given.size(); i++) {
            if ((i+1) % 3 == 0 && (i+1) % 5 == 0) {
                assertThat(given.get(i)).isEqualTo("FizzBuzz");
            } else {
                assertThat(given.get(i)).isNotEqualTo("FizzBuzz");
            }
        }
    }

    @Test
    void neitherMultipliesOfThreeOrFiveAreJustTheNumber() {
        List<String> given = fbs.generateSequence(153);

        for (int i = 0; i < given.size(); i++) {
            if ((i+1) % 3 != 0 && (i+1) % 5 != 0) {
                assertThat(given.get(i)).isEqualTo(String.valueOf(i+1));
            } else {
                assertThat(given.get(i)).isNotEqualTo(String.valueOf(i+1));
            }
        }
    }

    @Test
    void twoConsequentRequestsWontBeInTheSameList() {
        List<String> firstRequest = fbs.generateSequence(54);
        List<String> secondRequest = fbs.generateSequence(411);

        assertThat(secondRequest.size()).isNotEqualTo(54 + 411);
        assertThat(secondRequest.size()).isEqualTo(411);
    }

    @Test
    void requestWithNegativeLengthReturnsEmptyList() {
        assertThat(fbs.generateSequence(-1).size()).isEqualTo(0);
    }

}
