public class Cash extends Payment{
    boolean onHand;

    public Cash(double balance, boolean onHand) {
        super(balance);
        this.onHand = onHand;
    }

    boolean canMake(int price,boolean onHand) {
        return (super.canMake(price) >=0) && onHand;
    }
}
