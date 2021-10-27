package com.example.endevinaelnumero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity2 extends AppCompatActivity {

    class Record implements Comparable{
        public int intents;
        public String nom;

        public Record(int _intents, String _nom ) {
            intents = _intents;
            nom = _nom;
        }
        public int getIntents() {
            return intents;
        }
        public void setIntents(int intents) {
            this.intents = intents;
        }

        public int compareTo(Object r) {
            int compareRecord = ((Record)r).getIntents();
            return this.intents-compareRecord;
        }
    }
    public static ArrayList<Record> listaRecords = new ArrayList<Record>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent2 = getIntent();
        listaRecords.add(new Record(intent2.getIntExtra("INTENTOS",0),intent2.getStringExtra("NOMBRE")));
        Collections.sort(listaRecords);
        ArrayAdapter<Record> adapter = new ArrayAdapter<Record>(this, R.layout.list_item,listaRecords)
        {
            @Override
            public View getView(int pos, View convertView, ViewGroup container)
            {
                // getView ens construeix el layout i hi "pinta" els valors de l'element en la posició pos
                if( convertView==null ) {
                    // inicialitzem l'element la View amb el seu layout
                    convertView = getLayoutInflater().inflate(R.layout.list_item, container, false);
                }
                // "Pintem" valors (també quan es refresca)
                ((TextView) convertView.findViewById(R.id.nom)).setText(getItem(pos).nom);
                ((TextView) convertView.findViewById(R.id.intents)).setText(Integer.toString(getItem(pos).intents));
                return convertView;
            }

        };

        // busquem la ListView i li endollem el ArrayAdapter
        ListView lv = (ListView) findViewById(R.id.recordsView);
        lv.setAdapter(adapter);
    }
}