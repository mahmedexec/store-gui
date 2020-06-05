public class Online extends Payment{
    private String accNo;
    private int pin;
    public Online(String accNo, int pin, double balance) {
        super(balance);
        this.setAccNo(accNo);
        this.setPin(pin);

    }

    public String getAccNo() {
        return accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
