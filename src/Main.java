import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    static Scanner in = new Scanner(System.in);  //Läser in imatning


    CustomerRegister customerList = new CustomerRegister(); //objekt från custemorRegister
    ProductRegister productList = new ProductRegister();    // objekt från productRegister
    ShoppingCart shoppingList = new ShoppingCart();


    public void display_menu(){    //Start Meny

        System.out.println("Välj ett alternativ:\n1) Registrera ny kund\n2) Lägg till varor\n3) handla varor\n4) Sök kund\n5) Lista på kunder\n6) Avsluta");


    }


    public static void main (String[]args) {

        Main mainObject = new Main();
        mainObject.load();


        while (true) {


            mainObject.display_menu();
            switch (matchingNumber()) {
                case 1:
                    mainObject.addCustomer();
                    break;
                case 2:
                    mainObject.addProduct();
                    break;
                case 3:
                    mainObject.addToCart();
                    break;
                case 4:
                    mainObject.findCustemor();
                    break;
                case 5:
                    mainObject.printList();
                    break;
                case 6:
                    System.out.println("Välkommen åter!");
                    return;
                default:
                    System.err.println("Alternativet finns ej. Välj ett alternativ mellan 1-6,Försök igen!");
                    break;
            }

            mainObject.save();

        }

    }


    public void addCustomer () {                 //Metod: Lägger till kund
        System.out.println("Skriv in ditt namn:");     //utskrift
        String name = in.nextLine();                   //Inmatning
        name = firstLetterToUppercase(name);
        System.out.println("Skriv in din stad:");
        String city = in.nextLine();
        city = firstLetterToUppercase(city);

        int id = customerList.customers.size()+1;
        //int id = customerList.customers.stream().mapToInt(p -> p.getId()).max().getAsInt()+1;

        customerList.customers.add(new Customer( id , name, city));   //Lägger till ArrayList


    }
    public void addProduct() {        //Metod som Lägger till produkt
        System.out.println("Skriv in produkt:");    //utskrift
        String name = in.nextLine();              //Inmatning
        name = firstLetterToUppercase(name);
        System.out.println("Skriv in typ:");
        String typ = in.nextLine();
        typ = firstLetterToUppercase(typ);
        System.out.println("Skriv in pris:");
        double price = in.nextInt();

        productList.addProduct(new Product(name, typ, price));  //Lägger till i ArrayList
    }

    public void addToCart(){
        System.out.println("Skriv in ditt id:");
        int selectedId = in.nextInt();
        int id = selectedId;
        Customer customer = customerList.getCustomer(id);

        if(customer != null){

            System.out.println(productList.products);
            in.nextLine();
            System.out.println("välj produkt genom id: ");

            int selectedProduct = in.nextInt();
            int productId = selectedProduct;

            Product product = productList.getProduct(productId);
            ShoppingCart.shoppingCart.add(product);
            System.out.println(customer);
            System.out.println(customer.cart.toString());;

        }


        }




        public void findCustemor () {

            System.out.println("Ange kund id");
            int yourId = in.nextInt();
            int id = yourId;
            Customer customer = customerList.getCustomer(id);
            System.out.println(customer);
        }


        public void printList () {                     //Metod som skriver ut kunder
            for (int i = 0; i < customerList.customers.size(); i++)
                System.out.println(customerList.customers.get(i));
        }


        public static int matchingNumber () {        //Metod som kollar om inmatning finns
            int temp = 0;
            boolean currentinput = false;
            do {
                try {
                    temp = in.nextInt();
                    in.nextLine();
                    currentinput = true;
                } catch (InputMismatchException e) {

                    System.out.println("Ogilltlig inmatning!\nVälj en siffra mellan 1-6, försök igen!");
                    in.next();
                }
            } while (!currentinput);
            return temp;
        }

        public void save () {//Save object to file

            File file = new File("projektet.save");
            try (ObjectOutputStream out =
                         new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
                out.writeObject(customerList.customers);
                out.writeObject(productList.products);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void load () {
            File file = new File("projektet.save");
            try (ObjectInputStream in =
                         new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {
                customerList.customers = (ArrayList<Customer>) in.readObject();
                productList.products = (ArrayList<Product>) in.readObject();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

    public static String firstLetterToUppercase(String input) {

        String first = input.substring(0, 1).toUpperCase();
        String rest = input.substring(1).toLowerCase();

        return first + rest;
    }
    }


