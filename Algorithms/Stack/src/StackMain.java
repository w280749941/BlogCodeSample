public class StackMain {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        System.out.println("Empty: " + st.empty());
        st.push(3);
        System.out.println("Top: " + st.peek());
        st.push(2);
        System.out.println("Top: " + st.peek());
        System.out.println("Top: " + st.pop());
        System.out.println("Top: " + st.peek());

        Stack<Character> st2 = new Stack<>();
        System.out.println("Empty: " + st2.empty());
        st2.push('a');
        System.out.println("Top: " + st2.peek());
        st2.push('b');
        System.out.println("Top: " + st2.peek());
        st2.pop();
        System.out.println("Top: " + st2.peek());

        Stack<String> st3 = new Stack<>();
        System.out.println("Empty: " + st3.empty());
        st3.push("one string");
        System.out.println("Top: " + st3.peek());
        st3.push("another string");
        System.out.println("Top: " + st3.peek());
        st3.pop();
        System.out.println("Top: " + st3.peek());
    }
}
