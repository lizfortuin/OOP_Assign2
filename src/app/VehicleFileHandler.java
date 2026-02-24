package app;

import java.io.*;
import java.util.*;
import problemDomain.*;

public class VehicleFileHandler {
	
	public static List<Vehicle> loadVehicles(String fileName) throws IOException {
		
		List<Vehicle> vehicles = new ArrayList<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			
			
			String line;
			
			while ((line = br.readLine()) != null) {
				if (line.trim().isEmpty()) continue;
				
				String[] parts = line.split(";");
				String carId = parts[0];
				char firstDigit = carId.charAt(0);
				
				String vehicleType = parts[1]; 
				String subtype = parts[2]; 
				int speed = Integer.parseInt(parts[3]); 
				double fuel = Double.parseDouble(parts[4]); 
				int seats = Integer.parseInt(parts[5]); 
				int year = Integer.parseInt(parts[6]); 
				String drivetrain = parts[7]; 
				double price = Double.parseDouble(parts[8]); 
				int quantity = Integer.parseInt(parts[9]);
				
				Vehicle v = null;
				
				switch (firstDigit) {
				
				case '1': // Sedan
					char trunkSize = parts[10].charAt(0);
					v = new Sedan(carId, vehicleType, subtype, speed, fuel, seats, year, drivetrain, price, quantity, trunkSize);
					break;
					
				case '2': // Hatchback
					char hatchType =parts[10].charAt(0);
					v = new Hatchback(carId, vehicleType, subtype, speed, fuel, seats, year, drivetrain, price, quantity, hatchType);
					break;
					
				case '3': // SUV
					v = new SUV(carId, vehicleType, subtype, speed, fuel, seats, year, drivetrain, price, quantity);
					break;
					
				case '4': //Hybrid
				case '5': 
					String powerTrain = parts[10];
					int electricRange = Integer.parseInt(parts[11]);
					v = new Hybrid(carId, vehicleType, subtype, speed, fuel, seats, year, drivetrain, price, quantity, powerTrain, electricRange);
					break;
					
				case '6': // pickup Truck
					String cargoBed = parts[10];
					int cargoCapacity = Integer.parseInt(parts[11]);
					v = new PickupTruck(carId, vehicleType, subtype, speed, fuel, seats, year, drivetrain, price, quantity, cargoBed, cargoCapacity);
					break;
				
					default:
						System.err.println("Unknown vehicle type for line: " + line);
					
				}
				
				if (v != null) vehicles.add(v);
			}
			
		}
		return vehicles;
	}
	
	public static void saveVehicles(String fileName, List<Vehicle> vehicles) throws IOException { 
		try (PrintWriter pw = new PrintWriter(new FileWriter(fileName))) { 
			for (Vehicle v : vehicles) { 
				pw.println(toFileFormat(v)); 
				} 
			} 
		}

	private static String toFileFormat(Vehicle v) {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(v.getCarId()).append(";"); 
		sb.append(v.getVehicleType()).append(";"); 
		sb.append(v.getSubtype()).append(";"); 
		sb.append(v.getSpeed()).append(";"); 
		sb.append(v.getFuel()).append(";"); 
		sb.append(v.getSeats()).append(";"); 
		sb.append(v.getYear()).append(";"); 
		sb.append(v.getDrivetrain()).append(";"); 
		sb.append(v.getPrice()).append(";"); 
		sb.append(v.getQuantity()).append(";");
		
		if (v instanceof Sedan s) { 
			sb.append(s.getTrunkSize()); 
			} else if (v instanceof Hatchback h) { 
				sb.append(h.getHatchType()); 
			} else if (v instanceof Hybrid h) { 
				sb.append(h.getPowerTrain()).append(";") .append(h.getElectricRange()); 
			} else if (v instanceof PickupTruck p) { 
				sb.append(p.getCargoBed()).append(";") .append(p.getCargoCapacity()); 
			}
		return sb.toString();
		
	}
		
}


