
package customerserviceticket;

import java.io.Serializable;

public class Ticket implements Serializable {

    private static final long serialVersionUID = 1L;

    // PRIVATE ATTRIBUTES (ENCAPSULATION)
    private String ticketId;
    private String customerName;
    private String category;
    private String description;
    private String status;

    // CONSTRUCTOR
    public Ticket(String ticketId, String customerName,
                  String category, String description, String status) {

        setTicketId(ticketId);
        setCustomerName(customerName);
        setCategory(category);
        setDescription(description);
        setStatus(status);
    }

    // GETTERS
    public String getTicketId() {
        return ticketId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    // SETTERS WITH VALIDATION
    public void setTicketId(String ticketId) {
        if (ticketId == null || ticketId.trim().isEmpty()) {
            throw new IllegalArgumentException("Ticket ID is required.");
        }
        this.ticketId = ticketId.trim();
    }

    public void setCustomerName(String customerName) {
        if (customerName == null || customerName.trim().isEmpty()) {
            throw new IllegalArgumentException("Customer name is required.");
        }
        this.customerName = customerName.trim();
    }

    public void setCategory(String category) {
        if (category == null || category.trim().isEmpty()) {
            throw new IllegalArgumentException("Category is required.");
        }
        this.category = category.trim();
    }

    public void setDescription(String description) {
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("Description is required.");
        }
        this.description = description.trim();
    }

    public void setStatus(String status) {
        if (status == null || status.trim().isEmpty()) {
            throw new IllegalArgumentException("Status is required.");
        }

        String cleanStatus = status.trim();

        if (!cleanStatus.equals("Pending")
                && !cleanStatus.equals("In Progress")
                && !cleanStatus.equals("Resolved")) {
            throw new IllegalArgumentException("Invalid ticket status.");
        }

        this.status = cleanStatus;
    }
}
