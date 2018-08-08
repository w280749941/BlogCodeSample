package decorator.decorator;

import decorator.FireArm;
import decorator.WeaponDecorator;

public class Magazine extends WeaponDecorator {

    private final String name = "Magazine";

    public Magazine(FireArm baseWeapon) {
        super(baseWeapon);
    }

    @Override
    public void fire() {
        super.baseWeapon.fire();
        System.out.println("Weapon firing with " + this.name);
    }
}
