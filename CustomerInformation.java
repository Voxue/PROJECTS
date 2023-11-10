import java.util.*;
import java.text.DecimalFormat;

public class CustomerInformation {
    DecimalFormat decimalFormat = new DecimalFormat("0.00");
    private String custId;
    private String custName;
    private int counterPaid;
    private String customerType;
    private List<TicketInformation> ticketList;

    // No-args constructor
    public CustomerInformation() {
    }

    // Normal constructor
    public CustomerInformation(String custId, String custName, int counterPaid, List<TicketInformation> ticketList, String customerType) {
        this.custId = custId;
        this.custName = custName;
        this.counterPaid = counterPaid;
        this.ticketList = ticketList;
        this.customerType = customerType;
    }

    // Getters
    public String getCustId() {
        return custId;
    }

    public String getCustName() {
        return custName;
    }

    public int getCounterPaid() {
        return counterPaid;
    }

    public List<TicketInformation> getTickets() {
        return ticketList;
    }

    public String getCustomerType() {
        return customerType;
    }
    //Calculation for totalQuantity
    public int getTotalTicketQuantity() {
    int totalQuantity = 0;
    for (TicketInformation ticket : ticketList) {
        totalQuantity += ticket.getTicketQuantity();
    }
    return totalQuantity;
}
    
    //Calculation for totalPrice
    public double totalPrice() {
        double total = 0.0;
        for (TicketInformation tickets : ticketList) {
            total = total + tickets.getTicketQuantity() * tickets.getTicketPrice();
        }
        return total;
    }

    // Setters
    public void setCustId(String custId) {
        this.custId = custId;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public void setCounterPaid(int counterPaid) {
        this.counterPaid = counterPaid;
    }

    public void setTickets(List<TicketInformation> ticketList) {
        this.ticketList = ticketList;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    // method to display purchased items
    public String displayPurchasedTickets() {
        TicketInformation ticket;
        String table = "";

        table += "\n+------------+-----------+--------------------+-------------+-------------+\n";
        table += "| Ticket No. | Ticket ID |    Ride Name       | Ticket Price|     Date    |\n";
        table += "+------------+-----------+--------------------+-------------+-------------+\n";

        for (int i = 0; i < ticketList.size(); i++) {
            ticket = ticketList.get(i);
            table += String.format("|  %-8s  | %-9s | %-18s | %11.2f | %11s |\n", (i + 1), ticket.getTicketId(),
                ticket.getRideName(), ticket.getTicketPrice(), ticket.getPurchaseDate());
        }

        table += "+------------+-----------+--------------------+-------------+-------------+\n";

        return table;
    }
    //To string method
    public String toString() {
    return "Customer ID: " + custId + "\n" +
           "Customer Name: " + custName + "\n" +
           "Counter Paid: " + counterPaid + "\n" +
           "Customer Type: " + customerType + "\n" +
           "Ticket Quantity: " + getTotalTicketQuantity() + "\n" +
              displayPurchasedTickets() + "\n" +
           "Total Price: " + decimalFormat.format(totalPrice()) + "\n";
    }
}
