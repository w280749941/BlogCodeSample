package command;

import java.util.Random;

public class AgingTest implements TestCommand {

    private final String name = "Aging Test";
    private static Random random = new Random();

    @Override
    public boolean executeTest() {
        int result = random.nextInt(2);
        return result > 0;
    }

    public String getName() {
        return name;
    }
}
