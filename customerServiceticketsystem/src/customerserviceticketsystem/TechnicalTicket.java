
package CustomerServiceticketsystem ;

public class TechnicalTicket extends ServiceTicket {

    // Additional attributes for technical tickets
    private String deviceType;
    private String technicalIssue;

    // Constructor
    public TechnicalTicket(String ticketID,
                           String customerName,
                           String description,
                           String dateSubmitted,
                           int priority,
                           String deviceType,
                           String technicalIssue) {

        super(ticketID, customerName, description,
              dateSubmitted, priority);

        setDeviceType(deviceType);
        setTechnicalIssue(technicalIssue);
    }

    // Getters
    public String getDeviceType() {
        return deviceType;
    }

    public String getTechnicalIssue() {
        return technicalIssue;
    }

    // Setters with validation
    public void setDeviceType(String deviceType) {
        if (deviceType == null || deviceType.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "Device type cannot be empty."
            );
        }

        this.deviceType = deviceType.trim();
    }

    public void setTechnicalIssue(String technicalIssue) {
        if (technicalIssue == null ||
            technicalIssue.trim().isEmpty()) {

            throw new IllegalArgumentException(
                "Technical issue cannot be empty."
            );
        }

        this.technicalIssue = technicalIssue.trim();
    }

    // Override parent method
    @Override
    public String getTicketType() {
        return "Technical";
    }
}
