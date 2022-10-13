package com.java.design.pattern.main;


class Burger{
    private String bread;
    private String onion;
    private String sauce;
    private String veggies;

    @Override
    public String toString() {
        return "Burger{" +
                "bread='" + bread + '\'' +
                ", onion='" + onion + '\'' +
                ", sauce='" + sauce + '\'' +
                ", veggies='" + veggies + '\'' +
                '}';
    }

    private Burger(){
    }
    static class Builder{
        private String bread;
        private String onion;
        private String sauce;
        private String veggies;

        public Builder setBread(String bread) {
            this.bread = bread;
            return this;
        }

        public Builder setOnion(String onion) {
            this.onion = onion;
            return this;
        }

        public Builder setSauce(String sauce) {
            this.sauce = sauce;
            return this;
        }

        public Builder setVeggies(String veggies) {
            this.veggies = veggies;
            return this;
        }

        public Burger build(){
            Burger burger = new Burger();
            burger.bread=this.bread;
            burger.onion=this.onion;
            burger.sauce=this.sauce;
            burger.veggies=this.veggies;
            return burger;
        }

    }
}



//for creating complex objects
//Some properties might be optional for one object while for other they might require it.
//So creating object in such way that we can choose which property we want to give to object and which not.
// Without Builder design pattern would be required to have multiple constructors for the same class
public class Builder {
    public static void main(String[] args) {
        Burger burger1 = new Burger.Builder().setBread("Brown").setOnion("yes").setSauce("chilly").build();
        Burger burger2 = new Burger.Builder().setBread("Brown").setSauce("tomato").build();
        Burger burger3 = new Burger.Builder().setBread("Brown").setVeggies("corn-spinach").build();
        System.out.println(burger1);
        System.out.println(burger2);
        System.out.println(burger3);

    }
}
