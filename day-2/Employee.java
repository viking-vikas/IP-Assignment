import java.text.DecimalFormat;

class Employee {
  private int empId;
  private String name;
  private double basicSalary;

  public Employee(int empId, String name, double basicSalary) {
    this.empId = empId;
    this.name = name;
    this.basicSalary = basicSalary;
  }

  public double calculateHRA() { return 0.20 * basicSalary; }

  public double calculateDA() { return 0.10 * basicSalary; }

  public double calculateTax(double grossSalary) { return 0.05 * grossSalary; }

  public double calculateNetSalary() {
    double gross = basicSalary + calculateHRA() + calculateDA();
    double tax = calculateTax(gross);
    return gross - tax;
  }

  public void displayPaySlip() {
    DecimalFormat df = new DecimalFormat("₹0.00");

    double hra = calculateHRA();
    double da = calculateDA();
    double gross = basicSalary + hra + da;
    double tax = calculateTax(gross);
    double net = calculateNetSalary();

    System.out.println("Employee ID   : " + empId);
    System.out.println("Employee Name : " + name);
    System.out.println("Basic Salary  : " + df.format(basicSalary));
    System.out.println("HRA (20%)     : " + df.format(hra));
    System.out.println("DA (10%)      : " + df.format(da));
    System.out.println("Gross Salary  : " + df.format(gross));
    System.out.println("Tax (5%)      : " + df.format(tax));
    System.out.println("Net Salary    : " + df.format(net));
  }

  public static void main(String[] args) {

    Employee[] employees = new Employee[2];
    employees[0] = new Employee(101, "Prathamesh", 30000);
    employees[1] = new Employee(102, "Akshay", 40000);

    for (Employee e : employees) {
      e.displayPaySlip();
    }
  }
}
