package observer.subject;

import observer.subscriber.ISubscriber;

public interface IPublisher {

    void attach(ISubscriber iSubscriber);
    void detach(ISubscriber iSubscriber);
    void setState(Object object);
    String getState();
}
