package com.mitchy.retailapp.view.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mitchy.retailapp.R;

public class AppFaceActivity extends AppCompatActivity {
    Button button;
    Button kidude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_face);
        button = (Button) findViewById(R.id.option_search);

        // Capture button clicks
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(AppFaceActivity.this,
                        MainActivity.class);
                startActivity(myIntent);
            }
        });

        kidude = (Button) findViewById(R.id.option_categories);

        // Capture button clicks
        kidude.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent intent = new Intent(getApplicationContext(),
                        ECartHomeActivity.class);
                startActivity(intent);
            }
        });

        /*Intent intent = new Intent(getApplicationContext(),
                        ECartHomeActivity.class);
                startActivity(intent)*/
    }
}
