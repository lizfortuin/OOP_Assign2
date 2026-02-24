package problemDomain;

public abstract class Vehicle implements Rentable {
	
	protected String carId; 
	protected String vehicleType; 
	protected String subtype; 
	protected int speed; 
	protected double fuel; 
	protected int seats; 
	protected int year; 
	protected String drivetrain; 
	protected double price; 
	protected int quantity;
	
	public Vehicle(String carId, String vehicleType, String subtype,
            int speed, double fuel, int seats, int year,
            String drivetrain, double price, int quantity) {
		
		this.carId = carId;
		this.vehicleType = vehicleType;
		this.subtype = subtype;
		this.speed = speed;
		this.fuel = fuel;
		this.seats = seats;
		this.year = year;
		this.drivetrain = drivetrain;
		this.price = price;
		this.quantity = quantity;
		
		
	}
	
	@Override
	public boolean isAvailable() {
		return quantity > 0;
	}
	
	@Override
	public void rentOne() {
		if (!isAvailable()) {
			throw new IllegalStateException("Vehicle " + carId + " is not available.");
		}
	}
	
	// getters
	
	public String getCarId() { return carId; } 
	public String getVehicleType() { return vehicleType; } 
	public String getSubtype() { return subtype; } 
	public int getSpeed() { return speed; } 
	public double getFuel() { return fuel; } 
	public int getSeats() { return seats; } 
	public int getYear() { return year; } 
	public String getDrivetrain() { return drivetrain; } 
	public double getPrice() { return price; } 
	public int getQuantity() { return quantity; }
	
	@Override
	public abstract String toString();
	
}
