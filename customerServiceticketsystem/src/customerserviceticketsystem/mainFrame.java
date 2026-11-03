
package CustomerServiceticketsystem ;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MainFrame extends JFrame {

    // Form components
    private JTextField txtCustomerName;
    private JTextField txtDescription;
    private JTextField txtDeviceType;
    private JTextField txtTechnicalIssue;
    private JTextField txtInvoiceNumber;
    private JTextField txtBillingIssue;

    private JComboBox<String> cmbTicketType;
    private JComboBox<String> cmbPriority;

    // Search component
    private JTextField txtSearch;

    // Table components
    private JTable tblTickets;
    private DefaultTableModel tableModel;

    // Buttons
    private JButton btnSubmit;
    private JButton btnSearch;
    private JButton btnProcess;
    private JButton btnRefresh;

    // Constructor
    public MainFrame() {

        setTitle("Customer Service Ticket Management System");
        setSize(1100, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout(10, 10));

        // Main header
        JLabel lblTitle = new JLabel(
                "CUSTOMER SERVICE TICKET MANAGEMENT SYSTEM",
                SwingConstants.CENTER
        );

        lblTitle.setFont(new Font("Arial", Font.BOLD, 22));
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setOpaque(true);
        lblTitle.setBackground(new Color(35, 70, 110));
        lblTitle.setBorder(
                BorderFactory.createEmptyBorder(20, 10, 20, 10)
        );

        add(lblTitle, BorderLayout.NORTH);

        // Main content panel
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(
                BorderFactory.createEmptyBorder(10, 15, 15, 15)
        );

        // Ticket submission form
        JPanel formPanel = new JPanel(new GridLayout(0, 2, 8, 8));

        formPanel.setBorder(
                BorderFactory.createTitledBorder("Submit Customer Ticket")
        );

        txtCustomerName = new JTextField();
        txtDescription = new JTextField();

        cmbTicketType = new JComboBox<>(
                new String[]{"Technical", "Billing"}
        );

        cmbPriority = new JComboBox<>(
                new String[]{"High", "Medium", "Low"}
        );

        txtDeviceType = new JTextField();
        txtTechnicalIssue = new JTextField();

        txtInvoiceNumber = new JTextField();
        txtBillingIssue = new JTextField();

        formPanel.add(new JLabel("Customer Name:"));
        formPanel.add(txtCustomerName);

        formPanel.add(new JLabel("Description:"));
        formPanel.add(txtDescription);

        formPanel.add(new JLabel("Ticket Type:"));
        formPanel.add(cmbTicketType);

        formPanel.add(new JLabel("Priority:"));
        formPanel.add(cmbPriority);

        formPanel.add(new JLabel("Device Type:"));
        formPanel.add(txtDeviceType);

        formPanel.add(new JLabel("Technical Issue:"));
        formPanel.add(txtTechnicalIssue);

        formPanel.add(new JLabel("Invoice Number:"));
        formPanel.add(txtInvoiceNumber);

        formPanel.add(new JLabel("Billing Issue:"));
        formPanel.add(txtBillingIssue);

        btnSubmit = new JButton("Submit Ticket");
        formPanel.add(btnSubmit);

        btnRefresh = new JButton("Refresh Table");
        formPanel.add(btnRefresh);

        mainPanel.add(formPanel, BorderLayout.NORTH);

        // Search panel
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        txtSearch = new JTextField(20);
        btnSearch = new JButton("Search");
        btnProcess = new JButton("Process Next Ticket");

        searchPanel.add(new JLabel("Search Ticket ID:"));
        searchPanel.add(txtSearch);
        searchPanel.add(btnSearch);
        searchPanel.add(btnProcess);

        // Ticket table
        String[] columns = {
            "Ticket ID",
            "Customer Name",
            "Ticket Type",
            "Description",
            "Priority",
            "Status",
            "Date Submitted"
        };

        tableModel = new DefaultTableModel(columns, 0) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tblTickets = new JTable(tableModel);
        tblTickets.setRowHeight(25);
        tblTickets.setAutoCreateRowSorter(true);

        JScrollPane scrollPane = new JScrollPane(tblTickets);

        JPanel bottomPanel = new JPanel(new BorderLayout(5, 5));

        bottomPanel.add(searchPanel, BorderLayout.NORTH);
        bottomPanel.add(scrollPane, BorderLayout.CENTER);

        mainPanel.add(bottomPanel, BorderLayout.CENTER);

        add(mainPanel, BorderLayout.CENTER);

        setVisible(true);
    }
}
