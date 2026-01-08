class Vehicle {
  protected String brand;
  protected String model;
  protected int year;

  public Vehicle(String brand, String model, int year) {
    this.brand = brand;
    this.model = model;
    this.year = year;
  }

  public void displayInfo() {
    System.out.println("Brand : " + brand);
    System.out.println("Model : " + model);
    System.out.println("Year  : " + year);
  }
}

class Car extends Vehicle {
  private int numDoors;

  public Car(String brand, String model, int year, int numDoors) {
    super(brand, model, year);
    this.numDoors = numDoors;
  }

  @Override
  public void displayInfo() {
    super.displayInfo();
    System.out.println("Doors : " + numDoors);
  }
}

class Bike extends Vehicle {
  private boolean hasCarrier;

  public Bike(String brand, String model, int year, boolean hasCarrier) {
    super(brand, model, year);
    this.hasCarrier = hasCarrier;
  }

  @Override
  public void displayInfo() {
    super.displayInfo();
    System.out.println("Carrier: " + (hasCarrier ? "Yes" : "No"));
  }
}

public class VehicleI {
  public static void main(String[] args) {

    Vehicle[] vehicles = new Vehicle[4];
    vehicles[0] = new Car("Toyota", "Corolla", 2020, 4);
    vehicles[1] = new Car("Honda", "City", 2022, 4);
    vehicles[2] = new Bike("Hero", "Splendor", 2019, true);
    vehicles[3] = new Bike("Yamaha", "R15", 2021, false);

    for (Vehicle v : vehicles) {

      if (v instanceof Car) {
        System.out.println("Vehicle Type: Car");
      } else if (v instanceof Bike) {
        System.out.println("Vehicle Type: Bike");
      }

      v.displayInfo();
    }
  }
}
