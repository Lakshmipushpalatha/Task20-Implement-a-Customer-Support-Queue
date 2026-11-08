import java.util.*;

class Ticket {
    int ticketId;
    String customerName;
    String issue;
    String status;

    Ticket(int ticketId, String customerName, String issue) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.issue = issue;
        this.status = "Waiting";
    }

    void display() {
        System.out.println("Ticket ID: " + ticketId);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Issue: " + issue);
        System.out.println("Status: " + status);
        System.out.println("---------------------------");
    }
}

public class Task20{

    static Queue<Ticket> ticketQueue = new ArrayDeque<>();
    static Map<Integer, Ticket> allTickets = new LinkedHashMap<>();

    static int nextTicketId = 1;

    static void createTicket(Scanner sc) {

        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Issue: ");
        String issue = sc.nextLine();

        Ticket ticket = new Ticket(nextTicketId, name, issue);

        ticketQueue.offer(ticket);
        allTickets.put(nextTicketId, ticket);

        System.out.println("Ticket created successfully!");
        System.out.println("Your Ticket ID is: " + nextTicketId);

        nextTicketId++;
    }

    static void displayQueue() {

        if (ticketQueue.isEmpty()) {
            System.out.println("No tickets in the waiting queue.");
            return;
        }

        System.out.println("\n--- Waiting Tickets ---");

        for (Ticket ticket : ticketQueue) {
            ticket.display();
        }
    }

    static void processNextTicket() {

        if (ticketQueue.isEmpty()) {
            System.out.println("No tickets available to process.");
            return;
        }
        Ticket ticket = ticketQueue.poll();

        ticket.status = "In Progress";

        System.out.println("\nProcessing Next Ticket:");
        ticket.display();
    }

    static void resolveTicket(Scanner sc) {

        System.out.print("Enter Ticket ID to resolve: ");
        int id = Integer.parseInt(sc.nextLine());

        Ticket ticket = allTickets.get(id);

        if (ticket == null) {
            System.out.println("Ticket not found.");
        } 
        else if (ticket.status.equals("Resolved")) {
            System.out.println("Ticket is already resolved.");
        }
        else if (ticket.status.equals("Waiting")) {
            System.out.println("Ticket is still waiting. Process it first.");
        }
        else {
            ticket.status = "Resolved";
            System.out.println("Ticket resolved successfully!");
        }
    }

    static void trackTicket(Scanner sc) {

        System.out.print("Enter Ticket ID: ");
        int id = Integer.parseInt(sc.nextLine());

        Ticket ticket = allTickets.get(id);

        if (ticket != null) {
            ticket.display();
        } else {
            System.out.println("Ticket not found.");
        }
    }

    static void displayAllTickets() {

        if (allTickets.isEmpty()) {
            System.out.println("No tickets created yet.");
            return;
        }

        System.out.println("\n--- All Customer Tickets ---");

        for (Ticket ticket : allTickets.values()) {
            ticket.display();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int choice=0;

        do {
            System.out.println("\n===== CUSTOMER SUPPORT SYSTEM =====");
            System.out.println("1. Create Ticket");
            System.out.println("2. Display Waiting Queue");
            System.out.println("3. Process Next Ticket");
            System.out.println("4. Resolve Ticket");
            System.out.println("5. Track Ticket Status");
            System.out.println("6. Display All Tickets");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                continue;
            }

            switch (choice) {

                case 1:
                    createTicket(sc);
                    break;

                case 2:
                    displayQueue();
                    break;

                case 3:
                    processNextTicket();
                    break;

                case 4:
                    resolveTicket(sc);
                    break;

                case 5:
                    trackTicket(sc);
                    break;

                case 6:
                    displayAllTickets();
                    break;

                case 7:
                    System.out.println("Thank you for using Customer Support System!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 7);

        sc.close();
    }
}
