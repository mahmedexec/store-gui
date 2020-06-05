import java.util.Scanner;

public class OnlineStore extends Store {
    public OnlineStore(String name, String address) {
        super(name, address);
    }

    @Override
        //The store is accessed by the admin using this method which is called
        //from the Main class
    void accessStore() {

        System.out.println("------------------------------------------");
        System.out.println("Welcome to " + this.getName());
        System.out.println("Located at " + this.getAddress());

        Scanner scanner = new Scanner(System.in);

        do {
            //This is used to authenticate the admin.

            System.out.println("Dear Administrator please enter you 4 digit PIN:");
            int pin = scanner.nextInt();
            if (AdminAccounts.get(pin) != null) {
                System.out.println("You have logged in as " + AdminAccounts.get(pin) + "\n");
                break;
            } else

                //The loop will continue until the user presses 0.

                System.out.println("You have entered wrong PIN, to try again press 1, to terminate press 0");
        } while (scanner.nextInt() == 1);

        //This block stores a few items so that if the user adds no items then they could be of use.
        {
            inventory.put(1111, new Item("Airpods", 1111, "1st Generation"
                    , 159));
            inventory.put(1112, new Item("iPhone 11 Pro Max", 1112, "Silver 64GB Unlocked"
                    , 1099));
            inventory.put(1113, new Item("Macbook Pro", 1113, "512GB Space Gray without touch-bar"
                    , 1199));
            inventory.put(1114, new Item("iPad Pro 12.9'", 1114, "1TB Gold with cellular connectivity"
                    , 1199));
        }
        int selector;
        do {

            System.out.println("To add an item to inventory press 1");
            System.out.println("To view the inventory press 2");
            System.out.println("To make a sale press 3");
            System.out.println("To logout press 0");
            selector = scanner.nextInt();
            scanner.nextLine();
            switch (selector) {
                case 1:

                    this.addInventoryItem();
                    break;
                case 2:
                    this.listInventoryItems();
                    break;
                case 3:
                    if (this.makeASale()){

                        System.out.println("Sale successful!!!");
                        Order order = new Order(inventory.get(iD),customers.get(customerID));
                        System.out.println(order);
                        customerID++;

                    }

                    else
                        System.out.println("Bad sale!!!");


            }
        } while (selector != 0);

    }
}
