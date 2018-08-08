package decorator.base;

import decorator.FireArm;

public class AWM implements FireArm {

    private final String name = "AWM";
    private final String ammo = ".300";

    @Override
    public void fire() {
        System.out.println(String.format("Weapon %s is firing with the ammo type: %s", this.name, this.ammo));
    }
}