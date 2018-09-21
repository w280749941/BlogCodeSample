import java.util.List;

public class TrieSolution {
    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.add("Hell");
        trie.add("Hello");
        trie.add("Helly");
        List<String> temp = trie.getBlurrySearchResult("Hell.");
        temp.forEach(System.out::println);
    }
}
