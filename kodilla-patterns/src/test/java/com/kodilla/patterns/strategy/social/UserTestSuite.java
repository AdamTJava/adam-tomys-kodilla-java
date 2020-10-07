package com.kodilla.patterns.strategy.social;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTestSuite {

    @Test
    void testDefaultSharingStrategies() {
        //Given
        Millenials user1 = new Millenials("Maciek");
        YGeneration user2 = new YGeneration("Rafał");
        ZGeneration user3 = new ZGeneration("Wojtek");

        //When
        String actual1 = user1.sharePost();
        System.out.println(user1.getName() + " is " + user1.sharePost());
        String actual2 = user2.sharePost();
        System.out.println(user2.getName() + " is " + user2.sharePost());
        String actual3 = user3.sharePost();
        System.out.println(user3.getName() + " is " +  user3.sharePost());

        //Then
        Assertions.assertEquals("adding post on Facebook", actual1);
        Assertions.assertEquals("adding post on Twitter", actual2);
        Assertions.assertEquals("adding post on Snapchat", actual3);
    }

    @Test
    void testIndividualSharingStrategies() {
        //Given
        Millenials user1 = new Millenials("Paweł");

        //When
        String actual1 = user1.getName() + " is " + user1.sharePost();
        System.out.println(actual1);
        user1.setSocialPublisher(new SnapchatPublisher());
        String actual2 = user1.getName() + " is " + user1.sharePost();
        System.out.println(actual2);

        //Then
        Assertions.assertEquals("Paweł is adding post on Facebook", actual1);
        Assertions.assertEquals("Paweł is adding post on Snapchat", actual2);;
    }

}
