package de.szut.zuul;

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
