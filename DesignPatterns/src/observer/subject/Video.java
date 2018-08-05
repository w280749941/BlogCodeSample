package observer.subject;

public class Video {

    private String Name;
    private String Category;

    public Video(String name, String category) {
        Name = name;
        Category = category;
    }

    String getName() {
        return Name;
    }

    String getCategory() {
        return Category;
    }
}
