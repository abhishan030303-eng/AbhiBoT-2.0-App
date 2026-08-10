package com.abhibot.virtualtrading;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    LinearLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mainLayout = new LinearLayout(this);
        mainLayout.setOrientation(LinearLayout.VERTICAL);
        mainLayout.setPadding(30, 40, 30, 30);
        mainLayout.setBackgroundColor(Color.WHITE);

        TextView title = new TextView(this);
        title.setText("AbhiBoT 2.0");
        title.setTextSize(30);
        title.setTypeface(null, Typeface.BOLD);
        title.setTextColor(Color.BLACK);
        title.setGravity(Gravity.CENTER);

        mainLayout.addView(title);

        TextView subtitle = new TextView(this);
        subtitle.setText("Virtual Trading Dashboard");
        subtitle.setTextSize(17);
        subtitle.setTextColor(Color.DKGRAY);
        subtitle.setGravity(Gravity.CENTER);
        subtitle.setPadding(0, 10, 0, 30);

        mainLayout.addView(subtitle);

        addButton("📊 Virtual Trading", "Virtual Trading");
        addButton("⭐ Watchlist", "Watchlist");
        addButton("⚡ Start Trade", "Start Trade");
        addButton("📒 Trading Diary", "Trading Diary");
        addButton("👤 Profile", "Profile");
        addButton("⚙ Settings", "Settings");

        setContentView(mainLayout);
    }

    private void addButton(String text, final String message) {

        Button button = new Button(this);
        button.setText(text);
        button.setTextSize(17);
        button.setAllCaps(false);

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

        params.setMargins(0, 8, 0, 8);

        mainLayout.addView(button, params);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(
                        MainActivity.this,
                        message + " selected",
                        Toast.LENGTH_SHORT
                ).show();
            }
        });
    }
}        setContentView(layout);
    }
}
