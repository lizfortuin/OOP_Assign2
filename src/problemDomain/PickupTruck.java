package problemDomain;

public class PickupTruck extends Vehicle {
	
	private String cargoBed;
	private int cargoCapacity;

	public PickupTruck(String carId, String vehicleType, String subtype, int speed, double fuel, int seats, int year,
			String drivetrain, double price, int quantity, String cargoBed, int cargoCapacity) {
		
		super(carId, vehicleType, subtype, speed, fuel, seats, year, drivetrain, price, quantity);

		this.cargoBed = cargoBed;
		this.cargoCapacity = cargoCapacity;
	}
	
	public String getCargoBed() { return cargoBed; } 
	public int getCargoCapacity() { return cargoCapacity; }

	@Override
	public String toString() {
		String bedDescription = switch (cargoBed.toUpperCase()) { 
			case "SB" -> "Short Bed"; 
			case "EB" -> "Extended Bed"; 
			case "DB" -> "Dump Bed"; 
			default -> cargoBed; 
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
				"\nCargo Capacity:\t" + cargoCapacity + 
				"\nCargo Beds:\t" + bedDescription;
	}

}
