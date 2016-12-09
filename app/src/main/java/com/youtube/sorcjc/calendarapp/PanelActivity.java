package com.youtube.sorcjc.calendarapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PanelActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panel);

        Button btnShowActivity = (Button) findViewById(R.id.btnShowActivity);
        btnShowActivity.setOnClickListener(this);

        Button btnManageAccount = (Button) findViewById(R.id.btnManageAccount);
        btnManageAccount.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btnShowActivity:
                Intent historyIntent = new Intent(this, HistoryActivity.class);
                startActivity(historyIntent);
                break;

            case R.id.btnManageAccount:
                Intent manageIntent = new Intent(this, SearchAccountActivity.class);
                startActivity(manageIntent);
                break;
        }
    }
}
