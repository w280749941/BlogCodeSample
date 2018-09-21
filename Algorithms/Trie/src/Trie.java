import java.util.ArrayList;
import java.util.List;

public class Trie {

    private ListNode root;
    private int size;

    public Trie(){
        this.root = new ListNode();
    }

    /** Return number of words contained */
    public int size(){
        return this.size;
    }

    /** Return the root of current Trie */
    public ListNode getRoot(){
        return this.root;
    }

    /** Return whether current Trie contains a word */
    public boolean contains(String word){
        ListNode node = this.getNodeContainsPrefix(word);
        return node != null && node.isWord;
    }

    /** Add a word to current Trie */
    public void add(String word){
        if(word == null) return;
        ListNode node = this.root;

        // For each letter, if current node doesn't have a path
        // Create a new node. and move pointer to that node.
        for(int i=0; i<word.length(); i++){
            char letter = Character.toLowerCase(word.charAt(i));
            if(node.next[letter - 'a'] == null)
                node.next[letter - 'a'] = new ListNode();
            node = node.next[letter - 'a'];
        }

        // If it's not a word, then set it to a word.
        if(!node.isWord){
            node.isWord = true;
            size++;
        }
    }

    /** Return whether current Trie contains a prefix */
    public boolean containsPrefix(String word){
        return this.getNodeContainsPrefix(word) != null;
    }

    private ListNode getNodeContainsPrefix(String word){
        if(word == null) return null;
        ListNode node = this.root;

        // If current node doesn't contains a path to a letter return null
        // Otherwise move pointer to next node.
        for(int i=0; i<word.length(); i++){
            char letter = Character.toLowerCase(word.charAt(i));
            if(node.next[letter - 'a'] == null)
                return null;
            node = node.next[letter - 'a'];
        }
        return node;
    }

    /** A blurry search with '.' replace any letter
     *  Only return true if there is a word with the same length. */
    public boolean blurrySearch(String word){
        return this.blurrySearch(this.root, word, 0);
    }

    private boolean blurrySearch(ListNode root, String word, int index) {
        if(word == null) return false;

        if(index == word.length() && root.isWord)
            return true;

        ListNode node = root;
        for(int i=index; i<word.length(); i++){
            char letter = Character.toLowerCase(word.charAt(i));
            if(letter != '.'){
                if(node.next[letter - 'a'] == null)
                    return false;
                node = node.next[letter - 'a'];
            } else{
                for(int j=0; j<node.next.length; j++){
                    if(node.next[j] != null
                        && blurrySearch(node.next[j], word, i+1)){
                        return true;
                    }
                }
            }
        }
        return node.isWord;
    }

    /** Return List of Strings are similar to target word */
    public List<String> getBlurrySearchResult(String word){
        if(word == null) return null;
        List<String> result = new ArrayList<>();
        this.getBlurrySearchResult(this.root, word, 0, result, "");
        return result;
    }

    private void getBlurrySearchResult(ListNode root, String word, int index, List<String> lt, String s) {

        if(index == word.length() && root.isWord){
            lt.add(s);
            return;
        }

        ListNode node = root;
        StringBuilder sb = new StringBuilder(s);
        for(int i=index; i<word.length(); i++){
            char letter = Character.toLowerCase(word.charAt(i));

            // If the path to a node is not '.', add it and move pointer to next.
            if(letter != '.'){
                if(node.next[letter - 'a'] == null)
                    return;
                sb.append(letter);
                node = node.next[letter - 'a'];
            } else{
                // If current path is a '.', try out all words.
                for(int j=0; j<node.next.length; j++)
                    if(node.next[j] != null)
                        getBlurrySearchResult(node.next[j], word, i+1, lt, sb.toString() + (char)(j+'a'));

            }
        }
        if(node.isWord && s.length() == word.length())
            lt.add(sb.toString());
    }
}
