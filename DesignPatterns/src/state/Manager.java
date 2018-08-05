package state;

import java.util.List;
import java.util.Random;

public class Manager implements IRole {

    private final int salary;
    private final String title;
    private final List<Employee> subordinates;

    Manager(String title, int salary, List<Employee> subordinates) {
        this.salary = salary;
        this.title = title;
        this.subordinates = subordinates;
    }

    @Override
    public int getSalary() {
        return this.salary;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public void doWork() {
        Random rand = new Random();
        int index = rand.nextInt(this.subordinates.size());
        Employee selectedSubordinate = subordinates.get(index);
        System.out.println(this.title + " is assigning work to " + selectedSubordinate.getName());
        selectedSubordinate.doWork();
    }
}
