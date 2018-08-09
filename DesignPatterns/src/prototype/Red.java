package prototype;

public class Red extends GoogleColor {

    Red(){
        this.colorName = "Red";
        this.colorCode = "#FFEBEE";
    }

    @Override
    void showColor() {
        System.out.println(this.colorName + " - " + this.colorCode);
    }
}
