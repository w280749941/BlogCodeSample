package builder;

class Burger{

    private String bread;
    private String cheese;
    private String meat;
    private String vegetable;
    private String source;

    private Burger(BurgerBuilder builder){

        this.bread = builder.bread;

        this.cheese = builder.cheese;

        this.meat = builder.meat;

        this.vegetable = builder.vegetable;

        this.source = builder.source;

    }

    void showBurger(){
        System.out.println(this.bread + " " + this.cheese + " " + this.meat + " " + this.vegetable + " " + this.source);
    }

    static class BurgerBuilder{

        private String bread;
        private String cheese;
        private String meat;
        private String vegetable;
        private String source;

        BurgerBuilder(String bread, String meat){
            this.bread = bread;
            this.meat = meat;
        }



        public BurgerBuilder withCheese(String cheese){
            this.cheese = cheese;
            return this;
        }

        BurgerBuilder withMeat(String meat){
            this.meat = meat;
            return this;
        }

        BurgerBuilder withVegetable(String vegetable){
            this.vegetable = vegetable;
            return this;
        }

        public BurgerBuilder withBread(String bread){
            this.bread = bread;
            return this;
        }

        BurgerBuilder withSource(String source){
            this.source = source;
            return this;
        }

        Burger build(){
            return new Burger(this);
        }
    }
}

