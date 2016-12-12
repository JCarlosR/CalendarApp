package com.youtube.sorcjc.calendarapp.entidad;

/**
 * Created by Juarez on 11/12/2016.
 */
import java.io.Serializable;

public class UsuarioEN implements Serializable{

    private Integer idUsuario;
    private String nombre;
    private String paterno;
    private String materno;
    private String dni;

    public UsuarioEN() {
        setIdUsuario(0);
        setNombre("");
        setPaterno("");
        setMaterno("");
        setDni("");
    }

    public UsuarioEN(Integer idUsuario, String nombre, String paterno, String materno, String dni) {
        this.setIdUsuario(idUsuario);
        this.setNombre(nombre);
        this.setPaterno(paterno);
        this.setMaterno(materno);
        this.setDni(dni);
    }


    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}
