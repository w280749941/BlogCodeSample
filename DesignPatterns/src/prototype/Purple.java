package prototype;

public class Purple extends GoogleColor{

    Purple(){
        this.colorName = "Purple";
        this.colorCode = "#F3E5F5";
    }

    @Override
    void showColor() {
        System.out.println(this.colorName + " - " + this.colorCode);
    }
}
