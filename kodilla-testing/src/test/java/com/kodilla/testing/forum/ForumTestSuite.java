package com.kodilla.testing.forum;

import com.kodilla.testing.user.SimpleUser;
import org.junit.Assert;
import org.junit.Test;

public class ForumTestSuite {
    @Test
    public void testCaseUsername() {
        //Given
        SimpleUser simpleuser = new SimpleUser("Adam");
        //When
        String result = simpleuser.getUsername();
        //Then
        Assert.assertEquals("Adam", result);
    }
}
