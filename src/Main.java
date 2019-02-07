import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static Scanner in = new Scanner(System.in);

    CustomerRegister customerList = new CustomerRegister();

    public void display_menu() {
        System.out.println("1) Registrera ny kund\n2) Handla varor\n3) Sök kund\n4) Lista på kunder\n5) Avsluta");
        System.out.print("Välj ett alternativ: ");

    }


    public static void main (String[]args) {
        Main mainObjekt = new Main();

        while (true) {


            mainObjekt.display_menu();
            switch (matchingNumber()) {
                case 1:
                    mainObjekt.addCustomer();
                    break;
                case 2:
                    System.out.println("varor");
                    break;
                case 3:
                    System.out.println("kund");
                    break;
                case 4:
                    mainObjekt.printList();
                case 5:
                    return;
                default:
                    System.err.println("Error, försök igen");
                    break;
            }
        }
    }


    public void addCustomer () {
        System.out.println("Skriv in ditt namn:");
        String name = in.nextLine();
        System.out.println("Skriv in din stad:");
        String city = in.nextLine();

        customerList.customers.add(new Customer(name, city));
    }
    public void printList() {
        for (int i = 0; i < customerList.customers.size(); i++)
            System.out.println(customerList.customers.get(i));
    }


    public static int matchingNumber () {
        int temp = 0;
        boolean validinput = false;
        do {
            try {
                temp = in.nextInt();
                in.nextLine();
                validinput = true;
            } catch (InputMismatchException e) {

                System.out.println("Error, försök igen.");
                in.next();
            }
        } while (!validinput);
        return temp;
    }

}