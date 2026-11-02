
package CustomerServiceticketsystem;

public class TicketPriorityQueue {

    // Maximum number of tickets
    private static final int MAX_SIZE = 100;

    // Array that stores the tickets
    private ServiceTicket[] tickets;

    // Current number of tickets
    private int size;

    // Constructor
    public TicketPriorityQueue() {
        tickets = new ServiceTicket[MAX_SIZE];
        size = 0;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Check if the queue is full
    public boolean isFull() {
        return size == MAX_SIZE;
    }

    // Get the number of tickets
    public int getSize() {
        return size;
    }

    // Insert a ticket into the priority queue
    public void insertTicket(ServiceTicket ticket) {

        if (ticket == null) {
            throw new IllegalArgumentException(
                "Ticket cannot be null."
            );
        }

        if (isFull()) {
            throw new IllegalStateException(
                "Ticket queue is full."
            );
        }

        tickets[size] = ticket;
        size++;

        // Arrange tickets by priority
        int current = size - 1;

        while (current > 0 &&
               tickets[current].getPriority() <
               tickets[current - 1].getPriority()) {

            ServiceTicket temp = tickets[current];

            tickets[current] = tickets[current - 1];

            tickets[current - 1] = temp;

            current--;
        }
    }

    // View the highest-priority ticket
    public ServiceTicket peekHighestPriority() {

        if (isEmpty()) {
            return null;
        }

        return tickets[0];
    }

    // Remove and return the highest-priority ticket
    public ServiceTicket removeHighestPriority() {

        if (isEmpty()) {
            return null;
        }

        ServiceTicket removedTicket = tickets[0];

        // Shift remaining tickets to the left
        for (int i = 0; i < size - 1; i++) {
            tickets[i] = tickets[i + 1];
        }

        tickets[size - 1] = null;
        size--;

        return removedTicket;
    }

    // Display all tickets in priority order
    public void displayTickets() {

        if (isEmpty()) {
            System.out.println("No tickets available.");
            return;
        }

        for (int i = 0; i < size; i++) {

            System.out.println(
                "Ticket ID: " + tickets[i].getTicketID()
                + " | Customer: " + tickets[i].getCustomerName()
                + " | Priority: " + tickets[i].getPriorityName()
                + " | Status: " + tickets[i].getStatus()
            );
        }
    }

    // Search for a ticket using its ID
    public ServiceTicket searchTicket(String ticketID) {

        if (ticketID == null || ticketID.trim().isEmpty()) {
            return null;
        }

        // Manual linear search
        for (int i = 0; i < size; i++) {

            if (tickets[i].getTicketID().equalsIgnoreCase(
                    ticketID.trim())) {

                return tickets[i];
            }
        }

        return null;
    }
}
