package com.example.eduardo.proyectoihc.objects;

import android.os.Parcelable;

import java.io.Serializable;

public class fundation implements Serializable {
    private String title;
    private String description;
    private String ubicacion;
    private String type;
    private String telephone;
    private String direction;


    public fundation(String title, String description, String ubicacion, String telephone, String type, String direction){
        this.title=title;
        this.description=description;
        this.ubicacion=ubicacion;
        this.telephone=telephone;
        this.type=type;
        this.direction=direction;
    }

    public fundation(){
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTelephone(String telephone){
        this.telephone=telephone;
    }

    public String getTelephone(){
        return this.telephone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType(){
        return type;
    }

    public void setType(String type){
        this.type=type;
    }

    public void setDirection(String direction){
        this.direction=direction;
    }

    public String getDirection() {
        return direction;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
}
