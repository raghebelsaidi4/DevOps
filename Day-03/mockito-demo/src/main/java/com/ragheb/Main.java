package com.ragheb;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        StudentDAO studentDAO = new StudentDAO();
        StudentService studentService = new StudentService(studentDAO);

        Student student = new Student();
        student.setStudentId(1);
        student.setFirstName("Ragheb");
        student.setLastName("Ali");
        student.setEmail("ragheb@gmail.com");
        student.setAttendancePercentage(6);
        //student.setStudentId(40);
        int recordedAdded = studentService.addStudent(student);
        System.out.println("Recorded added: " + recordedAdded);
    }
}
