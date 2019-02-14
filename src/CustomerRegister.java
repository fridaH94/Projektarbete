import java.util.ArrayList;
import java.io.Serializable;


public class CustomerRegister implements Serializable {

    ArrayList<Customer> customers = new ArrayList<>();    //Lista för kunder




    public Customer getCustomer(int id){
        for(int i = 0; i < customers.size(); i++){
            Customer cus = customers.get(i);
            if( cus.id == id )
                return cus;

        }

        return null;
    }

}