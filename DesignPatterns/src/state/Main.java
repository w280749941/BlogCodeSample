package state;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        IRole softwareDeveloper = new Developer("Software Developer", 20000);
        IRole mobileDeveloper = new Developer("Mobile Developer", 20000);
        IRole softwareArchitect = new Architect("Software Architect", 30000);
        Employee employee1 = new Employee("Liam", softwareDeveloper);
        Employee employee2 = new Employee("William", mobileDeveloper);
        Employee employee3 = new Employee("Noah", softwareArchitect);
        List<Employee> employees = Arrays.asList(employee1, employee2, employee3);

        for(Employee employee : employees){
            System.out.println(employee.getState());
            employee.doWork();
        }


        // Promotion comes
        System.out.println("\nPromoting Liam from software developer to product manager\n");

        IRole productManager = new Manager("Product Manager", 25000,
            employees.subList(1, employees.size()));

        employee1.setRole(productManager);

        for(Employee employee : employees){
            System.out.println(employee.getState());
            employee.doWork();
        }
    }
}
