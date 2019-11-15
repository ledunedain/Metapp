package com.example.metapp;

public class ObjectMetapp {
    String descripcion,date;

    public ObjectMetapp() {
    }

    public ObjectMetapp(String descripcion, String date) {
        this.descripcion = descripcion;
        this.date = date;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
