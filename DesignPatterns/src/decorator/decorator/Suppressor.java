package decorator.decorator;

import decorator.FireArm;
import decorator.WeaponDecorator;

public class Suppressor extends WeaponDecorator {

    private final String name = "Suppressor";

    public Suppressor(FireArm baseWeapon) {
        super(baseWeapon);
    }

    @Override
    public void fire() {
        super.baseWeapon.fire();
        System.out.println("Weapon firing with " + this.name);
    }
}
