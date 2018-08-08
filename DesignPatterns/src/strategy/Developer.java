package strategy;


public class Developer implements IRole{

    private final int salary;
    private final String title;

    Developer(String title, int salary) {
        this.salary = salary;
        this.title = title;
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
        System.out.println(this.title + " is coding");
    }
}
