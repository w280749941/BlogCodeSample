package command;

public class CommandDemo {

    public static void main(String[] args) {

        TestCommand agingTest = new AgingTest();
        TestCommand waterTest = new WaterTest();
        TestCommand fireTest = new FireTest();

        ProductA productA = new ProductA();
        productA.addTest(agingTest);
        productA.startTest();

        ProductB productB = new ProductB();
        productB.addTest(waterTest);
        productB.addTest(fireTest);
        productB.startTest();
    }
}
