package customerserviceticket;

public class TicketManagerTest {

    public static void main(String[] args) {

        TicketManager manager = new TicketManager();

        Ticket ticket1 = new GeneralTicket(
                "T001", "John Santos",
                "Cannot update personal information",
                "Pending", "Account Concern"
        );

        Ticket ticket2 = new TechnicalTicket(
                "T002", "Maria Cruz",
                "Computer cannot connect to the internet",
                "In Progress", "Computer", "Network Problem"
        );

        System.out.println("ADD TICKETS:");
        System.out.println(manager.addTicket(ticket1));
        System.out.println(manager.addTicket(ticket2));

        System.out.println("Total tickets: " + manager.getSize());

        System.out.println("\nSEARCH TICKET T002:");
        Ticket found = manager.searchTicket("T002");

        if (found != null) {
            System.out.println("Found: " + found.getCustomerName());
        } else {
            System.out.println("Ticket not found.");
        }

        System.out.println("\nUPDATE TICKET T001:");
        System.out.println(
                manager.updateTicketStatus("T001", "Resolved")
        );

        System.out.println(
                "New status: " + manager.searchTicket("T001").getStatus()
        );

        System.out.println("\nDISPLAY TICKETS:");

        for (int i = 0; i < manager.getSize(); i++) {
            Ticket ticket = manager.getTicketAt(i);

            System.out.println(
                    ticket.getTicketId() + " - "
                    + ticket.getCustomerName() + " - "
                    + ticket.getStatus()
            );
        }

        System.out.println("\nDELETE TICKET T002:");
        System.out.println(manager.deleteTicket("T002"));

        System.out.println("Remaining tickets: " + manager.getSize());

        System.out.println("\nIS LIST EMPTY?");
        System.out.println(manager.isEmpty());
    }
}