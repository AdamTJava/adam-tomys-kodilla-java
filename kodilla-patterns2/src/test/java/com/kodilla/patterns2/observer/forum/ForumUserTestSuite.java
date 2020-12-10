package com.kodilla.patterns2.observer.forum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ForumUserTestSuite {

    @Test
    void testUpdate() {
        //Given
        ForumTopic javaHelpForum = new JavaHelpForumTopic();
        ForumTopic javaToolsForum = new JavaToolsForumTopic();
        ForumUser johnSmith = new ForumUser("John Smith");
        ForumUser ivoneEscobar = new ForumUser("Ivone Escobar");
        ForumUser jessiePinkman = new ForumUser("Jessie Pinkman");
        javaHelpForum.registerObserver(johnSmith);
        javaToolsForum.registerObserver(ivoneEscobar);
        javaHelpForum.registerObserver(jessiePinkman);
        javaToolsForum.registerObserver(jessiePinkman);

        //When
        javaHelpForum.addPost("Hi everyone!");
        javaHelpForum.addPost("Try to use loop");
        javaToolsForum.addPost("Help pls");
        javaHelpForum.addPost("Why while?");
        javaToolsForum.addPost("nullpointer error");

        //Then
        Assertions.assertEquals(3, johnSmith.getUpdateCount());
        Assertions.assertEquals(2, ivoneEscobar.getUpdateCount());
        Assertions.assertEquals(5, jessiePinkman.getUpdateCount());
    }
}
