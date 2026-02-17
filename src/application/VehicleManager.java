package application;

import java.io.*;
import java.util.*;
import problemDomain.*;


public class VehicleManager {
	
	private ArrayList<Vehicle> vehicles = new ArrayList<>();
	
	// load file
	
	public void loadFile() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("vehicles.txt"));
			String line;
			
			while ((line = br.readLine()) != null) {
				String[] p = line.split(";");
				
				String carID = p[0];
				char typeDigit = carID.charAt(0);
				
				Vehicle v = null;
				
				switch (typeDigit) {
				
					case '1': // Sedan
						v = new Sedan(p[0], p[1], p[2], Integer.parseInt(p[3]), Double.parseDouble(p[4]), Integer.parseInt(p[5]), 
								Integer.parseInt(p[6]), p[7], Double.parseDouble(p[8]), Integer.parseInt(p[9]), p[10]);
						break;
						
					case '2': // Hatchback
						v = new Hatchback(p[0], p[1], p[2], Integer.parseInt(p[3]), Double.parseDouble(p[4]), Integer.parseInt(p[5]), 
								Integer.parseInt(p[6]), p[7], Double.parseDouble(p[8]), Integer.parseInt(p[9]), p[10]);
						break;
						
					case '3': // SUV
						v = new SUV(p[0], p[1], p[2], Integer.parseInt(p[3]), Double.parseDouble(p[4]), Integer.parseInt(p[5]), Integer.parseInt(p[6]),
								p[7], Double.parseDouble(p[8]), Integer.parseInt(p[9]));
						break;
						
					case '4': // Hybrid
					case '5':
						v = new Hybrid(p[0], p[1], p[2], Integer.parseInt(p[3]), Double.parseDouble(p[4]), Integer.parseInt(p[5]), Integer.parseInt(p[6]),
								p[7], Double.parseDouble(p[8]), Integer.parseInt(p[9]), p[10], Integer.parseInt(p[11]));
						break;
						
					case '6': // Pickup Truck
						v = new PickupTruck(p[0], p[1], p[2], Integer.parseInt(p[3]), Double.parseDouble(p[4]), Integer.parseInt(p[5]), Integer.parseInt(p[6]),
								p[7], Double.parseDouble(p[8]), Integer.parseInt(p[9]), p[10], Integer.parseInt(p[11]));
						break;
						
							
				}
				if (v != null) {
					vehicles.add(v);
				}
			}
			br.close();
			System.out.println("File loaded successfully.");
		} catch (Exception e) {
			System.out.println("Error loading file: " + e.getMessage());
		}
	}
	
	// find by ID
	
	public Vehicle findByID(String id) {
		for (Vehicle v : vehicles) {
			if (v.getCarID().equals(id)) {
				return v;
			}
		} 
		return null;
	}
	
	// rent vehicle
	
	public void rentVehicle(String id) {
		Vehicle v = findByID(id);
		
		if(v == null) {
			System.out.println("CarID not found.");
			return;
		}
		
		if (v instanceof Rentable) {
			Rentable r = (Rentable) v;
			
			try {
				r.rentOne();
				System.out.println("Vehicle rented successfully: ");
				System.out.println(v);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} else  {
			System.out.println("This vehicle type cannot be rented.");
		}
	}
	
	// search by type
	
	public void searchByType(String type) {
		boolean found = false;
		
		for (Vehicle v : vehicles) {
			if (v.getVehicleType().equalsIgnoreCase(type)) {
				System.out.println(v);
				found = true;
			}
		}
		if (!found) {
			System.out.println("No vehicles found for type: " + type);
		}
	}
	
	// display random vehicles
	
	public void displayRandom(int n) {
		Collections.shuffle(vehicles);
		
		for (int i = 0; i < n && i < vehicles.size(); i++) {
			System.out.println(vehicles.get(i));
		}
	}
	
	// save back to file
	
	public void saveFile() {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("vehicles.txt"));
			
			for(Vehicle v : vehicles) {
				bw.write(v.toFileString());
				bw.newLine();
			}
			
			bw.close();
			System.out.println("File saved successfully.");
			
		} catch (Exception e) {
			System.out.println("Error saving file: " + e.getMessage());
		}
	}
	
	
	
}
