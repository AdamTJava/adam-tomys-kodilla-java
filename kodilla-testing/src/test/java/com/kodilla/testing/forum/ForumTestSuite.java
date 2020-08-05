package com.kodilla.testing.forum;

import com.kodilla.testing.user.SimpleUser;
import org.junit.jupiter.api.*;

public class ForumTestSuite {

    @BeforeEach
    public void before() {
        System.out.println("Test Case: begin");
    }

    @AfterEach
    public void after() {
        System.out.println("Test Case: end");
    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Test Suite: begin");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Test Suite: end");
    }

    @DisplayName("When created SimpleUser with name, "+"then getUsername should return correct name")

    @Test
    public void testCaseUsername() {
        //Given
        SimpleUser simpleUser = new SimpleUser("theForumUser","Adam");
        //When
        System.out.println("Testing "+ simpleUser.getUsername());
        String result = simpleUser.getUsername();
        //Then
        Assertions.assertEquals("theForumUser", result);
    }

    @DisplayName("When created SimpleUser with realName, "+"then getRealName should return real user name")

    @Test
    public void testCaseRealName() {
        //Given
        SimpleUser simpleUser = new SimpleUser("theForumUser","Adam");
        //When
        System.out.println("Testing "+ simpleUser.getRealName());
        //Then
        Assertions.assertEquals("Adam", simpleUser.getRealName());
    }
}
