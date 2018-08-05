package observer.subject;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import observer.subscriber.ISubscriber;

public class VideoChannel implements IPublisher {

    private String channelName;
    private List<Video> videos;
    private Hashtable<String, ISubscriber> subscribers;

    public VideoChannel(String channelName){
        this.channelName = channelName;
        this.videos = new ArrayList<>();
        this.subscribers = new Hashtable<>();
    }

    public void newVideo(Video video){
        String outMessage = String.format("%s published a new video: %s", this.channelName, video.getName());
        System.out.println(outMessage);
        this.videos.add(video);
        this.setState(video);
    }

    @Override
    public void attach(ISubscriber iSubscriber) {
        String outMessage = String.format("%s has a new user subscribed: %s", this.channelName, iSubscriber.getName());
        System.out.println(outMessage);
        if(!this.subscribers.containsKey(iSubscriber.getName()))
            this.subscribers.put(iSubscriber.getName(), iSubscriber);
    }

    @Override
    public void detach(ISubscriber iSubscriber) {
        String outMessage = String.format("%s has a user unsubscribed: %s", this.channelName, iSubscriber.getName());
        System.out.println(outMessage);
        this.subscribers.remove(iSubscriber.getName());
    }

    @Override
    public void setState(Object video) {
        Video newVideo = (Video) video;
        String messageBody = String.format("New Video from channel %s: Video: %s, Category: %s",
            this.channelName, newVideo.getName(), newVideo.getCategory());

        for (ISubscriber subscriber : this.subscribers.values()){
            subscriber.update(messageBody);
        }
    }

    @Override
    public String getState() {
        return String.valueOf(videos.size());
    }
}
