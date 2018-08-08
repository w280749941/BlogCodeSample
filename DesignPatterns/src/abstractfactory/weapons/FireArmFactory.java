package abstractfactory.weapons;

public class FireArmFactory {

    public FireArm createWeapon(Weapon weapon){
        FireArm weaponOut = null;
        switch (weapon){
            case AWM:
                weaponOut = new AWM();
                break;
            case AK47:
                weaponOut = new AK();
                break;
            case SKS:
                weaponOut = new SKS();
                break;
            default:
                weaponOut = new CrossBow();
                break;
        }
        return weaponOut;
    }
}
