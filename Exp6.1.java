import java.util.*;

class Employee {
    String name;
    int age;
    double salary;

    // Constructor
    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    // Display method
    public void display() {
        System.out.println(name + " (Age: " + age + ", Salary: " + salary + ")");
    }
}

public class EmployeeSort {
    public static void main(String[] args) {
        // Creating a list of Employees
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", 30, 50000));
        employees.add(new Employee("Bob", 25, 60000));
        employees.add(new Employee("Charlie", 35, 55000));

        System.out.println("Sorted by Name (Alphabetical Order):");
        employees.stream()
                 .sorted(Comparator.comparing(emp -> emp.name))
                 .forEach(Employee::display);

        System.out.println("\nSorted by Age (Ascending Order):");
        employees.stream()
                 .sorted(Comparator.comparingInt(emp -> emp.age))
                 .forEach(Employee::display);

        System.out.println("\nSorted by Salary (Descending Order):");
        employees.stream()
                 .sorted(Comparator.comparingDouble(emp -> -emp.salary))
                 .forEach(Employee::display);
    }
}
