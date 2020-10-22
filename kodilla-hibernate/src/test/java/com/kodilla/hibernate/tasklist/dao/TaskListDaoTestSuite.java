package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class TaskListDaoTestSuite {

    @Autowired
    private TaskListDao taskListDao;

    @Test
    void testFindByListName() {
        //Given
        TaskList taskList = new TaskList("Tasklist ToDo", "List contains tasks to process");
        //When
        taskListDao.save(taskList);
        //Then
        int id = taskList.getId();
        List<TaskList> readTaskList = taskListDao.findByListName("Tasklist ToDo");
        Assertions.assertEquals(readTaskList.get(0).getListName(), "Tasklist ToDo");
        //Clean up
        taskListDao.deleteById(id);
    }

}
