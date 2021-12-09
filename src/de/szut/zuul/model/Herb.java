package de.szut.zuul.model;

public class Herb extends Item{
    public Herb(String name, String description, double weight, boolean eatAble) {
        super(name, description, weight, eatAble);
    }

    public String getTyp(){
       return  "Eatable";
    }
}
