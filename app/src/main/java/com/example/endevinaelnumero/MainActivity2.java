package com.example.endevinaelnumero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent2 = getIntent();
        ArrayList<String> listaRecords2 = new ArrayList<String>();
        listaRecords2 = intent2.getStringArrayListExtra("LISTA");
        TextView tv = findViewById(R.id.textView5);
        TextView tv2 = findViewById(R.id.textView6);
        String textoFinal1 = "";
        String textoFinal2 = "";
        for (String punt : listaRecords2) {
            String[] usuario = punt.split(" ");
            textoFinal1 += usuario[0]+"\n";
            textoFinal2 +=usuario[1]+"\n";
        }
        tv.setText(textoFinal1);
        tv2.setText(textoFinal2);
    }
}