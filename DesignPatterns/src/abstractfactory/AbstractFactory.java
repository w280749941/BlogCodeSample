package abstractfactory;

import abstractfactory.modifications.Mod;
import abstractfactory.modifications.Modification;
import abstractfactory.weapons.FireArm;
import abstractfactory.weapons.Weapon;

public abstract class AbstractFactory {

    abstract Mod getModification(Modification modification);
    abstract FireArm getWeapon(Weapon weapon);
}
