package decorator;

import decorator.base.AK;
import decorator.decorator.Magazine;
import decorator.decorator.Scope;
import decorator.decorator.Suppressor;

public class DecoratorDemo {

    public static void main(String[] args) {

        System.out.println("Base weapon firing");
        FireArm fireArm = new AK();
        fireArm.fire();
        System.out.println();

        System.out.println("Scope firing");
        fireArm = new Scope(fireArm);
        fireArm.fire();
        System.out.println();

        System.out.println("Suppressor firing");
        fireArm = new Suppressor(fireArm);
        fireArm.fire();
        System.out.println();

        System.out.println("Magazine firing");
        fireArm = new Magazine(fireArm);
        fireArm.fire();
        System.out.println();
    }
}
