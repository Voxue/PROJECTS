import javax.swing.*;
import java.util.*;
import java.io.*;

public class MainClass {
    public static void main(String[] args) {
        // Create an instance of WelcomePage
        WelcomePage welcomePage = new WelcomePage();

        // Create a JFrame for the WelcomePage
        JFrame welcomeFrame = new JFrame("Welcome to Theme Park");
        welcomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        welcomeFrame.setContentPane(welcomePage);
        welcomeFrame.pack();
        welcomeFrame.setVisible(true);

        // Wait for the user to click the "Let's Start" button
        welcomePage.waitForStart();

        // Continue with the ThemeParkGUI after the user starts
        try {
            // Create 3 queues
            Queue qCounter1 = new Queue();
            Queue qCounter2 = new Queue();
            Queue qCounter3 = new Queue();

            // Create stack
            Stack completedStack = new Stack();

            // Read from customer.txt file
            BufferedReader in = new BufferedReader(new FileReader("customerList.txt"));

            // Create ArrayList
            LinkedList<CustomerInformation> customerList = new LinkedList<CustomerInformation>();

            // Declare indata (a line in input file)
            String inline;

            // Create object
            CustomerInformation cust;

            double total = 0.0;
            int totalCustomer = 0;

            while ((inline = in.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(inline, ",");

                String custId = st.nextToken();
                String custName = st.nextToken();
                int counterPaid = Integer.parseInt(st.nextToken());
                int ticketQuantity = Integer.parseInt(st.nextToken());
                String customerType = st.nextToken();

                List<TicketInformation> ticketList = new ArrayList<>();

                String ticketId = st.nextToken();
                String rideName = st.nextToken();
                double ticketPrice = Double.parseDouble(st.nextToken());
                String purchaseDate = st.nextToken();

                TicketInformation ticket = new TicketInformation(ticketId, rideName, ticketQuantity, ticketPrice, purchaseDate);
                ticketList.add(ticket);
                counterPaid += ticketPrice;
                // Update the total price for the customer
                //total += ticketPrice;

                // Create object
                cust = new CustomerInformation(custId, custName, counterPaid, ticketList, customerType);
                customerList.add(cust);
                totalCustomer++;
            }
            
            
            in.close();
            ThemeParkGUI gui = new ThemeParkGUI(customerList, qCounter1, qCounter2, qCounter3, totalCustomer, completedStack);
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    createAndShowGUI(gui);
                }
            });
        } catch (FileNotFoundException fnfe) {
            System.out.println("File not found");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    private static void createAndShowGUI(ThemeParkGUI gui) {
        // Create and set up the window.
        JFrame frame = new JFrame("Theme Park Queue Management");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add the GUI panel to the frame
        frame.add(gui);

        // Display the frame.
        frame.pack();
        frame.setVisible(true);
    }

}
