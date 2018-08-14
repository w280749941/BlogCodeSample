package proxy;

public class ProxyDemo {

    public static void main(String[] args) {
        Artist singerAgent = new Agent(new Singer("Mike", 10000));

        int offer = 10001;
        int offer2 = 20000;
        System.out.printf("Offer 1: %d, result: %s\n", offer, singerAgent.acceptEndorsementPrice(offer));
        System.out.printf("Offer 2: %d, result: %s\n", offer2, singerAgent.acceptEndorsementPrice(offer2));
    }
}
