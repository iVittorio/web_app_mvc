package ru.innopolis.web.beans;

import javax.persistence.*;

/**
 * Created by i.viktor on 28/11/2016.
 */

@Entity
@Table(name = "LECTIONS")
public class Lection {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NAME", unique = true)
    private String name;

    @Column(name = "TEXT")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lection lection = (Lection) o;

        if (id != lection.id) return false;
        if (name != null ? !name.equals(lection.name) : lection.name != null) return false;
        return text != null ? text.equals(lection.text) : lection.text == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Lection{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
