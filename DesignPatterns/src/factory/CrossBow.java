package factory;

public class CrossBow implements FireArm{

    private final String name = "CrossBow";
    private final String ammo = "bolt";

    @Override
    public void fire() {
        System.out.println(String.format("Weapon %s is firing with the ammo type: %s", this.name, this.ammo));
    }
}
