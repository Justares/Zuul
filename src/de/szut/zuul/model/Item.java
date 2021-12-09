package de.szut.zuul.model;

public class Item {
    private String name;
    private String description;
    private double weight;
    private boolean eatAble;

    public Item(String name, String description, double weight, boolean eatAble) {
        this.name = name;
        this.description = description;
        this.weight = weight;
        this.eatAble = eatAble;
    }
    public String getTyp(){
        return "Item";
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString(){
        return  this.name + ", " + this.description + ", " + this.weight + "kg";
    }

    public String getName() {
        return name;
    }
}
