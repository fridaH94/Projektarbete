public class Customer {

    private String name;
    static int count = 1;
    private String city;
    int id;

    public Customer(String name, String city){
        this.name = name;
        this.id = count++;
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