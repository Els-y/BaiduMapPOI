package com.example.baidumappoi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button location_btn = null;
    private TextView location_text = null;

    private static final int ACTIVITY_RESULT_REQUEST_GET_LOCATION = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        location_btn = (Button) findViewById(R.id.location_btn);
        location_text = (TextView) findViewById(R.id.location_text);

        location_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SelectLocationActivity.class);
                startActivityForResult(intent, ACTIVITY_RESULT_REQUEST_GET_LOCATION);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case ACTIVITY_RESULT_REQUEST_GET_LOCATION:
                if (resultCode == RESULT_OK) {
                    String location = data.getStringExtra("location");
                    location_text.setText(location);
                    Toast.makeText(MainActivity.this, location, Toast.LENGTH_SHORT).show();
                }
                break;
            default:
        }
    }
}

