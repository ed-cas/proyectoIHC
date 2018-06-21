package com.example.eduardo.proyectoihc.objects;

import java.io.Serializable;

public class fundation implements Serializable {
    private String title;
    private String description;
    private String ubicacion;


    public fundation(String title, String description, String ubicacion){
        this.title=title;
        this.description=description;
        this.ubicacion=ubicacion;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
}
