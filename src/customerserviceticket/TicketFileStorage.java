
package customerserviceticket;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.Base64;

public class TicketFileStorage {

    private static final String FILE_NAME = "tickets.txt";

    // ENCODE TEXT TO PREVENT ISSUES WITH COMMAS AND SPECIAL CHARACTERS
    private static String encode(String value) {
        return Base64.getEncoder().encodeToString(
                value.getBytes(StandardCharsets.UTF_8));
    }

    // DECODE SAVED TEXT
    private static String decode(String value) {
        return new String(
                Base64.getDecoder().decode(value),
                StandardCharsets.UTF_8);
    }

    // SAVE TICKETS TO TXT FILE
    public static void saveTickets(TicketManager manager)
            throws IOException {

        try (BufferedWriter writer = Files.newBufferedWriter(
                Paths.get(FILE_NAME), StandardCharsets.UTF_8)) {

            for (int i = 0; i < manager.getSize(); i++) {

                Ticket ticket = manager.getTicketAt(i);

                String record;

                if (ticket instanceof GeneralTicket) {

                    GeneralTicket general = (GeneralTicket) ticket;

                    record = "GENERAL,"
                            + encode(ticket.getTicketId()) + ","
                            + encode(ticket.getCustomerName()) + ","
                            + encode(ticket.getDescription()) + ","
                            + encode(ticket.getStatus()) + ","
                            + encode(general.getConcernType());

                } else if (ticket instanceof TechnicalTicket) {

                    TechnicalTicket technical = (TechnicalTicket) ticket;

                    record = "TECHNICAL,"
                            + encode(ticket.getTicketId()) + ","
                            + encode(ticket.getCustomerName()) + ","
                            + encode(ticket.getDescription()) + ","
                            + encode(ticket.getStatus()) + ","
                            + encode(technical.getDeviceOrSystem()) + ","
                            + encode(technical.getTechnicalIssue());

                } else {
                    continue;
                }

                writer.write(record);
                writer.newLine();
            }
        }
    }

    // LOAD TICKETS FROM TXT FILE
    public static void loadTickets(TicketManager manager)
            throws IOException {

        Path path = Paths.get(FILE_NAME);

        if (!Files.exists(path)) {
            return;
        }

        TicketManager loadedTickets = new TicketManager();

        try (BufferedReader reader = Files.newBufferedReader(
                path, StandardCharsets.UTF_8)) {

            String line;

            while ((line = reader.readLine()) != null) {

                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] data = line.split(",", -1);

                Ticket ticket;

                if (data[0].equals("GENERAL") && data.length == 6) {

                    ticket = new GeneralTicket(
                            decode(data[1]),
                            decode(data[2]),
                            decode(data[3]),
                            decode(data[4]),
                            decode(data[5])
                    );

                } else if (data[0].equals("TECHNICAL")
                        && data.length == 7) {

                    ticket = new TechnicalTicket(
                            decode(data[1]),
                            decode(data[2]),
                            decode(data[3]),
                            decode(data[4]),
                            decode(data[5]),
                            decode(data[6])
                    );

                } else {
                    throw new IOException("Invalid ticket record in file.");
                }

                if (!loadedTickets.addTicket(ticket)) {
                    throw new IOException("Duplicate ticket ID in file.");
                }
            }
        } catch (IllegalArgumentException ex) {
            throw new IOException("Invalid ticket data in file.", ex);
        }

        // REPLACE CURRENT RECORDS WITH LOADED RECORDS
        manager.clearTickets();

        for (int i = 0; i < loadedTickets.getSize(); i++) {
            manager.addTicket(loadedTickets.getTicketAt(i));
        }
    }
}
