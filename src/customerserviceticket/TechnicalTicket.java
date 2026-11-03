package customerserviceticket;

public class TechnicalTicket extends Ticket {

    private String deviceOrSystem;
    private String technicalIssue;

    public TechnicalTicket(String ticketId, String customerName,
                           String description, String status,
                           String deviceOrSystem, String technicalIssue) {

        super(ticketId, customerName, "Technical", description, status);

        setDeviceOrSystem(deviceOrSystem);
        setTechnicalIssue(technicalIssue);
    }

    public String getDeviceOrSystem() {
        return deviceOrSystem;
    }

    public void setDeviceOrSystem(String deviceOrSystem) {
        if (deviceOrSystem == null || deviceOrSystem.trim().isEmpty()) {
            throw new IllegalArgumentException("Device or system is required.");
        }

        this.deviceOrSystem = deviceOrSystem.trim();
    }

    public String getTechnicalIssue() {
        return technicalIssue;
    }

    public void setTechnicalIssue(String technicalIssue) {
        if (technicalIssue == null || technicalIssue.trim().isEmpty()) {
            throw new IllegalArgumentException("Technical issue is required.");
        }

        this.technicalIssue = technicalIssue.trim();
    }

    public String getTicketDetails() {
        return "Technical Ticket - " + getTicketId()
                + " | Device/System: " + deviceOrSystem
                + " | Issue: " + technicalIssue;
    }
}