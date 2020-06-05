public class Card extends Payment{
    private String type;
    private String number;


    static boolean swipeCard(String type, String number, double balance,int price){
        Card card = new Card(type,number,balance);
        return card.canMake(price) >= 0;
    }


    public Card(String type, String number,double balance) {
        super(balance);
        this.type = type;
        this.number = number;
    }



    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }


    public void setBalance(double balance) {
        this.balance = balance;
    }
}
