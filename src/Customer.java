public class Customer {

    private String name;
    private int id;
    private String city;

    public Customer(String name, int id, String city){
        this.name = name;
        this.id = id;
        this.city = city;
    }

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

    public String city(){
        return city;
    }

    public void setCity(String city){
        this.city = city;
    }
}
