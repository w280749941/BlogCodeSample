package observer.subscriber;

public class User implements ISubscriber {

    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void update(String message) {
        String outMessage = String.format("%s received new notification: %s", this.name, message);
        System.out.println(outMessage);
    }
}
