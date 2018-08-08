package abstractfactory;


import abstractfactory.modifications.ModFactory;
import abstractfactory.modifications.Modification;
import abstractfactory.weapons.FireArm;
import abstractfactory.weapons.FireArmFactory;
import abstractfactory.weapons.Weapon;

public class AbstractFactoryDemo {

    public static void main(String[] args) {

        GunFactory factory = new GunFactory(new FireArmFactory(), new ModFactory());

        FireArm fireArm = factory.getWeapon(Weapon.AK47);
        fireArm.fire();
        fireArm.weaponStatus();

        fireArm.addModification(factory.getModification(Modification.Scope));
        fireArm.weaponStatus();

        fireArm.addModification(factory.getModification(Modification.Magazine));
        fireArm.weaponStatus();
    }
}
