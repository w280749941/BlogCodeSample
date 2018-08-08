package decorator;

public abstract class WeaponDecorator implements FireArm{

    protected FireArm baseWeapon;

    public WeaponDecorator(FireArm baseWeapon){
        this.baseWeapon = baseWeapon;
    }
}
