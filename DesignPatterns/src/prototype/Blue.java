package prototype;

public class Blue extends GoogleColor {

    Blue(){
        this.colorName = "Blue";
        this.colorCode = "#E3F2FD";
    }

    @Override
    void showColor() {
        System.out.println(this.colorName + " - " + this.colorCode);
    }
}
