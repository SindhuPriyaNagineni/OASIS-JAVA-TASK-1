package sindhu1;



import java.util.Scanner;

class User1 {
    private String username;
    private String password;

    public User1(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }
}

class ReservationSystem {
    private boolean[] seats;

    public ReservationSystem(int numSeats) {
        seats = new boolean[numSeats];
    }

    public boolean reserveSeat(int seatNumber) {
        if (seatNumber < 0 || seatNumber >= seats.length || seats[seatNumber]) {
            return false; // Seat already reserved or invalid seat number
        }
        seats[seatNumber] = true;
        return true; // Seat reserved successfully
    }

    public boolean cancelReservation(int seatNumber) {
        if (seatNumber < 0 || seatNumber >= seats.length || !seats[seatNumber]) {
            return false; // Seat not reserved or invalid seat number
        }
        seats[seatNumber] = false;
        return true; // Reservation canceled successfully
    }
}

public class TrainReservationSystem {
    public static void main(String[] args) {
        // Sample usage
        Scanner scanner = new Scanner(System.in);

        // Create a user and a reservation system
        User1 user = new User1("admin", "password");
        ReservationSystem reservationSystem = new ReservationSystem(50);

        // Login
        System.out.println("Enter username:");
        String username = scanner.nextLine();
        System.out.println("Enter password:");
        String password = scanner.nextLine();

        if (!user.login(username, password)) {
            System.out.println("Invalid username or password. Exiting...");
            return;
        }

        System.out.println("Login successful!");

        // Reservation and cancellation
        while (true) {
            System.out.println("1. Reserve a seat");
            System.out.println("2. Cancel reservation");
            System.out.println("3. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter seat number:");
                    int seatNumber = scanner.nextInt();
                    if (reservationSystem.reserveSeat(seatNumber)) {
                        System.out.println("Seat reserved successfully.");
                    } else {
                        System.out.println("Failed to reserve seat.");
                    }
                    break;
                case 2:
                    System.out.println("Enter seat number to cancel reservation:");
                    seatNumber = scanner.nextInt();
                    if (reservationSystem.cancelReservation(seatNumber)) {
                        System.out.println("Reservation canceled successfully.");
                    } else {
                        System.out.println("Failed to cancel reservation.");
                    }
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}