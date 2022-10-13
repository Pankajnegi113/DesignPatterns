package com.java.design.pattern.main;

interface Item{
    int cost();
}
class Pizza implements Item{

    @Override
    public int cost() {
        return 250;
    }
}

class ExtraCheese implements Item{

    private Item item;

    ExtraCheese(Item item){
        this.item = item;
    }

    @Override
    public int cost() {
        return item.cost()+60;
    }
}

class ExtraVeggy implements Item{

    private Item item;

    ExtraVeggy(Item item){
        this.item = item;
    }

    @Override
    public int cost() {
        return item.cost()+80;
    }
}

class ExtraSauces implements Item{

    private Item item;

    ExtraSauces(Item item){
        this.item = item;
    }

    @Override
    public int cost() {
        return item.cost()+40;
    }
}

public class Decorator {

    public static void main(String[] args) {
        Pizza normalPizza = new Pizza();

        System.out.println("Normal Pizza Cost: "+normalPizza.cost());

        System.out.println("FarmHouse Pizza Cost: "+new ExtraVeggy(new ExtraCheese(new Pizza())).cost());

        System.out.println("Chilly Pizza Cost: "+new ExtraSauces(new ExtraVeggy(new ExtraCheese(new Pizza()))).cost());


    }


}
