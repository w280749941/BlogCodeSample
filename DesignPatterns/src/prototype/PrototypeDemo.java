package prototype;

public class PrototypeDemo {

    public static void main(String[] args) {

        GoogleColor blue = ColorBank.getColor("Blue");
        GoogleColor green = ColorBank.getColor("Green");
        GoogleColor purple = ColorBank.getColor("Purple");
        GoogleColor red = ColorBank.getColor("Red");
        GoogleColor yellow1 = ColorBank.getColor("Yellow");
        GoogleColor yellow2 = ColorBank.getColor("Yellow");

        System.out.printf("yellow1 == yellow2 : %s\n", yellow1 == yellow2);
        blue.showColor();
        green.showColor();
        purple.showColor();
        red.showColor();
        yellow1.showColor();
    }
}
