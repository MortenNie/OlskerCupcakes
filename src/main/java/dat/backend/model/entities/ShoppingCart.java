package dat.backend.model.entities;
import java.util.ArrayList;


public class ShoppingCart {

   private ArrayList<Product> products =new ArrayList<>();

    public ShoppingCart() {
    }

    public void addProduct(Product product){

     products.add(product);
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public int getSize(){
        return products.size();
    }

    public int getTotalPrice(){
        int sum = 0;
        for (Product p : products) {
            sum = sum + p.getQuantity() * (p.getBottoms().getPrice() + p.getTopping().getPrice());

        }
        return  sum;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "products=" + products +
                '}';
    }
}
