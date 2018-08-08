package abstractfactory.weapons;

import abstractfactory.modifications.Mod;

public interface FireArm {

    void fire();
    void addModification(Mod mod);
    void weaponStatus();
}
