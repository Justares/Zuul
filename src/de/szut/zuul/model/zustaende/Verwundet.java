package de.szut.zuul.model.zustaende;

import de.szut.zuul.model.Player;

public class Verwundet implements Gesundheitszustand{
        private Player player;

    public Verwundet(Player player) {
        this.player = player;
    }

    @Override
    public void heilen() {
        player.setAktuellerZustand(new Gesund());
        System.out.println("Du wurdest geheilt");

    }

    @Override
    public void verletzt() {
        System.out.println("Du wurdest getroffen! & Bist jetzt Bewegungsunfähig");

    }

    @Override
    public void schwerVerletzt() {

    }

    @Override
    public String getHealth() {
        return "Verwundet";
    }
}
