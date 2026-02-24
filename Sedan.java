//Chloe
package problemdomain;

//Sedan class
public class Sedan extends Vehicle {

    //variable for trucksize
    private String trunkSize;

    public Sedan(long carID, String vehicleType, String subType,
                 int speed, double fuel, int seats, int year,
                 String drivetrain, int price, int quantity,
                 String trunkSize) {

        super(carID, vehicleType, subType, speed, fuel, seats,
              year, drivetrain, price, quantity);
        this.trunkSize = trunkSize;
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
	+ "Quantity: " + quantity + "\n";
    }
}
