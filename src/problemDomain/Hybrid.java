package problemDomain;

public class Hybrid extends Vehicle {
	
	private String powerTrain; // E, A, PHEV
	private int electricRange;
	
	public Hybrid (String carId, String vehicleType, String subtype,
            int speed, double fuel, int seats, int year,
            String drivetrain, double price, int quantity,
            String powerTrain, int electricRange) {
		
		super(carId, vehicleType, subtype, speed, fuel, seats, year, drivetrain, price, quantity);
		
		this.powerTrain = powerTrain;
		this.electricRange = electricRange;
	}
	
	public String getPowerTrain() { return powerTrain; } 
	public int getElectricRange() { return electricRange; }

	@Override
	public String toString() {
		String ptDescription = switch (powerTrain.toUpperCase()) { 
			case "E" -> "Series Hybrid"; 
			case "A" -> "Parallel Hybrid"; 
			case "PHEV" -> "Plug-in Hybrid"; 
			default -> "Unknown"; 
		}; 
		
		return "Car ID:\t\t" + carId + 
				"\nVehicle Type:\t" + vehicleType + 
				"\nSub Type:\t" + subtype + 
				"\nSpeed:\t\t" + speed + 
				"\nFuel:\t\t" + fuel + 
				"\nNumber of Seats:\t" + seats + 
				"\nYear:\t\t" + year + 
				"\nDriveTrain:\t\t" + drivetrain + 
				"\nPrice:\t\t" + price + 
				"\nAvailable:\t\t" + quantity + 
				"\nPower Train:\t" + ptDescription + 
				"\nElectric Range:\t" + electricRange;
	}
}
