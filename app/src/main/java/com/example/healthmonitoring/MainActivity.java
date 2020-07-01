package com.example.healthmonitoring;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "Открыт главный экран");
        init();
    }

    private void init() {
        final EditText editPersonName = (EditText) findViewById(R.id.editPersonName);
        final EditText editPersonAge = (EditText) findViewById(R.id.editPersonAge);

        Button buttonUserSave = (Button) findViewById(R.id.buttonUserSave);
        Button buttonGoToHealthActivity = (Button) findViewById(R.id.buttonGoToHealthActivity);
        Button buttonGoToPressureActivity = (Button) findViewById(R.id.buttonGoToPressureActivity);
        final User user = new User();
        final Toast toastSeccess = Toast.makeText(this, "Данные успешно сохранены", Toast.LENGTH_LONG);
        final Toast toastError = Toast.makeText(this, "Одно из полей пусто или заполнено не верно!", Toast.LENGTH_LONG);

        buttonUserSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String personName = editPersonName.getText().toString();
                    if(editPersonAge.getText().toString().equals("")) {
                        toastError.show();
                        throw new Exception("Одно из полей пусто или заполнено не верно!");
                    }
                    int personAge = Integer.parseInt(editPersonAge.getText().toString());
                    if(personName.equals("") || personAge <= 0 || personAge > 120) {
                        toastError.show();
                        throw new Exception("Одно из полей пусто или заполнено не верно!");
                    }
                    user.setName(personName);
                    user.setAge(personAge);
                    toastSeccess.show();
                } catch (Exception e) {
                    Log.e(TAG, "Получено исключение", e);
                }

            }
        });

        buttonGoToHealthActivity.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intentHealth= new Intent(MainActivity.this, HealthActivity.class);
                intentHealth.putExtra("user", (User) user);
                startActivity(intentHealth);
            }
        });

        buttonGoToPressureActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentPressure = new Intent(MainActivity.this, PressureActivity.class);
                intentPressure.putExtra("user", (User) user);
                startActivity(intentPressure);
            }
        });


    }



}