package prototype;

abstract class GoogleColor implements Cloneable{

    protected String colorName;
    protected String colorCode;

    abstract void showColor();

    public GoogleColor clone(){
        GoogleColor clone = null;

        try {
            clone = (GoogleColor) super.clone();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        return clone;
    }
}
