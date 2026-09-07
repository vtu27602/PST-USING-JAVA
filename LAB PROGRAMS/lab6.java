import java.util.ArrayList;
import java.util.Scanner;

class Passenger {
    int id;
    String name;

    Passenger(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class Driver {
    int id;
    String name;
    String vehicle;
    boolean available;

    Driver(int id, String name, String vehicle) {
        this.id = id;
        this.name = name;
        this.vehicle = vehicle;
        this.available = true;
    }
}

class Ride {
    int rideId;
    Passenger passenger;
    Driver driver;
    String pickup;
    String destination;
    double distance;
    double fare;
    String status;

    Ride(int rideId, Passenger passenger, String pickup,
         String destination, double distance) {

        this.rideId = rideId;
        this.passenger = passenger;
        this.pickup = pickup;
        this.destination = destination;
        this.distance = distance;
        this.status = "Requested";
    }

    void calculateFare() {
        double baseFare = 50;
        double ratePerKm = 15;

        fare = baseFare + (distance * ratePerKm);
    }
}

public class Main {

    static ArrayList<Passenger> passengers = new ArrayList<>();
    static ArrayList<Driver> drivers = new ArrayList<>();
    static ArrayList<Ride> rides = new ArrayList<>();

    static int passengerId = 1;
    static int driverId = 1;
    static int rideId = 1;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== RIDE SHARING PLATFORM =====");
            System.out.println("1. Register Passenger");
            System.out.println("2. Register Driver");
            System.out.println("3. Request Ride");
            System.out.println("4. Complete Ride");
            System.out.println("5. Display Rides");
            System.out.println("6. Display Drivers");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter passenger name: ");
                    String passengerName = sc.nextLine();

                    Passenger passenger =
                        new Passenger(passengerId++, passengerName);

                    passengers.add(passenger);

                    System.out.println("Passenger registered!");
                    System.out.println("Passenger ID: " + passenger.id);
                    break;

                case 2:
                    System.out.print("Enter driver name: ");
                    String driverName = sc.nextLine();

                    System.out.print("Enter vehicle name: ");
                    String vehicle = sc.nextLine();

                    Driver driver =
                        new Driver(driverId++, driverName, vehicle);

                    drivers.add(driver);

                    System.out.println("Driver registered!");
                    System.out.println("Driver ID: " + driver.id);
                    break;

                case 3:

                    if (passengers.isEmpty()) {
                        System.out.println("No passengers registered.");
                        break;
                    }

                    if (drivers.isEmpty()) {
                        System.out.println("No drivers registered.");
                        break;
                    }

                    System.out.print("Enter passenger ID: ");
                    int pId = sc.nextInt();
                    sc.nextLine();

                    Passenger selectedPassenger = null;

                    for (Passenger p : passengers) {
                        if (p.id == pId) {
                            selectedPassenger = p;
                            break;
                        }
                    }

                    if (selectedPassenger == null) {
                        System.out.println("Passenger not found.");
                        break;
                    }

                    Driver selectedDriver = null;

                    for (Driver d : drivers) {
                        if (d.available) {
                            selectedDriver = d;
                            break;
                        }
                    }

                    if (selectedDriver == null) {
                        System.out.println("No drivers available.");
                        break;
                    }

                    System.out.print("Enter pickup location: ");
                    String pickup = sc.nextLine();

                    System.out.print("Enter destination: ");
                    String destination = sc.nextLine();

                    System.out.print("Enter distance in km: ");
                    double distance = sc.nextDouble();

                    Ride ride = new Ride(
                        rideId++,
                        selectedPassenger,
                        pickup,
                        destination,
                        distance
                    );

                    ride.driver = selectedDriver;
                    ride.calculateFare();

                    ride.status = "Accepted";
                    selectedDriver.available = false;

                    rides.add(ride);

                    System.out.println("\nRide booked successfully!");
                    System.out.println("Ride ID: " + ride.rideId);
                    System.out.println("Driver: " + selectedDriver.name);
                    System.out.println("Vehicle: " + selectedDriver.vehicle);
                    System.out.println("Fare: Rs." + ride.fare);

                    break;

                case 4:

                    System.out.print("Enter Ride ID: ");
                    int rId = sc.nextInt();

                    Ride selectedRide = null;

                    for (Ride r : rides) {
                        if (r.rideId == rId) {
                            selectedRide = r;
                            break;
                        }
                    }

                    if (selectedRide == null) {
                        System.out.println("Ride not found.");
                        break;
                    }

                    selectedRide.status = "Completed";
                    selectedRide.driver.available = true;

                    System.out.println("Ride completed!");
                    System.out.println("Total Fare: Rs."
                                       + selectedRide.fare);

                    break;

                case 5:

                    if (rides.isEmpty()) {
                        System.out.println("No rides available.");
                        break;
                    }

                    System.out.println("\n===== RIDE DETAILS =====");

                    for (Ride r : rides) {

                        System.out.println("Ride ID: " + r.rideId);
                        System.out.println("Passenger: "
                                           + r.passenger.name);
                        System.out.println("Driver: "
                                           + r.driver.name);
                        System.out.println("Pickup: " + r.pickup);
                        System.out.println("Destination: "
                                           + r.destination);
                        System.out.println("Distance: "
                                           + r.distance + " km");
                        System.out.println("Fare: Rs." + r.fare);
                        System.out.println("Status: " + r.status);

                        System.out.println("----------------------");
                    }

                    break;

                case 6:

                    System.out.println("\n===== DRIVER DETAILS =====");

                    for (Driver d : drivers) {

                        System.out.println("Driver ID: " + d.id);
                        System.out.println("Name: " + d.name);
                        System.out.println("Vehicle: " + d.vehicle);

                        if (d.available)
                            System.out.println("Status: Available");
                        else
                            System.out.println("Status: Busy");

                        System.out.println("----------------------");
                    }

                    break;

                case 7:
                    System.out.println("Thank you!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}



OUTPUT :
===== RIDE SHARING PLATFORM =====
1. Register Passenger
2. Register Driver
3. Request Ride
4. Complete Ride
5. Display Rides
6. Display Drivers
7. Exit
Enter your choice: 1
Enter passenger name: sai kumar
Passenger registered!
Passenger ID: 1

===== RIDE SHARING PLATFORM =====
1. Register Passenger
2. Register Driver
3. Request Ride
4. Complete Ride
5. Display Rides
6. Display Drivers
7. Exit
Enter your choice: 2
Enter driver name: arun 
Enter vehicle name: bike
Driver registered!
Driver ID: 1

===== RIDE SHARING PLATFORM =====
1. Register Passenger
2. Register Driver
3. Request Ride
4. Complete Ride
5. Display Rides
6. Display Drivers
7. Exit
Enter your choice: 
