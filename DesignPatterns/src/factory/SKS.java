package factory;

public class SKS implements FireArm {

    private final String name = "SKS";
    private final String ammo = "7.62";

    @Override
    public void fire() {
        System.out.println(String.format("Weapon %s is firing with the ammo type: %s", this.name, this.ammo));
    }
}
