
import java.util.*;

public class TicketInformation {
    //declaration of variables
    private String ticketId;
    private String rideName;
    private int ticketQuantity;
    private double ticketPrice;
    private String purchaseDate;

    //Constructor with parameters
    public TicketInformation(String ticketId, String rideName, int ticketQuantity, double ticketPrice, String purchaseDate) {
        this.ticketId = ticketId;
        this.rideName = rideName;
        this.ticketPrice = ticketPrice;
        this.ticketQuantity = ticketQuantity;
        this.purchaseDate = purchaseDate;
    }
    //Getters
    public String getTicketId() {
        return ticketId;
    }

    public String getRideName() {
        return rideName;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }
    public int getTicketQuantity() {
        return ticketQuantity;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    //To string method
    public String toString() {
        return "TicketInformation{" +
        "ticketId='" + ticketId + '\'' +
        ", rideName='" + rideName + '\'' +
        ", ticketPrice=" + ticketPrice +
        ", purchaseDate=" + purchaseDate +
        '}';
    }
}
