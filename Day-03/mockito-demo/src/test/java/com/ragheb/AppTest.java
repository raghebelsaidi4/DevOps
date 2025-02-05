package com.ragheb;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Unit test for simple App.
 */
public class AppTest {
    @Test
    public void sumTest() {
        int a = 10;
        int b = 20;

        int expectedOutput = 30;

        App app = Mockito.mock(App.class);
        when(app.sum(a, b)).thenReturn(expectedOutput);

        int actualOutput = app.sum(a, b);
        System.out.println(actualOutput);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void multiplyTest() {
        int a = 10;
        int b = 20;
        int expectedOutput = 300;
        App app = Mockito.mock(App.class);
        when(app.product(a, b)).thenReturn(expectedOutput);
        int actualOutput = app.product(a, b);
        System.out.println(actualOutput);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void listProcessorListTest() {
        // define input
        List<Integer> data = Arrays.asList(10, 20, 30, 40);
        int expectedOutput = 2;

        // get Actual output
        ListProcessor listProcessor = Mockito.mock(ListProcessor.class);
        //mock method
        when(listProcessor.getFilteredListCount(data)).thenReturn(expectedOutput);
        int actualOutput = listProcessor.getFilteredListCount(data);
        assertEquals(expectedOutput, actualOutput);
    }


    @Mock // create mock obj
    StudentDAO studentDAO;

    @InjectMocks // real obj and it inject mock obj
    StudentService service;

    @BeforeEach // before each test method
    public void setUp() {
        MockitoAnnotations.initMocks(this); // this will create student service real obj and pass studentDao mock obj to studentService
    }

    @Test
    public void addStudentTest() throws Exception {
        // define input
        Student student = new Student();
        student.setStudentId(1);
        student.setFirstName("Ragheb");
        student.setLastName("Ali");
        student.setEmail("ragheb@gmail.com");
        student.setAttendancePercentage(0.5);

        // define expectedInput
        int expectedOutput = 1;

        // get Actual output
        //StudentDAO studentDAO = new StudentDAO();

        // instead of creating real studentDAO obj, create mock obj
        StudentDAO studentDAO = Mockito.mock(StudentDAO.class);

        // pass studentDAO mock obj into StudentService constructor
        StudentService service = new StudentService(studentDAO);

        // mock method
        if (student.getAttendancePercentage() > 0.6)
            when(studentDAO.addStudent(student)).thenReturn(expectedOutput);

        int actualRecordAdded = service.addStudent(student);
        assertEquals(expectedOutput, actualRecordAdded); // failed

    }
}
