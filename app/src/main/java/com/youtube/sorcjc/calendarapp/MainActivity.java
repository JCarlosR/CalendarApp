package com.youtube.sorcjc.calendarapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnConfirmDate = (Button) findViewById(R.id.btnConfirmDate);
        btnConfirmDate.setOnClickListener(this);

        SimpleDateFormat sdf = new SimpleDateFormat(getString(R.string.date_format), Locale.US);
        String currentDate = sdf.format(new Date());
        ((EditText) findViewById(R.id.etCurrentDate)).setText(currentDate);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btnConfirmDate:
                Intent intent = new Intent(this, PanelActivity.class);
                startActivity(intent);
                break;
        }
    }
}
