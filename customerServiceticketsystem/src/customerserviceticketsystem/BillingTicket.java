
package CustomerServiceticketsystem ;

public class BillingTicket extends ServiceTicket {

    // Additional attributes for billing tickets
    private String invoiceNumber;
    private String billingIssue;

    // Constructor
    public BillingTicket(String ticketID,
                         String customerName,
                         String description,
                         String dateSubmitted,
                         int priority,
                         String invoiceNumber,
                         String billingIssue) {

        super(ticketID, customerName, description,
              dateSubmitted, priority);

        setInvoiceNumber(invoiceNumber);
        setBillingIssue(billingIssue);
    }

    // Getters
    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public String getBillingIssue() {
        return billingIssue;
    }

    // Setters with validation
    public void setInvoiceNumber(String invoiceNumber) {
        if (invoiceNumber == null ||
            invoiceNumber.trim().isEmpty()) {

            throw new IllegalArgumentException(
                "Invoice number cannot be empty."
            );
        }

        this.invoiceNumber = invoiceNumber.trim();
    }

    public void setBillingIssue(String billingIssue) {
        if (billingIssue == null ||
            billingIssue.trim().isEmpty()) {

            throw new IllegalArgumentException(
                "Billing issue cannot be empty."
            );
        }

        this.billingIssue = billingIssue.trim();
    }

    // Override parent method
    @Override
    public String getTicketType() {
        return "Billing";
    }
}
