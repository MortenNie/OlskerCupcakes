package dat.backend.model.entities;

public class Product {
    private int productId;
    private String productName;
    private Topping topping;
    private Bottoms bottoms;
    private int quantity;

    public Product(int productId, String productName, Topping topping, Bottoms bottoms, int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.topping = topping;
        this.bottoms = bottoms;
        this.quantity = quantity;
    }
    public Product (String productName, Topping topping, Bottoms bottoms, int quantity ){
        this.productName = productName;
        this.topping = topping;
        this.bottoms = bottoms;
        this.quantity = quantity;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public Topping getTopping() {
        return topping;
    }

    public Bottoms getBottoms() {
        return bottoms;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Cupcake with " + bottoms + "bottom and " + topping + "topping.                      " + "quantity: " + quantity;
    }


}
