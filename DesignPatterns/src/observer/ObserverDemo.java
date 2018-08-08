package observer;

import java.util.ArrayList;
import java.util.List;
import observer.subject.IPublisher;
import observer.subject.Video;
import observer.subject.VideoChannel;
import observer.subscriber.User;

public class ObserverDemo {

    private List<IPublisher> iPublishers;
    private List<User> users;

    private ObserverDemo() {
        iPublishers = new ArrayList<>();
        users = new ArrayList<>();
    }

    private void addChannel(IPublisher publisher){
        this.iPublishers.add(publisher);
    }
    private void removeChannel(IPublisher publisher){
        this.iPublishers.remove(publisher);
    }

    private void addUser(User user){
        this.users.add(user);
    }
    private void removeUser(User user){
        this.users.remove(user);
    }

    public static void main(String[] args) {
        System.out.println("Program started");
        VideoChannel videoChannel = new VideoChannel("CoolTv");
        User user1 = new User("Cool_user1");
        User user2 = new User("Cool_user2");
        User user3 = new User("Cool_user3");
        ObserverDemo main = new ObserverDemo();
        main.addChannel(videoChannel);
        main.addUser(user1);
        main.addUser(user2);
        main.addUser(user3);

        Video video1 = new Video("<Avengers 1>", "Marvel");
        Video video2 = new Video("<Avengers 2>", "Marvel");
        Video video3 = new Video("<Super Man>", "DC");
        Video video4 = new Video("<Bat Man>", "DC");
        videoChannel.newVideo(video1);
        videoChannel.attach(user1);
        videoChannel.newVideo(video2);
        videoChannel.attach(user2);
        videoChannel.newVideo(video3);
        videoChannel.detach(user1);
        videoChannel.attach(user3);
        videoChannel.newVideo(video4);
    }
}
