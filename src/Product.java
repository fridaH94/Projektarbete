import java.io.Serializable;

public class Product implements Serializable {

    private String name;
    private String type;
    private double price;
    static int count = 1;
    int id;


    public Product(String name, String type, double price){ //Konstruktor
        this.name = name;
        this.type = type;
        this.price = price;
        this.id = count ++;
    }


    // Getters och setters

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getType(){
        return type;
    }

    public void setType(String type){
        this.type = type;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", id=" + id +
                '}';
    }
}

