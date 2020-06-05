import java.util.HashMap;
import java.util.Scanner;

abstract class Store {

    private String name;
    private String address;
    static HashMap<Integer, String> AdminAccounts = new HashMap<>();
    static HashMap<Integer, Item> inventory = new HashMap<>();
    static HashMap<Integer, Customer> customers = new HashMap<>();
    static HashMap<Integer, Online> onlineAccounts = new HashMap<>();
    static HashMap<String, Card> cards = new HashMap<>();

    Scanner scanner = new Scanner(System.in);
    static int customerID = 125;
    static HashMap<Item, Customer> customerWithItem = new HashMap<>();
    static int iD;



    public boolean makeASale() {
        //This gets the info of the customer


        System.out.println("Please Enter the name of the customer:");
        String name = scanner.nextLine();
        System.out.println("Please Enter the email of the customer:");
        String email = scanner.nextLine();
        System.out.println("Please Enter the phone number of the customer:");
        String phoneNo = scanner.nextLine();
        customers.put(customerID, new Customer(name, email, phoneNo));
        System.out.println("Customer's id is :" + customerID);


        //This asks the user about the item id and tells the price.

        System.out.println("Please enter the id of item you'd like to sale:");

        iD = scanner.nextInt();
        scanner.nextLine();

        if (inventory.get(iD) != null) {
            System.out.println();
            System.out.println("The Name of the product is :" + inventory.get(iD).getName());
            System.out.println("The Price of the product is :" + inventory.get(iD).getPrice());
            System.out.println();
        } else return false;

        int price = inventory.get(iD).getPrice();
        System.out.println("How would you like to pay:");

        System.out.println("Press 1 for Credit/Debit Card");
        System.out.println("Press 2 for Online Payment");
        System.out.println("Press 3 for cash");
        System.out.println("Press 0 for terminate");
        int selector = scanner.nextInt();
        scanner.nextLine();
        switch (selector) {
            case 1:
                System.out.println("Enter the card type (i.e Visa):");
                String type = scanner.nextLine();
                System.out.println("Enter the card number:");
                String number = scanner.nextLine();
                System.out.println("Enter the card balance");
                double balance = scanner.nextDouble();
                if (Card.swipeCard(type, number, balance, inventory.get(iD).getPrice())) {
                    System.out.println("Card accepted!!");
                    return true;
                } else return false;
            case 2:
                //This code block makes some dummy online accounts.

                onlineAccounts.put(4789, new Online("1234546789", 4789, 2000));
                onlineAccounts.put(4459, new Online("1234848789", 4459, 3000));
                onlineAccounts.put(7419, new Online("1485644864", 7419, 4000));

                System.out.println("Enter the account number:");
                String accNo = scanner.nextLine();
                System.out.println("Enter the pin:");
                int pin = scanner.nextInt();
                scanner.nextLine();
                if (onlineAccounts.get(pin) != null) {
                    if (onlineAccounts.get(pin).canMake(price) >= 0) {
                        System.out.println("Payment successful");
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            case 3:
                System.out.println("Enter the amount of cash:");
                double cash = scanner.nextInt();
                scanner.nextLine();
                Cash cash1 = new Cash(cash, true);
                double remainingCash = cash1.canMake(price);
                if (remainingCash >= 0) {
                    System.out.println("The remaining balance is :" + remainingCash);
                    return true;

                } else return false;


        }
        return false;
    }

    public void addInventoryItem() {
        System.out.println(" Please enter the item's name:");
        String name = scanner.nextLine();
        System.out.println("Please enter the items's id:");
        int iD = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Please enter the item's description:");
        String description = scanner.nextLine();
        System.out.println("Please enter the item's price in $:");
        int price = scanner.nextInt();
        scanner.nextLine();
        inventory.put(iD, new Item(name, iD, description, price));
    }

    public void listInventoryItems() {
        System.out.println();
        inventory.forEach((k, v) -> System.out.println(v));
        System.out.println();
    }


    public static void addAdminAccount(String name, int pin) {
        AdminAccounts.put(pin, name);
    }

    public Store(String name, String address) {
        this.setName(name);
        this.setAddress(address);

    }

    abstract void accessStore();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
