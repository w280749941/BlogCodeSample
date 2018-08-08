package abstractfactory.modifications;

public class Scope implements Mod{

    private final String name = "Scope";

    @Override
    public void showAttachment() {
        System.out.print(this.name + " ");
    }
}
