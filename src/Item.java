public class Item {
    private String name;
    private int iD;
    private String description;
    private int price;

    public Item(String name, int iD, String description, int price) {
        this.name = name;
        this.iD = iD;
        this.description = description;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Name: "+name+"\n"+"ID:"+iD+"\n"+"Description:"+description+"\n"+"Price:"+price+"\n";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
