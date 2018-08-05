package state;

class Employee {

    private String name;
    private IRole irole;

    Employee(String name, IRole irole) {
        this.name = name;
        this.irole = irole;
    }

    String getState(){
        return String.format("%s is a %s with salary $%d",
            this.name, irole.getTitle(), this.getSalary());
    }

    void doWork(){
        irole.doWork();
    }

    private int getSalary(){
        return irole.getSalary();
    }

    void setRole(IRole irole){
        this.irole = irole;
    }

    String getName(){
        return this.name;
    }
}
