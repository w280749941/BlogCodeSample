package abstractfactory.modifications;

public class Suppressor implements Mod{

    private final String name = "Suppressor";

    @Override
    public void showAttachment() {
        System.out.print(this.name + " ");
    }
}
