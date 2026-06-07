import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    double marks;

    Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }
}

public class StudentGradeManagement {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void addStudent() {
        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();
        sc.nextLine();

        students.add(new Student(name, marks));

        System.out.println("Student Added Successfully!");
    }

    public static void displayReport() {

        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        double total = 0;
        double highest = students.get(0).marks;
        double lowest = students.get(0).marks;

        System.out.println("\n===== STUDENT REPORT =====");
        System.out.printf("%-20s %-10s%n", "Student Name", "Marks");

        for (Student s : students) {

            System.out.printf("%-20s %-10.2f%n", s.name, s.marks);

            total += s.marks;

            if (s.marks > highest) {
                highest = s.marks;
            }

            if (s.marks < lowest) {
                lowest = s.marks;
            }
        }

        double average = total / students.size();

        System.out.println("\n============================");
        System.out.printf("Average Marks : %.2f%n", average);
        System.out.printf("Highest Marks : %.2f%n", highest);
        System.out.printf("Lowest Marks  : %.2f%n", lowest);
    }

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== Student Grade Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Report");
            System.out.println("3. Exit");
            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    displayReport();
                    break;

                case 3:
                    System.out.println("Thank You!");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}