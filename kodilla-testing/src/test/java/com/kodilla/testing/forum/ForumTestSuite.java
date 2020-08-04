package com.kodilla.testing.forum;

import com.kodilla.testing.user.SimpleUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Forum Test Suite")
public class ForumTestSuite {

    @DisplayName("When created SimpleUser with name, "+"then getUsername should return correct name")

    @Test
    public void testCaseUsername() {
        //Given
        SimpleUser simpleUser = new SimpleUser("theForumUser");
        String expectedResult = "theForumUser";
        //When
        String result = simpleUser.getUsername();
        //Then
        Assertions.assertEquals(expectedResult, result);
    }
}
