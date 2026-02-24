package problemdomain;

//Vehicle class, abstract
public abstract class Vehicle {
  //attributes
	protected long carID;
	protected String vehicleType;
	protected String subType;
	protected int speed;
	protected double fuel;
	protected int seats;
	protected int year;
	protected String drivetrain;
	protected int price;
	protected int quantity;
	protected boolean available;

  
    //constructor
    public Vehicle(long carID, String vehicleType, String subType, int speed,
                   double fuel, int seats, int year, String drivetrain, int price, int quantity) {
        this.carID = carID;
        this.vehicleType = vehicleType;
        this.subType = subType;
        this.speed = speed;
        this.fuel = fuel;
        this.seats = seats;
        this.year = year;
        this.drivetrain = drivetrain;
        this.price = price;
        this.quantity = quantity;
        this.available = true;
    }
    


}
