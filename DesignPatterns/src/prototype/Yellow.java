package prototype;

public class Yellow extends GoogleColor{

    Yellow(){
        this.colorName = "Yellow";
        this.colorCode = "#FFFDE7";
    }

    @Override
    void showColor() {
        System.out.println(this.colorName + " - " + this.colorCode);
    }
}
