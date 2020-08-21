package com.kodilla.exception.secondchallenge;

import com.kodilla.exception.test.SecondChallenge;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SecondChallengeTestSuite {

    @Test
    void testIWillProbablyThrowException() {
        //Given
        SecondChallenge secondChallenge = new SecondChallenge();
        //When & Then
        Assertions.assertAll(
                () -> assertDoesNotThrow(() -> secondChallenge.probablyIWillThrowException(1, 2)),
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(1, 1.5)),
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(0.9, 2)),
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(2, 2))
        );
    }
}
