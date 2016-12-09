package com.youtube.sorcjc.calendarapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class SearchAccountActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_account);

        ImageButton btnSearchAccount = (ImageButton) findViewById(R.id.btnSearchAccount);
        btnSearchAccount.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btnSearchAccount:
                Intent intent = new Intent(this, ResultsActivity.class);
                startActivity(intent);
        }
    }
}
