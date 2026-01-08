import java.util.Arrays;

class Student {
  private int rollNo;
  private String name;
  private int[] marks;

  public Student(int rollNo, String name, int[] marks) {
    this.rollNo = rollNo;
    this.name = name;
    this.marks = marks;
  }

  public char calculateGrade() {
    int avg = (marks[0] + marks[1] + marks[2]) / 3;

    if (avg >= 80)
      return 'A';
    else if (avg >= 60)
      return 'B';
    else if (avg >= 40)
      return 'C';
    else
      return 'F';
  }

  @Override
  public String toString() {
    return "Student [rollNo=" + rollNo + ", name=" + name +
        ", marks=" + Arrays.toString(marks) + ", grade=" + calculateGrade() +
        "]";
  }

  public static void main(String[] args) {
    Student s1 = new Student(101, "Prathamesh", new int[] {85, 78, 90});
    Student s2 = new Student(102, "Akshay", new int[] {62, 58, 65});

    System.out.println(s1);
    System.out.println(s2);
  }
}
