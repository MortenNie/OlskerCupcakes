package dat.backend.model.entities;

public class Topping {
    private int toppingId;
    private String toppingName;
    private int price;

    public Topping(int toppingId, String toppingName, int price) {
        this.toppingId = toppingId;
        this.toppingName = toppingName;
        this.price = price;
    }


    public int getToppingId() {
        return toppingId;
    }

    public String getToppingName() {
        return toppingName;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Topping{" +
                "toppingId=" + toppingId +
                ", toppingName='" + toppingName + '\'' +
                ", price=" + price +
                '}';
    }
}
