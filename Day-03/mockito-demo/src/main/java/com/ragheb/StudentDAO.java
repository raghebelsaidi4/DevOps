package com.ragheb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentDAO {

    private Connection connection = null;

    public StudentDAO() {
        try {
            // load Driver class
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public int addStudent(Student student) throws SQLException {
        PreparedStatement preparedStatement = null;
        int recordAdded = 0;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db", "root", "ragheb01276323608");
            preparedStatement = connection.prepareStatement("insert into student values(?,?,?,?)");
            preparedStatement.setInt(1, student.getStudentId());
            preparedStatement.setString(2, student.getFirstName());
            preparedStatement.setString(3, student.getLastName());
            preparedStatement.setString(4, student.getEmail());
            recordAdded = preparedStatement.executeUpdate();
            System.out.println("Record Added: " + recordAdded);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (preparedStatement != null)
                preparedStatement.close();
            if (connection != null)
                connection.close();
        }
        return recordAdded;
    }
}
