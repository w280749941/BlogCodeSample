package proxy;

public class Singer implements Artist {

    private String name;
    private int price;

    public Singer(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int getPrice(){
        return this.price;
    }

    @Override
    public boolean acceptEndorsementPrice(int offer) {
        return offer > this.price;
    }
}
