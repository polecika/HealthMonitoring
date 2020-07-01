package com.example.healthmonitoring;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;

public class PressureActivity extends AppCompatActivity {
    private static final String TAG = "PressureActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pressure);
        Log.i(TAG, "Открыт экран давления");
        init();
    }

    private void init() {
        final Intent intent = getIntent();
        final EditText editTopPressure = (EditText) findViewById(R.id.editTopPressure);
        final EditText editLowerPressure = (EditText) findViewById(R.id.editLowerPressure);
        final EditText editPulse = (EditText) findViewById(R.id.editPulse);
        final EditText editMeasurementDate = (EditText) findViewById(R.id.editMeasurementDate);
        final CheckBox checkboxTachycardia = (CheckBox) findViewById(R.id.checkboxTachycardia);
        final Toast toastSeccess = Toast.makeText(this, "Данные успешно сохранены", Toast.LENGTH_LONG);
        final Toast toastError = Toast.makeText(this, "Одно из полей пусто или заполнено не верно!", Toast.LENGTH_LONG);

        Button buttonPressureSave = (Button) findViewById(R.id.buttonPressureSave);
        buttonPressureSave.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {
                    if(
                            editTopPressure.getText().toString().equals("") ||
                            editLowerPressure.getText().toString().equals("") ||
                            editPulse.getText().toString().equals("") ||
                            editMeasurementDate.getText().toString().equals("")
                    ) {
                        toastError.show();
                        throw new Exception("Одно из полей не заполнено!");
                    }
                    int topPressure = Integer.parseInt(editTopPressure.getText().toString());
                    int lowerPressure = Integer.parseInt(editLowerPressure.getText().toString());
                    int pulse = Integer.parseInt(editPulse.getText().toString());
                    String measurementDate =  editMeasurementDate.getText().toString();
                    boolean tachycardia = checkboxTachycardia.isChecked();
                    if(topPressure <= 0 || lowerPressure <= 0 || pulse <= 0) {
                        toastError.show();
                        throw new Exception("Одно из полей заполнено не верно!");
                    }
                    Pressure pressure = new Pressure(topPressure, lowerPressure, pulse, tachycardia, measurementDate);
                    User user = (User) intent.getSerializableExtra("user");
                    ArrayList<Pressure> pressures = user.getPressures();
                    pressures.add(pressure);
                    user.setPressures(pressures);
                } catch (Exception e) {
                    Log.e(TAG, "Получено исключение", e);
                }

                toastSeccess.show();
            }
        });

    }
}