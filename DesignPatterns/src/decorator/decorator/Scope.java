package decorator.decorator;

import decorator.FireArm;
import decorator.WeaponDecorator;

public class Scope extends WeaponDecorator {

    private final String name = "Scope";

    public Scope(FireArm baseWeapon) {
        super(baseWeapon);
    }

    @Override
    public void fire() {
        super.baseWeapon.fire();
        System.out.println("Weapon firing with " + this.name);
    }
}
