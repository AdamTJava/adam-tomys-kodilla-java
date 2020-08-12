package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class Forum {

    List<ForumUser> usersList = new ArrayList<>();

    public Forum() {
        usersList.add(new ForumUser(1, "nick", 'M', LocalDate.of(1991, 4, 30), 55));
        usersList.add(new ForumUser(2, "nick1", 'K', LocalDate.of(1995, 2, 17), 15));
        usersList.add(new ForumUser(3, "nick2", 'K', LocalDate.of(1981, 6, 23), 120));
        usersList.add(new ForumUser(4, "nick3", 'M', LocalDate.of(1985, 8, 2), 45));
        usersList.add(new ForumUser(5, "nick4", 'M', LocalDate.of(1993, 12, 7), 10));
        usersList.add(new ForumUser(6, "nick5", 'K', LocalDate.of(1976, 11, 13), 3));
        usersList.add(new ForumUser(7, "nick6", 'M', LocalDate.of(1986, 3, 26), 62));
        usersList.add(new ForumUser(8, "nick7", 'K', LocalDate.of(1992, 7, 9), 95));
        usersList.add(new ForumUser(9, "nick8", 'M', LocalDate.of(1988, 4, 6), 350));
        usersList.add(new ForumUser(10, "nick9", 'M', LocalDate.of(2002, 3, 6), 262));
    }

    public List<ForumUser> getUserList() {
        return new ArrayList<>(usersList);
    }
}
