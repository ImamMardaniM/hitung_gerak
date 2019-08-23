package com.example.gerak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_jarak,btn_waktu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_jarak = findViewById(R.id.jarakt);
        btn_jarak.setOnClickListener(this);

        btn_waktu = findViewById(R.id.waktut);
        btn_waktu.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {

        switch(v.getId())
        {

            case R.id.jarakt:
                Intent Jarak = new Intent(this, Main2Activity.class);
                startActivity(Jarak);
                break;

            case R.id.waktut:
                Intent Waktu = new Intent(this, Main3Activity.class);
                startActivity(Waktu);
                break;


        }

    }
}
