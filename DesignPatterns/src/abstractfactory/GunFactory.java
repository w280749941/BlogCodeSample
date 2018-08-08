package abstractfactory;

import abstractfactory.modifications.Mod;
import abstractfactory.modifications.ModFactory;
import abstractfactory.modifications.Modification;
import abstractfactory.weapons.FireArm;
import abstractfactory.weapons.FireArmFactory;
import abstractfactory.weapons.Weapon;

public class GunFactory extends AbstractFactory{

    private final FireArmFactory fireArmFactory;
    private final ModFactory modFactory;

    public GunFactory(FireArmFactory fireArmFactory,
        ModFactory modFactory) {
        this.fireArmFactory = fireArmFactory;
        this.modFactory = modFactory;
    }

    @Override
    Mod getModification(Modification modification) {
        return this.modFactory.createMod(modification);
    }

    @Override
    FireArm getWeapon(Weapon weapon) {
        return this.fireArmFactory.createWeapon(weapon);
    }
}
