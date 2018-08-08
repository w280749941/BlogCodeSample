package abstractfactory.modifications;

public class Magazine implements Mod{

    private final String name = "Magazine";

    @Override
    public void showAttachment() {
        System.out.print(this.name + " ");
    }
}
