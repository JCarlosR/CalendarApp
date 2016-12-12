package com.youtube.sorcjc.calendarapp.entidad;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Juarez on 11/12/2016.
 */

public class ActividadEN implements Serializable {
    private Integer idActividad;
    private String nombre;
    private String descripcion;
    private String fecha;

    public ActividadEN() {
        this.idActividad = 0;
        this.nombre = "";
        this.descripcion = "";
        this.fecha = "";
    }

    public ActividadEN(Integer idActividad, String nombre, String descripcion, String fecha) {
        this.idActividad = idActividad;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public Integer getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(Integer idActividad) {
        this.idActividad = idActividad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
