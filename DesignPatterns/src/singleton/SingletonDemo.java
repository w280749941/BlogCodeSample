package singleton;

public class SingletonDemo {

    public static void main(String[] args) {

        Singleton singleton1 = Singleton.getInstance();

        Singleton singleton2 = Singleton.getInstance();

        SingletonThreadSafe singletonThreadSafe1 = SingletonThreadSafe.getInstance();

        SingletonThreadSafe singletonThreadSafe2 = SingletonThreadSafe.getInstance();

        System.out.println(String.format("singleton1 == singleton2 : %s", singleton1 == singleton2));
        System.out.println(String.format("singletonThreadSafe1 == singletonThreadSafe2 : %s", singletonThreadSafe1 == singletonThreadSafe2));
    }
}
