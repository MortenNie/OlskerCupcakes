package dat.backend.model.entities;

import java.sql.Timestamp;

public class Order {
    private int orderId;
    private Timestamp date;

    public Order(int orderId, Timestamp date) {
        this.orderId = orderId;
        this.date = date;
    }

    public int getOrderId() {
        return orderId;
    }

    public Timestamp getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", date=" + date +
                '}';
    }
}
