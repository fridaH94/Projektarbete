import java.io.Serializable;

public class Customer implements Serializable{

    private String name;

    private String city;
    int id;
    Cart cart = new Cart();

    public Customer(int id, String name, String city){ //Konstruktor
        this.name = name;
        this.id = id;
        this.city = city;
    }

    //getters och setters

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getCity(){
        return city;
    }

    public void setCity(String city){
        this.city = city;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", id=" + id +
                '}';
    }
}