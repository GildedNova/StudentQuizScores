/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.studentquizgrades;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Austin
 */
public class StudentQuizGrades {

    public static void main(String[] args) {

        UserIOConsoleImpl io = new UserIOConsoleImpl();
        Map<String, ArrayList<Float>> studentData = new HashMap<>();

        boolean running = true;

        while (running) {
            int userChoice = options(io);

            switch (userChoice) {
                case 0:
                    running = false;
                    break;
                case 1:
                    listStudents(io, studentData);
                    break;
                case 2:
                    addStudent(io, studentData);
                    break;
                case 3:
                    removeStudent(io, studentData);
                    break;
                case 4:
                    viewStudentQuizzes(io, studentData);
                    break;
                case 5:
                    viewStudentAverage(io, studentData);
                    break;
                default:
                    io.print("Enter a correct option.");
                    break;
            }

        }

    }

    public static int options(UserIOConsoleImpl io) {
        io.print("Choose one of the options:");
        io.print("1) View a list of students in the system.");
        io.print("2) Add a student to the system");
        io.print("3) Remove a student from the system.");
        io.print("4) View a list of quiz scores for a given student.");
        io.print("5) View the average quiz score for a given student.");
        io.print("0) Exit.");
        return io.readInt("");
    }

    public static void listStudents(UserIOConsoleImpl io, Map<String, ArrayList<Float>> studentData) {
        io.print(studentData.keySet().toString());

    }

    public static void addStudent(UserIOConsoleImpl io, Map<String, ArrayList<Float>> studentData) {

        ArrayList<Float> quizGrades = new ArrayList<>();

        String studentName = io.readString("What is the name of the student?");
        int n = io.readInt("How many quiz grades do you want to enter?");
        for (int i = 0; i < n; i++) {
            quizGrades.add(io.readFloat("What grade did the student get?"));
        }

        studentData.put(studentName, quizGrades);

    }

    public static void removeStudent(UserIOConsoleImpl io, Map<String, ArrayList<Float>> studentData) {

        String studentName = io.readString("What is the name of the student you would like to remove?");
        if (studentData.containsKey(studentName)) {
            studentData.remove(studentName);
        } else {
            io.print("Student does not exist.");
        }

    }

    public static void viewStudentQuizzes(UserIOConsoleImpl io, Map<String, ArrayList<Float>> studentData) {

        String studentName = io.readString("What is the name of the student you would like to view quizzes for?");
        if (studentData.containsKey(studentName)) {
            System.out.println(studentData.values());
        } else {
            io.print("Student does not exist.");
        }

    }

    public static void viewStudentAverage(UserIOConsoleImpl io, Map<String, ArrayList<Float>> studentData) {

        String studentName = io.readString("What is the name of the student you would like to view the average for?");

        if (studentData.containsKey(studentName)) {
            ArrayList<Float> quizzes = studentData.get(studentName);
            float total = 0;
            float average = 0;
            for (int i = 0; i < quizzes.size(); i++) {
                total += quizzes.get(i);
            }

            average = total / quizzes.size();
            io.print("Student quiz average is " + average + ".");

        } else {

            io.print("Student does not exist.");
        }

    }

}
