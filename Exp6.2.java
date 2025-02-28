import java.util.*;
import java.util.stream.Collectors;

class Student {
    String name;
    double marks;

    // Constructor
    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    // Display method
    public void display() {
        System.out.println(name + " (Marks: " + marks + ")");
    }
}

public class StudentFilterSort {
    public static void main(String[] args) {
        // Creating a list of students
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 80));
        students.add(new Student("Bob", 72));
        students.add(new Student("Charlie", 90));
        students.add(new Student("David", 65));
        students.add(new Student("Eve", 85));

        System.out.println("Students who scored above 75%, sorted by marks:");
        
        // Filtering students with marks > 75%, sorting in descending order, and collecting results
        List<Student> filteredStudents = students.stream()
            .filter(student -> student.marks > 75)  // Filter students above 75%
            .sorted(Comparator.comparingDouble((Student student) -> -student.marks)
                .thenComparing(student -> student.name))  // Sort by marks (descending) & name (ascending)
            .collect(Collectors.toList());

        // Displaying the sorted students
        if (filteredStudents.isEmpty()) {
            System.out.println("No students scored above 75%.");
        } else {
            filteredStudents.forEach(Student::display);
        }
    }
}
