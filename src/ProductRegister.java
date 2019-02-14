
import java.io.Serializable;
import java.util.ArrayList;

public class ProductRegister implements Serializable {

    ArrayList<Product> products = new ArrayList<>();   //Lista för produkter

    public void addProduct(Product product){

        products.add(product);
    }

}
