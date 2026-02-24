package problemDomain;

public class Hatchback extends Vehicle{
	
	private char hatchType; // S, T, P
	
	public Hatchback(String carId, String vehicleType, String subtype, int speed, double fuel, int seats, int year,
			String drivetrain, double price, int quantity, char hatchType) {
		
		super(carId, vehicleType, subtype, speed, fuel, seats, year, drivetrain, price, quantity);
		
		this.hatchType = hatchType;
		
	}
	
	public char getHatchType() {
		return hatchType;
	}

	

	@Override
	public String toString() {
		String hatchDescription = switch (hatchType) { 
			case 'S' -> "Standard Liftgate"; 
			case 'T' -> "Split Liftgate"; 
			case 'P' -> "Power Liftgate"; 
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
				"\nHatch Type:\t" + hatchDescription;
	}
	
	
}
