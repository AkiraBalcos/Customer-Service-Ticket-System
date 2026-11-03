
package CustomerServiceticketsystem ;

public class TicketSearch {

    // Manual Linear Search
    public ServiceTicket searchTicket(
            TicketPriorityQueue queue, String ticketID) {

        if (queue == null ||
            ticketID == null ||
            ticketID.trim().isEmpty()) {

            return null;
        }

        // Check each ticket one by one
        for (int i = 0; i < queue.getSize(); i++) {

            ServiceTicket currentTicket =
                    queue.getTicketAt(i);

            if (currentTicket.getTicketID()
                    .equalsIgnoreCase(ticketID.trim())) {

                return currentTicket;
            }
        }

        // Ticket was not found
        return null;
    }
}
