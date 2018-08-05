package observer.subscriber;

public interface ISubscriber {

    String getName();
    void update(String message);
}
