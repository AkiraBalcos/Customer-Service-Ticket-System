
package customerserviceticket;

public class TicketManager {

    private static class Node {
        Ticket ticket;
        Node next;

        Node(Ticket ticket) {
            this.ticket = ticket;
            this.next = null;
        }
    }

    // ACTIVE TICKETS
    private Node head;
    private int size;

    // DELETED TICKET HISTORY
    private Node historyHead;
    private int historySize;

    public TicketManager() {
        head = null;
        size = 0;

        historyHead = null;
        historySize = 0;
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

    // SEARCH ACTIVE TICKET
    public Ticket searchTicket(String ticketId) {

        if (ticketId == null) {
            return null;
        }

        Node current = head;

        while (current != null) {

            if (current.ticket.getTicketId()
                    .equalsIgnoreCase(ticketId.trim())) {
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

    // DELETE TICKET AND MOVE IT TO HISTORY
    public boolean deleteTicket(String ticketId) {

        if (head == null || ticketId == null) {
            return false;
        }

        Node current = head;
        Node previous = null;

        while (current != null) {

            if (current.ticket.getTicketId()
                    .equalsIgnoreCase(ticketId.trim())) {

                // Copy ticket reference into history
                Node historyNode = new Node(current.ticket);

                if (historyHead == null) {
                    historyHead = historyNode;
                } else {
                    Node historyCurrent = historyHead;

                    while (historyCurrent.next != null) {
                        historyCurrent = historyCurrent.next;
                    }

                    historyCurrent.next = historyNode;
                }

                historySize++;

                // Remove from active tickets
                if (previous == null) {
                    head = current.next;
                } else {
                    previous.next = current.next;
                }

                size--;
                return true;
            }

            previous = current;
            current = current.next;
        }

        return false;
    }

    // ACTIVE TICKET METHODS
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

    // TICKET HISTORY METHODS
    public int getHistorySize() {
        return historySize;
    }

    public Ticket getHistoryTicketAt(int index) {

        if (index < 0 || index >= historySize) {
            return null;
        }

        Node current = historyHead;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.ticket;
    }
}
