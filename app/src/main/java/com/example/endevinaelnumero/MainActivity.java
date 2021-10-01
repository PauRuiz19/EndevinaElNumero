package com.example.endevinaelnumero;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        int randomNumber = (int) (Math.random()*100);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);
        EditText number = findViewById(R.id.editTextNumber);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int numberSelected = Integer.parseInt(number.getText().toString());
                String toastText = "";
                if (numberSelected>randomNumber){
                    toastText = "El numero introducido es mas grande que el numero a adivinar";
                }else if (numberSelected<randomNumber){
                    toastText = "El numero introducido es mas pequeño que el numero a adivinar";
                }
                number.setText("");
                Toast toast = Toast.makeText(getApplicationContext(),toastText,Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
}