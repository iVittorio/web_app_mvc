package ru.innopolis.web.beans;

/**
 * Created by i.viktor on 28/11/2016.
 */
public class Lection {
    private int id;
    private String name;
    private String text;

    public Lection() {
    }

    public Lection(int id, String name, String text) {
        this.id = id;
        this.name = name;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
