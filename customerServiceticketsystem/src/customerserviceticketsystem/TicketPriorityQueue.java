
package CustomerServiceticketsystem;

public class TicketPriorityQueue {

   
    private static final int MAX_SIZE = 100;

   
    private ServiceTicket[] tickets;

    
    private int size;

   
    public TicketPriorityQueue() {
        tickets = new ServiceTicket[MAX_SIZE];
        size = 0;
    }

    
    public boolean isEmpty() {
        return size == 0;
    }

    
    public boolean isFull() {
        return size == MAX_SIZE;
    }

    
    public int getSize() {
        return size;
    }
    
public ServiceTicket getTicketAt(int index) {

    if (index < 0 || index >= size) {
        return null;
    }

    return tickets[index];
}

    
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

    
    public ServiceTicket peekHighestPriority() {

        if (isEmpty()) {
            return null;
        }

        return tickets[0];
    }

    
    public ServiceTicket removeHighestPriority() {

        if (isEmpty()) {
            return null;
        }

        ServiceTicket removedTicket = tickets[0];

      
        for (int i = 0; i < size - 1; i++) {
            tickets[i] = tickets[i + 1];
        }

        tickets[size - 1] = null;
        size--;

        return removedTicket;
    }

    
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

    
    public ServiceTicket searchTicket(String ticketID) {

        if (ticketID == null || ticketID.trim().isEmpty()) {
            return null;
        }

   
        for (int i = 0; i < size; i++) {

            if (tickets[i].getTicketID().equalsIgnoreCase(
                    ticketID.trim())) {

                return tickets[i];
            }
        }

        return null;
    }
}
