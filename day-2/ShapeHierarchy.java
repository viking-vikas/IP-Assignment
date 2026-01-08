abstract class Shape {
  abstract double area();

  public Shape() {}
}

class Rectangle extends Shape {
  private double length;
  private double width;

  public Rectangle(double length, double width) {
    super();
    this.length = length;
    this.width = width;
  }

  @Override
  double area() {
    return length * width;
  }
}

class Triangle extends Shape {
  private double base;
  private double height;

  public Triangle(double base, double height) {
    super();
    this.base = base;
    this.height = height;
  }

  @Override
  double area() {
    return 0.5 * base * height;
  }
}

class Square extends Shape {
  private double side;

  public Square(double side) {
    super();
    this.side = side;
  }

  @Override
  double area() {
    return side * side;
  }
}

public class ShapeHierarchy {
  public static void main(String[] args) {

    Shape[] shapes = new Shape[3];
    shapes[0] = new Rectangle(10, 5);
    shapes[1] = new Triangle(8, 6);
    shapes[2] = new Square(4);

    for (Shape s : shapes) {
      System.out.printf("Area: %.2f%n", s.area());
    }
  }
}
