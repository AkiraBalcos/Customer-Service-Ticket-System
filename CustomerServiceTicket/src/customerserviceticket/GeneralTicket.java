package customerserviceticket;

public class GeneralTicket extends Ticket {

    private String concernType;

    public GeneralTicket(String ticketId, String customerName,
                         String description, String status,
                         String concernType) {

        super(ticketId, customerName, "General", description, status);
        this.concernType = concernType;
    }

    public String getConcernType() {
        return concernType;
    }

    public void setConcernType(String concernType) {
        if (concernType == null || concernType.trim().isEmpty()) {
            throw new IllegalArgumentException("Concern type is required.");
        }

        this.concernType = concernType.trim();
    }

    public String getTicketDetails() {
        return "General Ticket - " + getTicketId()
                + " | Concern: " + concernType;
    }
}