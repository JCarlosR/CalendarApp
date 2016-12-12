package com.youtube.sorcjc.calendarapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.youtube.sorcjc.calendarapp.entidad.ActividadEN;
import com.youtube.sorcjc.calendarapp.io.CalendarioApiAdapter;
import com.youtube.sorcjc.calendarapp.io.responses.ActividadesResponse;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class HistoryActivity extends AppCompatActivity {

    private Context contexto;
    private ArrayList<ActividadEN> arrlstActividad;
    private AdapterActividad adptrActividad;
    private ListView lstvwActividad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        contexto = this;
        lstvwActividad = (ListView) findViewById(R.id.activity_clientes_lstvw_cliente);
        llenarActividades();
    }

    ProgressDialog mProgressDialog;
    public void llenarActividades(){
        Call<ActividadesResponse> call = CalendarioApiAdapter.getApiService(contexto).getActividadesResponse();
        Log.d("Test/Main", "Se lanzó el llamado al WS");
        mProgressDialog = ProgressDialog.show(contexto, "Sincronizar", "Actualizando datos.", true);
        mProgressDialog.setMessage(Html.fromHtml("<font color='white'>" + "Sincronizando..." + "</font>"));

        // Async callback
        //respondido = false;
        call.enqueue(new Callback<ActividadesResponse>() {

            @Override
            public void onResponse(Response<ActividadesResponse> response, Retrofit retrofit) {
                //respondido = true;
                Log.d("Test/Main", "Se recibió una respuesta");


                if (response != null) {
                    ArrayList<ActividadEN> actividades = response.body().getActividades();
                    Log.d("Test/Main", "Respuesta => " + actividades.size());
                    Log.d("Test/Main", "Respuesta => " + actividades.get(0).getDescripcion());
                    adptrActividad = new AdapterActividad(contexto,actividades);
                    lstvwActividad.setAdapter(adptrActividad);
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


    public class AdapterActividad extends ArrayAdapter<ActividadEN> {
        private Context contextoInterno;
        private ArrayList<ActividadEN> datos;
        private ImageView imgvwFoto;
        private TextView txtvwNombre, txtvwDescripcion, txtvwFecha;
        private LinearLayout linearActividad;

        public AdapterActividad(Context context, ArrayList<ActividadEN> datos) {
            super(context,0, datos);
            this.contextoInterno = context;
            this.datos = datos;
        }

        @Override
        public View getView(final int position, View view, ViewGroup parent) {

            LayoutInflater inflater = LayoutInflater.from(contextoInterno);
            View item = inflater.inflate(R.layout.item_targetactividad, null);

            try {

            imgvwFoto = (ImageView)item.findViewById(R.id.item_fotoempresa_imgvw_foto);
            txtvwNombre = (TextView)item.findViewById(R.id.item_txtvw_nombre_actividad);
            txtvwDescripcion = (TextView)item.findViewById(R.id.item_txtvw_descripcion_actividad);
            txtvwFecha = (TextView) item.findViewById(R.id.item_txtvw_fecha_actividad);
            linearActividad = (LinearLayout) item.findViewById(R.id.item_actividad);

            //extraemos el drawable en un bitmap
            Drawable originalDrawable = getResources().getDrawable(R.drawable.actividad);
            Bitmap originalBitmap = ((BitmapDrawable) originalDrawable).getBitmap();

            //creamos el drawable redondeado
            RoundedBitmapDrawable roundedDrawable =
                    RoundedBitmapDrawableFactory.create(getResources(), originalBitmap);

            //asignamos el CornerRadius
            roundedDrawable.setCornerRadius(originalBitmap.getHeight());
            Log.d("",String.valueOf(originalBitmap.getHeight()));
            imgvwFoto.setImageDrawable(roundedDrawable);

            txtvwNombre.setText(datos.get(position).getNombre());
            txtvwDescripcion.setText(datos.get(position).getDescripcion());
            txtvwFecha.setText(datos.get(position).getFecha());

            linearActividad.setClickable(true);
            /*linearActividad.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(contexto, "Seleccionado " + datos.get(position).getCliente().getEmail() + " | "+datos.get(position).getCliente().getCargoEmpresa() , Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(contexto, DatosCliente.class);
                    intent.putExtra("CLIENTE",datos.get(position));
                    startActivity(intent);
                }
            });*/
        }catch (Exception ex){
                Log.d("Test/Main", "Paso esto: "+ex.toString());
        }
            return item;
        }
    }

}
