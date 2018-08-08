package abstractfactory.weapons;

import abstractfactory.modifications.Mod;
import java.util.ArrayList;
import java.util.List;

public class AK implements FireArm {

    private final String name = "AK47";
    private final String ammo = "7.62";
    private final List<Mod> mods = new ArrayList<>();

    @Override
    public void fire() {
        System.out.println(String.format("Weapon %s is firing with the ammo type: %s", this.name, this.ammo));
    }

    @Override
    public void addModification(Mod mod){
        this.mods.add(mod);
    }

    @Override
    public void weaponStatus() {
        if(mods.size() == 0)
            return;
        System.out.print(String.format("Weapon %s is equip with:", this.name));
        for(Mod mod : mods){
            mod.showAttachment();
        }
        System.out.println();
    }
}
