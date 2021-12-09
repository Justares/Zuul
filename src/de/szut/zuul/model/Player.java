package de.szut.zuul.model;

import de.szut.zuul.model.zustaende.Gesundheitszustand;
import de.szut.zuul.model.zustaende.Verwundet;

import java.util.LinkedList;

public class Player {
    private Gesundheitszustand aktuellerZustand;

    public void setAktuellerZustand(Gesundheitszustand aktuellerZustand) {
        this.aktuellerZustand = aktuellerZustand;
    }



    public Player() {
        aktuellerZustand = new Verwundet(this);
    }

    private Room currentRoom;
    private double loadCapacity = 10;
    LinkedList<Item> inventar = new LinkedList<Item>();

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void goTo(Room newRoom) {
        currentRoom = newRoom;
    }

    private double calculateWeight() {
        double allItemInInvWeight = 0;
        for (int i = 0; i < inventar.size(); i++) {
            allItemInInvWeight += inventar.get(i).getWeight();
        }
        return allItemInInvWeight;

    }

    private boolean isTakePossible(Item item) {
        if (item.getWeight() <= loadCapacity - calculateWeight()) {
            return true;
        }
        return false;
    }

    public boolean takeItem(Item item) {
        if (isTakePossible(item)) {
            inventar.add(item);
            return true;
        }
        return false;
    }

    public Item dropItem(String name) {
        for (int i = 0; i < inventar.size(); i++) {
            if (inventar.get(i).getName().equalsIgnoreCase(name)) {
                currentRoom.putItem(inventar.get(i));
                return inventar.get(i);
            }
        }

        return null;
    }

    public void heilen(){
        aktuellerZustand.heilen();
    }

    public boolean eatItem(String name) {
        for (int i = 0; i < inventar.size(); i++) {
            if (inventar.get(i).getName().equalsIgnoreCase("Muffin")) {
                setLoadCapacity(loadCapacity+50);
                inventar.remove(i);

                System.out.println(showStatus());
                return true;
            }
            if(inventar.get(i).getTyp().equals("Eatable")){
                inventar.remove(i);
                heilen();
                System.out.println(showStatus());
                return true;
            }
        }

        return false;
    }


    public void setLoadCapacity(double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    public String showStatus() {
        return "Status of the player" + "\n" +
                "loadCapacity: " + loadCapacity + "\n" +
                "taken items: " + inventar + "\n" +
                "absorbed weight: " + calculateWeight() + "\n" +
                "Current State: " + aktuellerZustand.getHealth();
    }
}