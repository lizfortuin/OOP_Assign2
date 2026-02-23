package problemDomain;

public class Hybrid extends Vehicle{

	private String powerTrain;
	private int electricRange;

	public Hybrid(long carID, String vehicleType, String subtype, int speed, double fuel, int seats, int year,
			String drivetrain, double price, int quantity, String powerTrain, int electricRange) {
		super(carID, vehicleType, subtype, speed, fuel, seats, year, drivetrain, price, quantity);
		this.powerTrain = powerTrain;
		this.electricRange = electricRange;
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
	+ "Power train: " + powerTrain + "\n"
	+ "Electric Range " + electricRange;
	}
	
	

}
