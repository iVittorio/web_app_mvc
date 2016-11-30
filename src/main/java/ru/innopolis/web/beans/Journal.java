package ru.innopolis.web.beans;

/**
 * Created by i.viktor on 28/11/2016.
 */
public class Journal {
    private int id_student;
    private String lectionName;

    public Journal() {
    }

    public Journal(int id_student, String lectionName) {
        this.id_student = id_student;
        this.lectionName = lectionName;
    }

    public int getId_student() {
        return id_student;
    }

    public void setId_student(int id_student) {
        this.id_student = id_student;
    }

    public String getLectionName() {
        return lectionName;
    }

    public void setLectionName(String lectionName) {
        this.lectionName = lectionName;
    }
}
