package com.youtube.sorcjc.calendarapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.youtube.sorcjc.calendarapp.entidad.ActividadEN;
import com.youtube.sorcjc.calendarapp.entidad.CuentaEN;
import com.youtube.sorcjc.calendarapp.entidad.UsuarioEN;
import com.youtube.sorcjc.calendarapp.io.CalendarioApiAdapter;
import com.youtube.sorcjc.calendarapp.io.responses.ActividadesResponse;
import com.youtube.sorcjc.calendarapp.io.responses.CuentasResponse;

import java.util.ArrayList;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class ResultsActivity extends AppCompatActivity {

    private Context contexto;
    private TableLayout tablaCuentas;
    private EditText dni;
    private EditText nombreCompleto;
    private String dniSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        contexto = this;
        tablaCuentas = (TableLayout) findViewById(R.id.activity_results_tablelayout);
        dni = (EditText) findViewById(R.id.etIdentityCard); 
        nombreCompleto = (EditText)  findViewById(R.id.etFullName);
        dniSearch = getIntent().getExtras().getString("dni");
        Log.d("Test/Main", "Mi dni: "+dniSearch);
        llenarCuentas();
    }

    ProgressDialog mProgressDialog;
    public void llenarCuentas(){
        Call<CuentasResponse> call = CalendarioApiAdapter.getApiService(contexto).getCuentassResponse(dniSearch);
        Log.d("Test/Main", "Se lanzó el llamado al WS");
        mProgressDialog = ProgressDialog.show(contexto, "Sincronizar", "Actualizando datos.", true);
        mProgressDialog.setMessage(Html.fromHtml("<font color='white'>" + "Sincronizando..." + "</font>"));

        // Async callback
        //respondido = false;
        call.enqueue(new Callback<CuentasResponse>() {

            @Override
            public void onResponse(Response<CuentasResponse> response, Retrofit retrofit) {
                //respondido = true;
                Log.d("Test/Main", "Se recibió una respuesta");
                TextView c1,c2,c3;

                if (response != null) {
                    try
                    {
                    UsuarioEN usuario = response.body().getUsuario();
                    ArrayList<CuentaEN> cuentas = response.body().getCuentas();
                        Log.d("Test/Main", "Respuesta => " + cuentas.size());
                    Log.d("Test/Main", "Respuesta => " + cuentas.get(0).getYear());
                    dni.setText(usuario.getDni());
                    nombreCompleto.setText(usuario.getNombre() + " " + usuario.getPaterno() + " " + usuario.getMaterno());


                    for (CuentaEN cuenta :
                            cuentas) {
                        TableRow filaCuentas = new TableRow(contexto);
                        TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT);
                        filaCuentas.setLayoutParams(lp);
                        c1 = new TextView(contexto);
                        c2 = new TextView(contexto);
                        c3 = new TextView(contexto);
                        c1.setText(cuenta.getYear());
                        c2.setText(String.valueOf(cuenta.getDebe()));
                        c3.setText(String.valueOf(cuenta.getPayment()));
                        c2.setGravity(Gravity.CENTER_HORIZONTAL);
                        filaCuentas.addView(c1);
                        filaCuentas.addView(c2);
                        filaCuentas.addView(c3);
                        tablaCuentas.addView(filaCuentas);
                        Log.d("Test/Main", "Estuve => " + cuenta.getYear());
                    }
                }
                    catch(Exception ex){
                        Toast.makeText(contexto, "Dni no registrado", Toast.LENGTH_SHORT).show();
                    }

                }
                if (mProgressDialog!= null)
                    mProgressDialog.dismiss();

            }

            @Override
            public void onFailure(Throwable t) {
                //respondido = true;
                if (mProgressDialog!= null)
                    mProgressDialog.dismiss();
                //answer = false;
                Log.d("Test/Main", "Se recibió una respuesta errada");
                Toast.makeText(contexto, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }

        });
    }
}
