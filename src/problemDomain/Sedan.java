package problemDomain;

public class Sedan extends Vehicle {
	
	private char trunkSize; // L, M, S

	public Sedan(String carId, String vehicleType, String subtype, int speed, double fuel, int seats, int year,
			String drivetrain, double price, int quantity, char trunkSize) {
		
		super(carId, vehicleType, subtype, speed, fuel, seats, year, drivetrain, price, quantity);
		
		this.trunkSize = trunkSize;
		
	}
	
	public char getTrunkSize() {
		return trunkSize;
	}

	@Override
	public String toString() {
		String trunkDescription = switch (trunkSize) { 
			case 'L' -> "Large/spacious Trunk"; 
			case 'M' -> "Moderate Trunk"; 
			case 'S' -> "Small Trunk"; 
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
				"\nTrunk Size:\t" + trunkDescription;
	}

}
