package factory;

public class FactoryDemo {

    public static void main(String[] args) {
        FireArmFactory fireArmFactory = new FireArmFactory();

        FireArm weapon1 = fireArmFactory.createWeapon(Weapon.AK47);
        weapon1.fire();

        FireArm weapon2 = fireArmFactory.createWeapon(Weapon.AWM);
        weapon2.fire();

        FireArm weapon3 = fireArmFactory.createWeapon(Weapon.SKS);
        weapon3.fire();

        FireArm weapon4 = fireArmFactory.createWeapon(Weapon.Other);
        weapon4.fire();

    }

}
