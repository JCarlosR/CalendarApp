package com.youtube.sorcjc.calendarapp.io;

import com.youtube.sorcjc.calendarapp.io.responses.ActividadesResponse;
import com.youtube.sorcjc.calendarapp.io.responses.CuentasResponse;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by Juarez on 11/12/2016.
 */

public interface CalendarioApiService {
    // http://redemnorte.pe/wslyrics/login.php?user=user&pass=password
    @GET("Actividad.svc/go")
    Call<ActividadesResponse> getActividadesResponse();

    @GET("Cuentas.svc/go")
    Call<CuentasResponse> getCuentassResponse(@Query("dni") String dni);

}
