package app;

import problemDomain.*;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.*;

public class DriveMastersApp {
	
	private static final String FILE_NAME = "res/vehicles.txt";
	
	public static void main(String[] args) {
		List<Vehicle> vehicles;
		
		try {
			vehicles = VehicleFileHandler.loadVehicles(FILE_NAME);
		} catch (IOException e) {
			System.err.println("Error loading vehicles: " + e.getMessage());
			return;
		}
		
		Scanner sc = new Scanner(System.in);
		boolean running = true;
		
		while (running) {
			
			System.out.println("Welcome to DriveMasters"); 
			System.out.println("Please choose any option below"); 
			System.out.println("---------------------------------"); 
			System.out.println("1\tPurchase Vehicle"); 
			System.out.println("2\tFind Vehicle by Type"); 
			System.out.println("3\tDisplay Vehicles by Subtype"); 
			System.out.println("4\tProduce Random Vehicles List"); 
			System.out.println("5\tSave & Exit\n"); 
			
			System.out.print("Enter option: ");
			
			String choice = sc.nextLine();
			
			switch (choice) {
			
			case "1":
				purchaseVehicle(sc, vehicles);
				break;
				
			case "2":
				findByType(sc, vehicles);
				break;
				
			case "3":
				displayBySubtype(sc, vehicles);
				break;
				
			case "4":
				randomVehicles(sc, vehicles);
				break;
				
			case "5": 
				System.out.println("Saving Vehicles... Done!\n"); 
				try { 
					VehicleFileHandler.saveVehicles(FILE_NAME, vehicles); 
				} catch (IOException e) { 
					System.err.println("Error saving vehicles: " + e.getMessage()); 
				} 
				System.out.println("Goodbye!"); 
				running = false; 
				break;
					
			default:
				System.out.println("Invalid option.\n");
			}
		}
		
		sc.close();
		
	}
	
	// OPTION 1: PURCHASE VEHICLE
	
	private static void purchaseVehicle(Scanner sc, List<Vehicle> vehicles) {
		System.out.println("Enter CarId:");
		String id = sc.nextLine().trim();
		
		Vehicle found = null;
		
		for (Vehicle v : vehicles) {
			if (v.getCarId().equals(id)) {
				found = v;
				break;
			}
		}
		
		if (found == null) {
			System.out.println("CarID not found.\n");
			return;
		}
		
		if (found.isAvailable()) {
			found.rentOne();
			System.out.println("\nThe Vehicle \"" + found.getVehicleType() + " " + found.getSubtype() + "\" has been checked out.\n");
		} else  {
			System.out.println("Vehicle is not available\n");
		}
	}
	
	// OPTION 2: FIND VEHICLE BY TYPE
	
	private static void findByType(Scanner sc, List<Vehicle> vehicles) {
		
		System.out.println("Enter vehicle type to search for: (Sedan, SUV, Hatchback, Pickup Truck and Hybrid car) ");
		String type = sc.nextLine().trim();
		
		System.out.println("Matching vehicles: ");
		
		boolean foundAny = false;
		
		for (Vehicle v : vehicles) {
			
			if (v.getVehicleType().equalsIgnoreCase(type)) {
				System.out.println(v + "\n");
				foundAny = true;
			}
		}
		
		if (!foundAny) {
			System.out.println("No matching vehicles.\n");
		}
		
	}
	
	// OPTION 3: DISPLAY VEHICLES BY SUBTYPE
	
	private static void displayBySubtype(Scanner sc, List<Vehicle> vehicles) {
		
		System.out.println("#\tSub Type"); 
		System.out.println("1\tSedan"); 
		System.out.println("2\tHatchBack"); 
		System.out.println("3\tSUV"); 
		System.out.println("4\tHybrid"); 
		System.out.println("5\tPickup Truck\n");
		
		System.out.println("Enter type of vehicle: ");
		String typeChoice = sc.nextLine().trim();
		
		switch (typeChoice) {
		
		case "1": // Sedan
			System.out.println("Enter a format (L for Large/Spacious trunk, S for Small Trunk, or M for Moderate Trunk): ");
			char trunk = sc.nextLine().trim().toUpperCase().charAt(0);
			
			System.out.println("\nMatching Vehicles");
			for (Vehicle v :vehicles) {
				if (v instanceof Sedan s && s.getTrunkSize() == trunk) {
					System.out.println(v + "\n");
				}
			}
			break;
			
		case "2": // Hatchback
			System.out.println("Enter HatchType (S for Standard Liftgate, T for Split Liftgate, P for Power Liftgate): ");
			char lg = sc.nextLine().trim().toUpperCase().charAt(0);
			
			System.out.println("\nMatching Vehicles");
			for (Vehicle v :vehicles) {
				if (v instanceof Hatchback h && h.getHatchType() == lg) {
					System.out.println(v + "\n");
				}
			}
			break;
			
		case "3": // SUV
			System.out.print("Enter Drivetrain (AWD for All Wheel Drive, 4WD for Four Wheel Drive): ");
			String drive = sc.nextLine().trim().toUpperCase();
			
			System.out.println("\nMatching Vehicles: ");
			for (Vehicle v : vehicles) {
				if (v.getVehicleType().equalsIgnoreCase("SUV") && v.getDrivetrain().equalsIgnoreCase(drive)) {
					System.out.println(v + "\n");
				}
			}
			
			break;
			
		case "4": // Hybrid
			System.out.print("Enter a PowerTrain (E for Series Hybrid , A for Parallel Hybrid, PHEV for Plug-in Hybrid): "); 
			String pt = sc.nextLine().trim().toUpperCase();
			
			System.out.println("\nMatching Vehicles:");
			for (Vehicle v : vehicles) {
				if (v.getVehicleType().equalsIgnoreCase("Hybrid")) {
					try {
						var method = v.getClass().getMethod("getPowerTrain");
						String value = (String) method.invoke(v);
						if (value.equalsIgnoreCase(pt)) {
							System.out.println(v + "\n");
						}
					} catch (Exception ignored) {}
				}
			}
			
			break;
			
		case "5": //Pickup Truck
			System.out.print("Enter CargoBeds (SB for Short Beds , EB for Extended Beds, DB for Dump Beds): "); 
			String bed = sc.nextLine().trim().toUpperCase();
			
			System.out.println("\nMatching Vehicles:");
			for (Vehicle v : vehicles) {
				if (v.getVehicleType().equalsIgnoreCase("Pickup Truck")) {
					try {
						var method = v.getClass().getMethod("getCargoBed");
						String value = (String) method.invoke(v);
						if (value.equalsIgnoreCase(bed)) {
							System.out.println(v + "\n");
						}
					} catch (Exception ignored) {}
				}
			}
			break;
			
			
		default:
			System.out.println("Invalid subtype.\n");
		
		}
		
	}
	
	// OPTION 4: RANDOM VEHICLES
	
	private static void randomVehicles(Scanner sc, List<Vehicle> vehicles) {
		
		System.out.println("Enter number of vehicles to display: ");
		int n;
		
		try {
			
			n = Integer.parseInt(sc.nextLine().trim());
			
		} catch (Exception e) {
			
			System.out.println("Invalid number\n");
			return;
			
		}
		
		System.out.println("\nRandom Vehicles:");
		
		Random rand = new Random();
		
		for (int i = 0; i < n; i++) {
			
			Vehicle v = vehicles.get(rand.nextInt(vehicles.size()));
			System.out.println(v + "\n----------------------------------\n");
		}
	}
	
}
