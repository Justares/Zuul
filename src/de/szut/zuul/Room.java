package de.szut.zuul;

import java.util.HashMap;

/**
 * Class Room - a room in an adventure game.
 * <p>
 * This class is part of the "World of Zuul" application.
 * "World of Zuul" is a very simple, text based adventure game.
 * <p>
 * A "Room" represents one location in the scenery of the game.  It is
 * connected to other rooms via exits.  The exits are labelled north,
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */
public class Room {
    private String description;
    HashMap<String, Room> roomExit;
    HashMap<String, Item> itemList;


    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     *
     * @param description The room's description.
     */
    public Room(String description) {
        this.description = description;
        roomExit = new HashMap<>();
        itemList = new HashMap<>();
    }


    /**
     * Define the exits of this room.  Every direction either leads
     * to another room or is null (no exit there).
     */
    public void setExit(String direction, Room neighbour) {
        this.roomExit.put(direction, neighbour);
    }


    public Room getExit(String direction) {

        return roomExit.get(direction);
    }

    public String exitsToString() {
        String str = "";
        for (String direction : roomExit.keySet()) {
            str += direction + " ";
        }
        return str;
    }


    /**
     * @return The description of the room.
     */
    public String getDescription() {
        return description;
    }

    public String getLongDescription() {
        StringBuilder str = new StringBuilder();
        str.append("You are " + getDescription() + "\n");
        str.append("Exits: ");
        str.append(exitsToString() + "\n");
        if (itemList.size() == 0) {
            str.append("No Items in this Room");
        } else {
            str.append("Items in this room: \n");

            for (String key : itemList.keySet()) {
                str.append("- " + itemList.get(key).toString());
            }
        }

        String s = str.toString();
        return s;
    }

    public void putItem(Item newItem) {
        itemList.put(newItem.getName(), newItem);
    }

    public Item removeItem(String name){
        itemList.remove(name);

        return null;
    }

}
