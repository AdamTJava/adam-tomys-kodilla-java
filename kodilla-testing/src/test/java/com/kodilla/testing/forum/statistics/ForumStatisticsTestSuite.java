package com.kodilla.testing.forum.statistics;

import com.kodilla.testing.forum.ForumComment;
import com.kodilla.testing.forum.ForumPost;
import com.kodilla.testing.forum.ForumUser;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ForumStatisticsTestSuite {

    static int testCounter = 0;

    @DisplayName("Test Suite for Forum Statistics")

    @BeforeEach
    void beforeEach() {
        testCounter++;
        System.out.println("Preparing test no. #" + testCounter +"\n");
    }

    @AfterEach
    void afterEach() {
        System.out.println("Test no. #" + testCounter + " finished.");
    }

        @Mock
        private Statistics statisticsMock;

        private List<String> generateUsers(int users) {
            List<String> usersList = new ArrayList<>();
            for (int i = 0; i < users; i++) {
                ForumUser user = new ForumUser("User " + i, "Name " + i);
                String name = user.getName();
                usersList.add(name);
            }
            return usersList;
        }

        private int generateComments(int comments) {
            List<ForumComment> postComments = new ArrayList<>();
            for (int k = 0; k < comments; k++) {
                ForumComment comment = new ForumComment(new ForumPost("Name " + k, "Post Body " + k), "Comment" + k, "Name" + k);
                postComments.add(comment);
            }
            return postComments.size();
        }

        private int generatePosts(int posts) {
            List<ForumPost> postList = new ArrayList<>();
            for (int l = 0; l < posts; l++) {
                ForumPost forumPost = new ForumPost("Name" + l, "Post Body" + l);
                postList.add(forumPost);
            }
            return postList.size();

        }

        @Test
        void testIfNoAnyPosts() {
            //Given
            ForumStatistics forumStatistics = new ForumStatistics(statisticsMock);
            List<String> users = generateUsers(50);
            when(statisticsMock.usersNames()).thenReturn(users);
            when(statisticsMock.postsCount()).thenReturn(0);
            when(statisticsMock.commentsCount()).thenReturn(0);

            //When
            forumStatistics.calculateAdvStatistics(statisticsMock);
            forumStatistics.showStatistics();

            //Then
            Assertions.assertEquals(50, forumStatistics.getUserQuantity());
            Assertions.assertEquals(0, forumStatistics.getPostQuantity());
            Assertions.assertEquals(0, forumStatistics.getCommentsQuantity());
            Assertions.assertEquals(0, forumStatistics.getAveragePostPerUser());
            Assertions.assertEquals(0, forumStatistics.getAverageCommentsPerUser());
            Assertions.assertEquals(0, forumStatistics.getAverageCommentsPerPost());
        }

        @Test
        void testIf100Posts() {
            //Given
            ForumStatistics forumStatistics = new ForumStatistics(statisticsMock);
            List<String> users = generateUsers(50);
            when(statisticsMock.usersNames()).thenReturn(users);
            when(statisticsMock.postsCount()).thenReturn(generatePosts(1000));
            when(statisticsMock.commentsCount()).thenReturn(generateComments(25000));

            //When
            forumStatistics.calculateAdvStatistics(statisticsMock);
            forumStatistics.showStatistics();

            //Then
            Assertions.assertEquals(50, forumStatistics.getUserQuantity());
            Assertions.assertEquals(1000, forumStatistics.getPostQuantity());
            Assertions.assertEquals(25000, forumStatistics.getCommentsQuantity());
            Assertions.assertEquals(20, forumStatistics.getAveragePostPerUser());
            Assertions.assertEquals(500, forumStatistics.getAverageCommentsPerUser());
            Assertions.assertEquals(25, forumStatistics.getAverageCommentsPerPost());
        }

        @Test
        void testIfNoComments() {
            //Given
            ForumStatistics forumStatistics = new ForumStatistics(statisticsMock);
            List<String> users = generateUsers(50);
            when(statisticsMock.usersNames()).thenReturn(users);
            when(statisticsMock.postsCount()).thenReturn(generatePosts(1000));
            when(statisticsMock.commentsCount()).thenReturn(0);

            //When
            forumStatistics.calculateAdvStatistics(statisticsMock);
            forumStatistics.showStatistics();

            //Then
            Assertions.assertEquals(50, forumStatistics.getUserQuantity());
            Assertions.assertEquals(1000, forumStatistics.getPostQuantity());
            Assertions.assertEquals(0, forumStatistics.getCommentsQuantity());
            Assertions.assertEquals(20, forumStatistics.getAveragePostPerUser());
            Assertions.assertEquals(0, forumStatistics.getAverageCommentsPerUser());
            Assertions.assertEquals(0, forumStatistics.getAverageCommentsPerPost());
        }

        @Test
        void testIfLessCommentsThanPosts() {
            //Given
            ForumStatistics forumStatistics = new ForumStatistics(statisticsMock);
            List<String> users = generateUsers(50);
            when(statisticsMock.usersNames()).thenReturn(users);
            when(statisticsMock.postsCount()).thenReturn(generatePosts(1000));
            when(statisticsMock.commentsCount()).thenReturn(generateComments(700));

            //When
            forumStatistics.calculateAdvStatistics(statisticsMock);
            forumStatistics.showStatistics();

            //Then
            Assertions.assertEquals(50, forumStatistics.getUserQuantity());
            Assertions.assertEquals(1000, forumStatistics.getPostQuantity());
            Assertions.assertEquals(700, forumStatistics.getCommentsQuantity());
            Assertions.assertEquals(20, forumStatistics.getAveragePostPerUser());
            Assertions.assertEquals(14, forumStatistics.getAverageCommentsPerUser());
            Assertions.assertEquals(0.7, forumStatistics.getAverageCommentsPerPost());
        }

        @Test
        void testIfMoreCommentsThanPosts() {
            //Given
            ForumStatistics forumStatistics = new ForumStatistics(statisticsMock);
            List<String> users = generateUsers(50);
            when(statisticsMock.usersNames()).thenReturn(users);
            when(statisticsMock.postsCount()).thenReturn(generatePosts(500));
            when(statisticsMock.commentsCount()).thenReturn(generateComments(700));

            //When
            forumStatistics.calculateAdvStatistics(statisticsMock);
            forumStatistics.showStatistics();

            //Then
            Assertions.assertEquals(50, forumStatistics.getUserQuantity());
            Assertions.assertEquals(500, forumStatistics.getPostQuantity());
            Assertions.assertEquals(700, forumStatistics.getCommentsQuantity());
            Assertions.assertEquals(10, forumStatistics.getAveragePostPerUser());
            Assertions.assertEquals(14, forumStatistics.getAverageCommentsPerUser());
            Assertions.assertEquals(1.4, forumStatistics.getAverageCommentsPerPost());
        }

        @Test
        void testIfNoAnyUsers() {
            //Given
            ForumStatistics forumStatistics = new ForumStatistics(statisticsMock);
            List<String> users = new ArrayList<>();
            when(statisticsMock.usersNames()).thenReturn(users);
            when(statisticsMock.postsCount()).thenReturn(0);
            when(statisticsMock.commentsCount()).thenReturn(0);

            //When
            forumStatistics.calculateAdvStatistics(statisticsMock);
            forumStatistics.showStatistics();

            //Then
            Assertions.assertEquals(0, forumStatistics.getUserQuantity());
            Assertions.assertEquals(0, forumStatistics.getPostQuantity());
            Assertions.assertEquals(0, forumStatistics.getCommentsQuantity());
            Assertions.assertEquals(0, forumStatistics.getAveragePostPerUser());
            Assertions.assertEquals(0, forumStatistics.getAverageCommentsPerUser());
            Assertions.assertEquals(0, forumStatistics.getAverageCommentsPerPost());
        }

        @Test
        void testIf100Users() {
            //Given
            ForumStatistics forumStatistics = new ForumStatistics(statisticsMock);
            List<String> users = generateUsers(100);
            when(statisticsMock.usersNames()).thenReturn(users);
            when(statisticsMock.postsCount()).thenReturn(generatePosts(500));
            when(statisticsMock.commentsCount()).thenReturn(generateComments(700));

            //When
            forumStatistics.calculateAdvStatistics(statisticsMock);
            forumStatistics.showStatistics();

            //Then
            Assertions.assertEquals(100, forumStatistics.getUserQuantity());
            Assertions.assertEquals(500, forumStatistics.getPostQuantity());
            Assertions.assertEquals(700, forumStatistics.getCommentsQuantity());
            Assertions.assertEquals(5, forumStatistics.getAveragePostPerUser());
            Assertions.assertEquals(7, forumStatistics.getAverageCommentsPerUser());
            Assertions.assertEquals(1.4, forumStatistics.getAverageCommentsPerPost());
        }
}