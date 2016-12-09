package com.youtube.sorcjc.calendarapp;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class PanelActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panel);

        Button btnShowActivity = (Button) findViewById(R.id.btnShowActivity);
        btnShowActivity.setOnClickListener(this);

        Button btnManageAccount = (Button) findViewById(R.id.btnManageAccount);
        btnManageAccount.setOnClickListener(this);

        setupCountDown();
    }

    private void setupCountDown()
    {
        final TextView tvCountDown = (TextView) findViewById(R.id.tvRemainingCounter);
        final String FORMAT = getString(R.string.remaining_counter);

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2019);
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        Date targetDate = cal.getTime();

        final long targetMillis = targetDate.getTime();
        final long currentTimeMillis = System.currentTimeMillis();
        final long remainingMillis = targetMillis - currentTimeMillis;

        new CountDownTimer(remainingMillis, 1000) { // adjust the milli seconds here

            public void onTick(long millisUntilFinished) {
                final long days = TimeUnit.MILLISECONDS.toDays(millisUntilFinished);
                final long hours = TimeUnit.MILLISECONDS.toHours(millisUntilFinished) - TimeUnit.DAYS.toHours(days);
                final long minutes = TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millisUntilFinished));
                final long seconds = TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished));

                tvCountDown.setText(String.format(FORMAT,
                        days,
                        hours,
                        minutes,
                        seconds
                ));
            }

            public void onFinish() {
                tvCountDown.setText("Mi momento ha llegado");
            }
        }.start();
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
