
import java.io.Serializable;
import java.util.ArrayList;

public class ProductRegister implements Serializable {

    ArrayList<Product> products = new ArrayList<>();   //Lista för produkter

    public void addProduct(Product product){

        products.add(product);
    }

    public Product getProduct(int id){       //Checks that the inscribed productID in the addProductToCustomer method is
        for(int i = 0; i < products.size(); i++){  // available by looping it through th productArrayList
            Product pd = products.get(i);
            if( pd.id == id )
                return pd;
        }
        return null;
    }

}
