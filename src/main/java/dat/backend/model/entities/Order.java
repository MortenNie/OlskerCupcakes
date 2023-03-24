package dat.backend.model.entities;

import java.sql.Timestamp;

public class Order {
    private int orderId;
    private Timestamp date;
    private String username;


    public Order(int orderId, Timestamp date, String username) {
        this.orderId = orderId;
        this.date = date;
        this.username = username;
    }

    public int getOrderId() {
        return orderId;
    }

    public Timestamp getDate() {
        return date;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", date=" + date +
                '}';
    }


}
