package de.szut.zuul.model.zustaende;

public interface Gesundheitszustand {
    public void heilen();
    public void verletzt();
    public void schwerVerletzt();

    public String getHealth();
}
