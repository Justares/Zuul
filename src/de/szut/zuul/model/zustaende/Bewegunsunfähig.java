package de.szut.zuul.model.zustaende;

public class Bewegunsunfähig implements Gesundheitszustand {
    @Override
    public void heilen() {

    }

    @Override
    public void verletzt() {

    }

    @Override
    public void schwerVerletzt() {

    }

    @Override
    public String getHealth() {
        return "Bewegunsunfähig";
    }
}
