/* describe the low level design of online movie ticket booking system with Java code example containing classes like user (abstract class), theatre,  ticket, movie and a client class containing main method 

add managing booking history and multiple users (guest user and registered user) to the code

*/
/* Let's design an online movie ticket booking system with Java code that includes classes for User (as an abstract class), Theatre, Ticket, Movie, and a client class with a main method. This design will also manage booking history and support both guest and registered users:

java
                                                                                                     */

import java.util.ArrayList;
import java.util.List;

// User abstract class
abstract class User {
    protected String username;

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    abstract void bookTicket(Ticket ticket);

    abstract List<Booking> getBookingHistory();
}

// Booking class representing a booking history entry
class Booking {
    private User user;
    private Ticket bookedTicket;

    public Booking(User user, Ticket bookedTicket) {
        this.user = user;
        this.bookedTicket = bookedTicket;
    }

    public User getUser() {
        return user;
    }

    public Ticket getBookedTicket() {
        return bookedTicket;
    }
}

// RegisteredUser class extending User
class RegisteredUser extends User {
    private List<Booking> bookingHistory;

    public RegisteredUser(String username) {
        super(username);
        this.bookingHistory = new ArrayList<>();
    }

    @Override
    void bookTicket(Ticket ticket) {
        bookingHistory.add(new Booking(this, ticket));
    }

    @Override
    List<Booking> getBookingHistory() {
        return bookingHistory;
    }
}

// GuestUser class extending User
class GuestUser extends User {
    private List<Booking> bookingHistory;

    public GuestUser(String username) {
        super(username);
        this.bookingHistory = new ArrayList<>();
    }

    @Override
    void bookTicket(Ticket ticket) {
        bookingHistory.add(new Booking(this, ticket));
    }

    @Override
    List<Booking> getBookingHistory() {
        return bookingHistory;
    }
}

// Movie class representing a movie
class Movie {
    private String title;
    private String genre;
    private int durationMinutes;

    public Movie(String title, String genre, int durationMinutes) {
        this.title = title;
        this.genre = genre;
        this.durationMinutes = durationMinutes;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }
}

// Theatre class representing a movie theatre
class Theatre {
    private String name;
    private List<Movie> movies;
    private List<Ticket> availableTickets;

    public Theatre(String name) {
        this.name = name;
        this.movies = new ArrayList<>();
        this.availableTickets = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
        // For simplicity, assume all movies have the same ticket price
        availableTickets.add(new Ticket(movie, 10.0));
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public List<Ticket> getAvailableTickets() {
        return availableTickets;
    }
}

// Ticket class representing a movie ticket
class Ticket {
    private Movie movie;
    private double price;

    public Ticket(Movie movie, double price) {
        this.movie = movie;
        this.price = price;
    }

    public Movie getMovie() {
        return movie;
    }

    public double getPrice() {
        return price;
    }
}

// Client class with main method to demonstrate the system
public class MovieTicketBookingSystem {
    public static void main(String[] args) {
        // Create movies
        Movie movie1 = new Movie("Inception", "Sci-Fi", 150);
        Movie movie2 = new Movie("The Shawshank Redemption", "Drama", 142);

        // Create a theatre
        Theatre theatre = new Theatre("ABC Cinemas");

        // Add movies to the theatre
        theatre.addMovie(movie1);
        theatre.addMovie(movie2);

        // Display available movies in the theatre
        System.out.println("Available Movies at " + theatre.getName() + ":");
        for (Movie movie : theatre.getMovies()) {
            System.out.println(movie.getTitle() + " - " + movie.getGenre() + " (" + movie.getDurationMinutes() + " mins)");
        }

        // Guest user books a ticket
        GuestUser guestUser = new GuestUser("guest123");
        Ticket selectedTicketGuest = theatre.getAvailableTickets().get(0);
        guestUser.bookTicket(selectedTicketGuest);

        // Registered user books a ticket
        RegisteredUser registeredUser = new RegisteredUser("john_doe");
        Ticket selectedTicketRegistered = theatre.getAvailableTickets().get(1);
        registeredUser.bookTicket(selectedTicketRegistered);

        // Display booking history for registered user
        System.out.println("\nBooking History for " + registeredUser.getUsername() + ":");
        for (Booking booking : registeredUser.getBookingHistory()) {
            System.out.println("Movie: " + booking.getBookedTicket().getMovie().getTitle() +
                    " | Price: $" + booking.getBookedTicket().getPrice());
        }
    }
}


/* In this example:

User is an abstract class representing users (both registered and guest) with a method to book a ticket and retrieve booking history.
Booking is a class representing a booking history entry.
RegisteredUser and GuestUser are subclasses of User, each maintaining its own booking history.
The main method demonstrates the creation of users, booking tickets, and retrieving booking history.
This design introduces a more structured approach to managing users and their booking history while maintaining the simplicity of the ticket booking system. Note that for a real-world scenario, you might consider adding features like payment system, authentication, persistent storage




      */
