package com.example.gerak;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    private EditText jarakT, tempuhT;
    private Button Hitung;
    private TextView Hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        jarakT = findViewById(R.id.idjarak);
        tempuhT = findViewById(R.id.idjarak2);
        Hitung = findViewById(R.id.hitung);
        Hasil = findViewById(R.id.thasil);
        Hitung.setOnClickListener(this);


        if (savedInstanceState != null){
            String result = savedInstanceState.getString(STATE_RESULT);
            Hasil.setText(result);
        }
    }

    @Override
    public void onClick(View view){
        if (view.getId() == R.id.hitung) {

            String inputJarak = jarakT.getText().toString().trim();
            String inputTempuh = tempuhT.getText().toString().trim();

            boolean isEmptyFields = false;
            boolean isInvalidDouble = false;

            if (inputJarak.isEmpty()) {
                isEmptyFields = true;
                jarakT.setError("TIDAK BOLEH KOSONG");
            }
            if (TextUtils.isEmpty(inputTempuh)) {
                isEmptyFields = true;
                tempuhT.setError("TIDAK BOLEH KOSONG");
            }


            Double jarakt = toDouble(inputJarak);
            Double tempuht = toDouble(inputTempuh);
            if (jarakt == null) {
                isInvalidDouble = true;
                jarakT.setError("NOMOR HARUS DISESUAIKAN");
            }
            if (tempuht == null) {
                isInvalidDouble = true;
                tempuhT.setError("NOMOR HARUS DISESUAIKAN");
            }
            if (!isEmptyFields && !isInvalidDouble) {
                double hasil = jarakt * tempuht;
                Hasil.setText(String.valueOf(hasil));
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
