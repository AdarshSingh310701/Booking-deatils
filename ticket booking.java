import java.util.Scanner;

public class UserInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter movie name");
        String movieName = scanner.nextLine();

        System.out.println("Enter no of bookings");
        int noOfBookings = scanner.nextInt();

        System.out.println("Enter the available tickets");
        int availableTickets = scanner.nextInt();

        Ticket.setAvailableTickets(availableTickets);

        for (int i = 0; i < noOfBookings; i++) {
            System.out.println("Enter the ticketid");
            int ticketId = scanner.nextInt();

            System.out.println("Enter the price");
            int price = scanner.nextInt();

            System.out.println("Enter the no of tickets");
            int numberOfTickets = scanner.nextInt();

            System.out.println("Available tickets: " + Ticket.getAvailableTickets());

            int totalAmount = Ticket.calculateTicketCost(numberOfTickets, price);

            if (totalAmount == -1) {
                System.out.println("Tickets are not available");
                break;
            } else {
                System.out.println("Total amount: " + totalAmount);
                System.out.println("Available ticket after booking: " + Ticket.getAvailableTickets());
            }
        }

        if (Ticket.getAvailableTickets() == 0) {
            System.out.println("House full");
        }

        scanner.close();
    }
}

public class Ticket {
    private int ticketId;
    private int price;
    private static int availableTickets;

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public static int getAvailableTickets() {
        return Ticket.availableTickets;
    }

    public static void setAvailableTickets(int availableTickets) {
        Ticket.availableTickets = availableTickets;
    }

    public static int calculateTicketCost(int numberOfTickets, int price) {
        if (Ticket.availableTickets >= numberOfTickets) {
            int totalAmount = numberOfTickets * price;
            Ticket.availableTickets -= numberOfTickets;
            return totalAmount;
        } else {
            return -1;
        }
    }
}
