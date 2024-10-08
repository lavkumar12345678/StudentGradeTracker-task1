package Code_Alpha;



import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {

    // Class to store student data
    static class Student {
        String name;
        int grade;

        // Constructor
        public Student(String name, int grade) {
            this.name = name;
            this.grade = grade;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        // Data entry loop
        while (true) {
            System.out.print("Enter student name (or 'exit' to finish): ");
            String name = input.nextLine();
            if (name.equalsIgnoreCase("exit")) break;

            System.out.print("Enter grade for " + name + ": ");
            int grade = input.nextInt();
            input.nextLine();  // Consume newline after int input

            // Add student to the list
            students.add(new Student(name, grade));
        }

        // Check if any students were entered
        if (students.isEmpty()) {
            System.out.println("No students' grades were entered.");
            return;
        }

        // Calculate average, highest, and lowest grades
        int total = 0;
        int highest = students.get(0).grade;
        int lowest = students.get(0).grade;

        for (Student student : students) {
            total += student.grade;
            if (student.grade > highest) {
                highest = student.grade;
            }
            if (student.grade < lowest) {
                lowest = student.grade;
            }
        }

        double average = total / (double) students.size();

        // Display results
        System.out.println("\nGrade Report:");
        System.out.println("-------------");
        for (Student student : students) {
            System.out.println(student.name + ": " + student.grade);
        }

        System.out.printf("\nAverage grade: %.2f\n", average);
        System.out.println("Highest grade: " + highest);
        System.out.println("Lowest grade: " + lowest);
    }
}

