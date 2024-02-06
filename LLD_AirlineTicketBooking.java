import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

// Class representing an Airport
class Airport {
    private String code;
    private String name;

    public Airport(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}

// Class representing an Aircraft
class Aircraft {
    private String id;
    private String type;

    public Aircraft(String id, String type) {
        this.id = id;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }
}

// Class representing a Flight
class Flight {
    private String id;
    private Airport source;
    private Airport destination;
    private Aircraft aircraft;
    private Date departureTime;
    private Date arrivalTime;
    private List<Seat> seats;

    public Flight(String id, Airport source, Airport destination, Aircraft aircraft, Date departureTime, Date arrivalTime, int numOfSeats) {
        this.id = id;
        this.source = source;
        this.destination = destination;
        this.aircraft = aircraft;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.seats = new ArrayList<>();
        for (int i = 0; i < numOfSeats; i++) {
            seats.add(new Seat(i + 1));
        }
    }

    public List<Seat> getSeats() {
        return seats;
    }

    // Other getters and methods related to Flight class
}

// Class representing a Seat in the aircraft
class Seat {
    private int number;
    private boolean booked;

    public Seat(int number) {
        this.number = number;
        this.booked = false;
    }

    public int getNumber() {
        return number;
    }

    public boolean isBooked() {
        return booked;
    }

    public void book() {
        this.booked = true;
    }
}

// Class representing a Reservation
class Reservation {
    private String id;
    private Flight flight;
    private Seat seat;
    private Account account;

    public Reservation(String id, Flight flight, Seat seat, Account account) {
        this.id = id;
        this.flight = flight;
        this.seat = seat;
        this.account = account;
    }

    // Getters for Reservation attributes
    public String getId()
    {
        return id;
    }
}

// Abstract class representing an Account (Customer & Staff)
abstract class Account {
    protected String username;
    protected String password;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Abstract method to book a flight
    abstract Reservation bookFlight(Flight flight, Seat seat);

    // Other common methods for Account
}

// Class representing a Customer Account
class Customer extends Account {
    public Customer(String username, String password) {
        super(username, password);
    }

    @Override
    Reservation bookFlight(Flight flight, Seat seat) {
        if (!seat.isBooked()) {
            seat.book();
            return new Reservation(UUID.randomUUID().toString(), flight, seat, this);
        }
        return null; // Seat is already booked
    }

    // Other methods specific to Customer
}

// Class representing a Staff Account
class Staff extends Account {
    public Staff(String username, String password) {
        super(username, password);
    }

    @Override
    Reservation bookFlight(Flight flight, Seat seat) {
        // Staff can book any seat without checking availability
        seat.book();
        return new Reservation(UUID.randomUUID().toString(), flight, seat, this);
    }

    // Other methods specific to Staff
}

// Main class to demonstrate the system
class AirlineTicketBookingSystem {
    public static void main(String[] args) {
        // Create airports
        Airport airport1 = new Airport("LAX", "Los Angeles International Airport");
        Airport airport2 = new Airport("JFK", "John F. Kennedy International Airport");

        // Create aircraft
        Aircraft aircraft1 = new Aircraft("A123", "Boeing 737");
        Aircraft aircraft2 = new Aircraft("A456", "Airbus A320");

        // Create flights
        Flight flight1 = new Flight("F101", airport1, airport2, aircraft1, new Date(), new Date(), 150);
        Flight flight2 = new Flight("F102", airport2, airport1, aircraft2, new Date(), new Date(), 200);

        // Create accounts
        Customer customer1 = new Customer("john_doe", "password");
        Staff staff1 = new Staff("admin", "adminpassword");

        // Bookings
        Reservation reservation1 = customer1.bookFlight(flight1, flight1.getSeats().get(0));
        Reservation reservation2 = staff1.bookFlight(flight2, flight2.getSeats().get(0));

        // Display bookings
        System.out.println("Customer Booking: " + reservation1.getId());
        System.out.println("Staff Booking: " + reservation2.getId());
    }
}
