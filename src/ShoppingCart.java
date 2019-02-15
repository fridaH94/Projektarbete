import java.util.ArrayList;
import java.io.Serializable;

public class ShoppingCart implements Serializable {

    static ArrayList<Product> shoppingCart = new ArrayList<Product>();

    public void addProduct (Product product) {
        shoppingCart.add(product);
    }

    @Override
    public String toString() {
        return "ShoppingCart{}";
    }
}
