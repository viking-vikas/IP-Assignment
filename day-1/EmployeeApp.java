import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeApp {

  private static ArrayList<Employee> employees = new ArrayList<>();
  private static int nextId = 1;
  private static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    boolean running = true;

    while (running) {
      System.out.println("\n===== Employee Management System =====");
      System.out.println("1. View Employees");
      System.out.println("2. Add Employee");
      System.out.println("3. Update Employee");
      System.out.println("4. Delete Employee");
      System.out.println("0. Exit");
      System.out.print("Enter choice: ");

      int choice = readIntSafely();

      switch (choice) {
      case 1:
        viewEmployees();
        break;
      case 2:
        addEmployee();
        break;
      case 3:
        updateEmployee();
        break;
      case 4:
        deleteEmployee();
        break;
      case 0:
        System.out.println("Exiting... Goodbye!");
        running = false;
        break;
      default:
        System.out.println("Invalid choice. Please try again.");
      }
    }

    sc.close();
  }

  private static void viewEmployees() {
    System.out.println("\n--- Employee List ---");
    if (employees.isEmpty()) {
      System.out.println("No employees found.");
      return;
    }

    for (Employee e : employees) {
      System.out.println(e);
    }
  }

  private static void addEmployee() {
    System.out.println("\n--- Add Employee ---");

    System.out.print("Enter name: ");
    String name = sc.nextLine();

    System.out.print("Enter department: ");
    String dept = sc.nextLine();

    System.out.print("Enter salary: ");
    double salary = readDoubleSafely();

    Employee e = new Employee(nextId, name, dept, salary);
    employees.add(e);
    System.out.println("Employee added with ID: " + nextId);
    nextId++;
  }

  private static void updateEmployee() {
    System.out.println("\n--- Update Employee ---");
    System.out.print("Enter employee ID to update: ");
    int id = readIntSafely();

    Employee e = findById(id);
    if (e == null) {
      System.out.println("Employee not found.");
      return;
    }

    System.out.println("Current details: " + e);

    System.out.print("Enter new name (leave blank to keep same): ");
    String name = sc.nextLine();
    if (!name.trim().isEmpty()) {
      e.setName(name);
    }

    System.out.print("Enter new department (leave blank to keep same): ");
    String dept = sc.nextLine();
    if (!dept.trim().isEmpty()) {
      e.setDepartment(dept);
    }

    System.out.print("Enter new salary (or -1 to keep same): ");
    double salary = readDoubleSafely();
    if (salary >= 0) {
      e.setSalary(salary);
    }

    System.out.println("Employee updated.");
  }

  private static void deleteEmployee() {
    System.out.println("\n--- Delete Employee ---");
    System.out.print("Enter employee ID to delete: ");
    int id = readIntSafely();

    Employee e = findById(id);
    if (e == null) {
      System.out.println("Employee not found.");
      return;
    }

    employees.remove(e);
    System.out.println("Employee deleted.");
  }

  private static Employee findById(int id) {
    for (Employee e : employees) {
      if (e.getId() == id) {
        return e;
      }
    }
    return null;
  }

  private static int readIntSafely() {
    while (true) {
      String input = sc.nextLine();
      try {
        return Integer.parseInt(input.trim());
      } catch (NumberFormatException e) {
        System.out.print("Invalid number. Try again: ");
      }
    }
  }

  private static double readDoubleSafely() {
    while (true) {
      String input = sc.nextLine();
      try {
        return Double.parseDouble(input.trim());
      } catch (NumberFormatException e) {
        System.out.print("Invalid number. Try again: ");
      }
    }
  }
}

class Employee {
  private int id;
  private String name;
  private String department;
  private double salary;

  public Employee(int id, String name, String department, double salary) {
    this.id = id;
    this.name = name;
    this.department = department;
    this.salary = salary;
  }

  public int getId() { return id; }

  public String getName() { return name; }

  public String getDepartment() { return department; }

  public double getSalary() { return salary; }

  public void setName(String name) { this.name = name; }

  public void setDepartment(String department) { this.department = department; }

  public void setSalary(double salary) { this.salary = salary; }

  @Override
  public String toString() {
    return "ID: " + id + ", Name: " + name + ", Department: " + department +
        ", Salary: " + salary;
  }
}
