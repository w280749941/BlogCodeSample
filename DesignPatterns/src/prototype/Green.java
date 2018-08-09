package prototype;

public class Green extends GoogleColor {

    Green(){
        this.colorName = "Green";
        this.colorCode = "#E8F5E9";
    }

    @Override
    void showColor() {
        System.out.println(this.colorName + " - " + this.colorCode);
    }
}
