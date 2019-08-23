package com.example.gerak;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Main3Activity extends AppCompatActivity implements View.OnClickListener {

    private EditText Tjarak, Tcepat;
    private Button Hitung;
    private TextView Hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Tjarak = findViewById(R.id.tjarak);
        Tcepat = findViewById(R.id.tcepat);
        Hitung = findViewById(R.id.hitung);
        Hasil = findViewById(R.id.hasil);
        Hitung.setOnClickListener(this);


        if (savedInstanceState != null){
            String result = savedInstanceState.getString(STATE_RESULT);
            Hasil.setText(result);
        }
    }

    @Override
    public void onClick(View view){
        if (view.getId() == R.id.hitung) {

            String inputSisi1 = Tjarak.getText().toString().trim();
            String inputSisi2 = Tcepat.getText().toString().trim();

            boolean isEmptyFields = false;
            boolean isInvalidDouble = false;


            if (inputSisi1.isEmpty()) {
                isEmptyFields = true;
                Tjarak.setError("TIDAK BOLEH KOSONG");
            }
            if (TextUtils.isEmpty(inputSisi2)) {
                isEmptyFields = true;
                Tcepat.setError("TIDAK BOLEH KOSONG");
            }

            Double tjarak = toDouble(inputSisi1);
            Double tcepat = toDouble(inputSisi2);

            if (tjarak == null) {
                isInvalidDouble = true;
                Tjarak.setError("NOMOR HARUS DISESUAIKAN");
            }
            if (tcepat == null) {
                isInvalidDouble = true;
                Tcepat.setError("NOMOR HARUS DISESUAIKAN");
            }

            if (!isEmptyFields && !isInvalidDouble) {
                double wtempuh = tjarak / tcepat;
                Hasil.setText(String.valueOf(wtempuh));
            }
        }
    }
    private Double toDouble(String str){
        try{
            return Double.valueOf(str);
        }catch (NumberFormatException e){
            return null;
        }
    }

    private static final String STATE_RESULT = "state_result";
    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putString(STATE_RESULT, Hasil.getText().toString());
    }
}