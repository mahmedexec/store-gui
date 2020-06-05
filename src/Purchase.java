abstract class Payment {
    double balance;

    public Payment(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    double checkBalance() {
        return getBalance();
    }

    double canMake(int price) {
        return balance-=price;

    }
}

