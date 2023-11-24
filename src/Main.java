import java.util.Scanner;

class Ticket {
    private String passengerName;
    private int seatNumber;

    public Ticket(String passengerName, int seatNumber) {
        this.passengerName = passengerName;
        this.seatNumber = seatNumber;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public int getSeatNumber() {
        return seatNumber;
    }
}

class TravelAgency {
    private Ticket[] seats;
    private int totalSeats;

    public TravelAgency(int totalSeats) {
        this.totalSeats = totalSeats;
        this.seats = new Ticket[totalSeats];
        for (int i = 0; i < totalSeats; i++) {
            seats[i] = null; // Mark all seats as initially available
        }
    }

    public void displayAvailableSeats() {
        System.out.println("Available Seats:");
        for (int i = 0; i < totalSeats; i++) {
            if (seats[i] == null) {
                System.out.print(i + 1 + " ");
            }
        }
        System.out.println();
    }

    public boolean bookTicket(String passengerName, int seatNumber) {
        if (seatNumber < 1 || seatNumber > totalSeats) {
            System.out.println("Invalid seat number.");
            return false;
        }

        if (seats[seatNumber - 1] != null) {
            System.out.println("Seat already booked. Please choose another seat.");
            return false;
        }

        seats[seatNumber - 1] = new Ticket(passengerName, seatNumber);
        System.out.println("Booking successful for seat number " + seatNumber);
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Travel Agency Ticket Booking System");

        System.out.print("Enter the total number of seats: ");
        int totalSeats = scanner.nextInt();
        TravelAgency travelAgency = new TravelAgency(totalSeats);

        while (true) {
            System.out.println("\n1. Display Available Seats");
            System.out.println("2. Book a Ticket");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    travelAgency.displayAvailableSeats();
                    break;
                case 2:
                    System.out.print("Enter passenger name: ");
                    String passengerName = scanner.next();
                    System.out.print("Enter seat number: ");
                    int seatNumber = scanner.nextInt();
                    travelAgency.bookTicket(passengerName, seatNumber);
                    break;
                case 3:
                    System.out.println("Exiting the Ticket Booking System. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
