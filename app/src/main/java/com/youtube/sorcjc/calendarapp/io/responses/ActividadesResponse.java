package com.youtube.sorcjc.calendarapp.io.responses;

/**
 * Created by Juarez on 11/12/2016.
 */
import com.google.gson.annotations.SerializedName;
import com.youtube.sorcjc.calendarapp.entidad.ActividadEN;

import java.util.ArrayList;

public class ActividadesResponse {
    @SerializedName("listaActividad")
    private ArrayList<ActividadEN> actividades;

    public ArrayList<ActividadEN> getActividades() {
        return actividades;
    }
}
