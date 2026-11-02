
package CustomerServiceticketsystem;

public class ServiceTicket {

    // Priority constants
    public static final int HIGH = 1;
    public static final int MEDIUM = 2;
    public static final int LOW = 3;

    // Private attributes
    private String ticketID;
    private String customerName;
    private String description;
    private String dateSubmitted;
    private String status;
    private int priority;

    // Constructor
    public ServiceTicket(String ticketID,
                         String customerName,
                         String description,
                         String dateSubmitted,
                         int priority) {

        setTicketID(ticketID);
        setCustomerName(customerName);
        setDescription(description);
        setDateSubmitted(dateSubmitted);
        setPriority(priority);

        this.status = "Pending";
    }

    // Getters
    public String getTicketID() {
        return ticketID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getDescription() {
        return description;
    }

    public String getDateSubmitted() {
        return dateSubmitted;
    }

    public String getStatus() {
        return status;
    }

    public int getPriority() {
        return priority;
    }

    // Setters with validation
    public void setTicketID(String ticketID) {
        if (ticketID == null || ticketID.trim().isEmpty()) {
            throw new IllegalArgumentException("Ticket ID cannot be empty.");
        }
        this.ticketID = ticketID.trim();
    }

    public void setCustomerName(String customerName) {
        if (customerName == null || customerName.trim().isEmpty()) {
            throw new IllegalArgumentException("Customer name cannot be empty.");
        }
        this.customerName = customerName.trim();
    }

    public void setDescription(String description) {
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("Description cannot be empty.");
        }
        this.description = description.trim();
    }

    public void setDateSubmitted(String dateSubmitted) {
        if (dateSubmitted == null || dateSubmitted.trim().isEmpty()) {
            throw new IllegalArgumentException("Date submitted cannot be empty.");
        }
        this.dateSubmitted = dateSubmitted.trim();
    }

    public void setStatus(String status) {
        if (status == null || status.trim().isEmpty()) {
            throw new IllegalArgumentException("Status cannot be empty.");
        }
        this.status = status.trim();
    }

    public void setPriority(int priority) {
        if (priority != HIGH && priority != MEDIUM && priority != LOW) {
            throw new IllegalArgumentException("Invalid ticket priority.");
        }
        this.priority = priority;
    }

    // Get priority name
    public String getPriorityName() {
        if (priority == HIGH) {
            return "High";
        } else if (priority == MEDIUM) {
            return "Medium";
        } else {
            return "Low";
        }
    }

    // Common ticket type
    public String getTicketType() {
        return "General";
    }
}
