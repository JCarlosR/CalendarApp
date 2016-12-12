package com.youtube.sorcjc.calendarapp.io.responses;

/**
 * Created by Juarez on 11/12/2016.
 */
import com.google.gson.annotations.SerializedName;
import com.youtube.sorcjc.calendarapp.entidad.CuentaEN;
import com.youtube.sorcjc.calendarapp.entidad.UsuarioEN;

import java.util.ArrayList;

public class CuentasResponse {
    @SerializedName("listaCuenta")
    private ArrayList<CuentaEN> cuentas;
    public ArrayList<CuentaEN> getCuentas() { return cuentas; }

    @SerializedName("usuario")
    private UsuarioEN usuario;
    public UsuarioEN getUsuario() { return usuario; }
}
