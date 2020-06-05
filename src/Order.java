public class Order {

    Customer customer;
    Item item;

    public Order(Item item,Customer customer) {

        this.customer = customer;
        this.item = item;
    }

    @Override
    public String toString() {
        return "------------------------------------------------\n"+ "Customer Details: \n"+this.customer+ "\n\nOrder details: \n"+ this.item
                +"------------------------------------------------\n";
    }
}
