package command;

import java.util.ArrayList;
import java.util.List;

public class ProductB {

    private String name = "Product B";
    private List<TestCommand> tests = new ArrayList<>();


    public void addTest(TestCommand testCommand){
        tests.add(testCommand);
    }

    public void startTest(){
        System.out.printf("%s starting test\n", this.name);
        for(TestCommand testCommand : tests){
            boolean pass = testCommand.executeTest();
            System.out.printf("%s %s\n",testCommand.getName(), pass ? "Pass" : "Failed");
        }
    }

    public String getName() {
        return name;
    }
}
