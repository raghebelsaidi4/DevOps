package com.ragheb;

import java.sql.SQLException;

public class StudentService {

    private final StudentDAO studentDAO;

    public StudentService(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    public int addStudent(Student student) throws SQLException {
        System.out.println("in addStudent method of StudentService class");
        int recordedAdded = 0;
        if (student.getAttendancePercentage() > 0.6)
            recordedAdded = studentDAO.addStudent(student);
        return recordedAdded;
    }
}
