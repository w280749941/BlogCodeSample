package builder;

public class BuilderDemo {

    public static void main(String []args){

        Burger burger = new Burger.BurgerBuilder("Italian", "Beef")
                                .withVegetable("Tomato")
                                .withSource("Mayors")
                                .withMeat("Angus")
                                .build();

        burger.showBurger();
    }
}
