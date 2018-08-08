package abstractfactory.modifications;

public class ModFactory {

    public Mod createMod(Modification mod){
        Mod modOut = null;
        switch (mod){
            case Suppressor:
                modOut = new Suppressor();
                break;
            case Scope:
                modOut = new Scope();
                break;
            default:
                modOut = new Magazine();
                break;
        }
        return modOut;
    }
}
