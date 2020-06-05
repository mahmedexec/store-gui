public class Main {

    //So basically in this project I'm supposing that this is a inventory/POS system used by apple at their Fifth
    //Avenue store.
    //This program will allow the "geniuses" to add inventory items as well as sell them and generate receipts
    //against payments., Here it goes:

    public static void main(String[] args) {

        //Adding some accounts to login

        Store.addAdminAccount("John Doe", 1234);
        Store.addAdminAccount("Jane Doe", 4321);


        //Adding Some items into stock

        Store.inventory.put(1111, new Item("Airpods Pro", 1111, "1st Generation"
                , 160));
        Store.inventory.put(1112, new Item("MacBook Pro", 1112, "Pro 15 Core i7 16GB 256GB"
                , 1500));
        Store.inventory.put(1113, new Item("Homepod", 1113, "2nd Generation"
                , 500));
        Store.inventory.put(1114, new Item("iPad Air", 1114, " 3rd Generation 3GB 32GB"
                , 600));
        Store.inventory.put(1114, new Item("iMac Pro", 1114, "  Core i9 8GB 2TB"
                , 600));

        //Adding Some Debit Cards

        Store.cards.put("123456789", new Card("Mastercard", "123456789", 2000));
        Store.cards.put("987654321", new Card("Visa", "987654321", 1000));

        //initializing our App

        OnlineStoreGUI onlineStoreGUI = new OnlineStoreGUI("Apple Store", "Park Avenue, NY");
        onlineStoreGUI.accessStore();
    }
}
