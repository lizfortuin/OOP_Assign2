//Chloe
package problemdomain;

//hatchback class
public class Hatchback extends Vehicle {

//variable for hatch type
private String hatchType;

    public Hatchback(long carID, String vehicleType, String subType,
                 int speed, double fuel, int seats, int year,
                 String drivetrain, int price, int quantity,
                 String hatchType) {
    	
        super(carID, vehicleType, subType, speed, fuel, seats,
              year, drivetrain, price, quantity);

        this.hatchType = hatchType;
    }
    
    
    @Override
    public String toString() {
		return "Car ID: " + carID + "\n" 
	+ "Vehicle Type: " + vehicleType + "\n" 
	+ "Sub Type: " + subType + "\n" 
	+ "Speed: " + speed + "\n" 
	+ "Fuel: " + fuel + "\n"
	+ "Seats: " + seats + "\n"
	+ "Year: " + year + "\n"
	+ "Drive Train: " + drivetrain + "\n"
	+ "Price: " + price + "\n"
	+ "Quantity: " + quantity + "\n"
	+ "Hatch Type: " + hatchType + "\n";
    }

}
