package problemDomain;

public class SUV extends Vehicle {
	
	public SUV(String carId, String vehicleType, String subtype,
            int speed, double fuel, int seats, int year,
            String drivetrain, double price, int quantity) {
		
		super(carId, vehicleType, subtype, speed, fuel, seats, year, drivetrain, price, quantity);
		
	}

	@Override
	public String toString() {
		
		String driveDescription = switch (drivetrain.toUpperCase()) { 
			case "AWD" -> "All Wheel Drive"; 
			case "4WD" -> "Four Wheel Drive"; 
			case "FWD" -> "Front Wheel Drive"; 
			default -> drivetrain; 
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
				"\nDriveTrain:\t" + driveDescription;
	}
}
