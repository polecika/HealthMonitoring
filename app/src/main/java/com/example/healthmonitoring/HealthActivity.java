package com.example.healthmonitoring;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class HealthActivity extends AppCompatActivity {
    private static final String TAG = "HealthActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health);
        Log.i(TAG, "Открыт экран жизненный показателей");
        init();
    }

    private void init() {
        final Intent intent = getIntent();
        final EditText editWeight = (EditText) findViewById(R.id.editWeight);
        final EditText editStepsCount = (EditText) findViewById(R.id.editStepsCount);
        final Toast toastSeccess = Toast.makeText(this, "Данные успешно сохранены", Toast.LENGTH_LONG);
        final Toast toastError = Toast.makeText(this, "Одно из полей пусто или заполнено не верно!", Toast.LENGTH_LONG);


        Button buttonSaveHealth = (Button) findViewById(R.id.buttonSaveHealth);

        buttonSaveHealth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Нажата кнопка [Сохранить]");
                try {
                    if(editWeight.getText().toString().equals("") || editStepsCount.getText().toString().equals("")){
                        toastError.show();
                        throw new Exception("Одно из полей не заполнено!");
                    }
                    int weight = Integer.parseInt(editWeight.getText().toString());
                    int stepsCount = Integer.parseInt(editStepsCount.getText().toString());
                    if(weight <= 0 || stepsCount <= 0 || weight > 300) {
                        toastError.show();
                        throw new Exception("Одно из полей заполнено не верно!");
                    }
                    User user = (User) intent.getSerializableExtra("user");
                    ArrayList<Health> health = user.getHealth();
                    health.add(new Health(weight, stepsCount));
                    user.setHealth(health);
                    toastSeccess.show();
                } catch (Exception e) {
                    Log.e(TAG, "Получено исключение", e);
                }


            }
        });
    }
}