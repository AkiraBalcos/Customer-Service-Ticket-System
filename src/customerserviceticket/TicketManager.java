package customerserviceticket;

public class TicketManager {

    // NODE CLASS
    private static class Node {
        Ticket ticket;
        Node next;

        Node(Ticket ticket) {
            this.ticket = ticket;
            this.next = null;
        }
    }

    // LINKED LIST POINTERS
    private Node head;
    private int size;

    // CONSTRUCTOR
    public TicketManager() {
        head = null;
        size = 0;
    }

    // ADD TICKET
    public boolean addTicket(Ticket ticket) {

        if (ticket == null || searchTicket(ticket.getTicketId()) != null) {
            return false;
        }

        Node newNode = new Node(ticket);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
        }

        size++;
        return true;
    }

    // SEARCH TICKET - MANUAL LINEAR SEARCH
    public Ticket searchTicket(String ticketId) {

        Node current = head;

        while (current != null) {

            if (current.ticket.getTicketId().equalsIgnoreCase(ticketId)) {
                return current.ticket;
            }

            current = current.next;
        }

        return null;
    }

    // UPDATE TICKET STATUS
    public boolean updateTicketStatus(String ticketId, String newStatus) {

        Ticket ticket = searchTicket(ticketId);

        if (ticket == null) {
            return false;
        }

        ticket.setStatus(newStatus);
        return true;
    }

    // DELETE TICKET
    public boolean deleteTicket(String ticketId) {

        if (head == null || ticketId == null) {
            return false;
        }

        if (head.ticket.getTicketId().equalsIgnoreCase(ticketId)) {
            head = head.next;
            size--;
            return true;
        }

        Node current = head;

        while (current.next != null) {

            if (current.next.ticket.getTicketId().equalsIgnoreCase(ticketId)) {
                current.next = current.next.next;
                size--;
                return true;
            }

            current = current.next;
        }

        return false;
    }
    public void clearTickets() {
    head = null;
    size = 0;
}

   
    public int getSize() {
        return size;
    }

    
    public boolean isEmpty() {
        return head == null;
    }

     
    public Ticket getTicketAt(int index) {

        if (index < 0 || index >= size) {
            return null;
        }

        Node current = head;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.ticket;
    }
}