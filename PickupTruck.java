package problemDomain;

public class PickupTruck extends Vehicle{
	
	private String cargoBed;
	private int cargoCapacity;

	public PickupTruck(long carID, String vehicleType, String subtype, int speed, double fuel, int seats, int year,
			String drivetrain, double price, int quantity, String cargoBed, int cargoCapacity) {
		super(carID, vehicleType, subtype, speed, fuel, seats, year, drivetrain, price, quantity);
		this.cargoBed = cargoBed;
		this.cargoCapacity = cargoCapacity;
	}
	
	@Override
	public String toString() {
		return "Car ID: " + carID + "\n" 
	+ "Vehicle Type: " + vehicleType + "\n" 
	+ "Sub Type: " + subtype + "\n" 
	+ "Speed: " + speed + "\n" 
	+ "Fuel: " + fuel + "\n"
	+ "Seats: " + seats + "\n"
	+ "Year: " + year + "\n"
	+ "Drive Train: " + drivetrain + "\n"
	+ "Price: " + price + "\n"
	+ "Quantit: " + quantity + "\n"
	+ "Cargo Bed: " + cargoBed + "\n"
	+ "Cargo Capactity " + cargoCapacity;
	}

}
