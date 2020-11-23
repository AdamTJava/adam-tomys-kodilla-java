package com.kodilla.jdbc;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DbManagerTestSuite {

    @Test
    void testConnect() throws SQLException {
        //Given
        DbManager.INSTANCE.createDataBase();
        //When
        //Then
        assertNotNull(DbManager.INSTANCE.getConnection());
    }

//    @Test
//    void testSelectUsers() throws SQLException {
//        //Given
//        DbManager.INSTANCE.createDataBase();
//        Connection database = DbManager.INSTANCE.getConnection();
//
//        //When
//        String sqlQuery = "SELECT * FROM USERS";
//        Statement statement = database.createStatement();
//        ResultSet rs = statement.executeQuery(sqlQuery);
//
//        //Then
//        int counter = 0;
//        while (rs.next()) {
//            System.out.println(rs.getInt("ID") + ", " +
//                    rs.getString("FIRSTNAME") + ", " +
//                    rs.getString("LASTNAME"));
//            counter++;
//        }
//        rs.close();
//        statement.close();
//        assertEquals(5, counter);
//    }
//
//    @Test
//    void testSelectUsersAndPosts() throws SQLException {
//        //Given
//        DbManager.INSTANCE.createDataBase();
//        Connection database = DbManager.INSTANCE.getConnection();
//
//        //When
//        String sqlQuery = "select U.FIRSTNAME, U.LASTNAME, count(*) as POST_NUMBER" +
//                "\nfrom users U join posts P on U.ID = P.USER_ID" +
//                "\ngroup by USER_ID" +
//                "\nhaving count(*) >= 2";
//        Statement statement = database.createStatement();
//        ResultSet rs = statement.executeQuery(sqlQuery);
//
//        //Then
//        int counter = 0;
//        while (rs.next()) {
//            System.out.println(rs.getString("FIRSTNAME") + " " +
//                    rs.getString("LASTNAME") + ", " +
//                    rs.getInt("POST_NUMBER"));
//            counter++;
//        }
//        rs.close();
//        statement.close();
//        assertEquals(2, counter);
//
//    }

}
