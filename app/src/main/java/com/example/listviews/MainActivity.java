package com.example.listviews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView tableListView;


    public void generate(int tablesNumber)
    {
        ArrayList<String> tables = new ArrayList<String >();
        for (int j = 1; j <= 20; j++)
        {
            tables.add(Integer.toString(j * tablesNumber));
        }


        ArrayAdapter<String> adapters = new ArrayAdapter<String>(this , android.R.layout.simple_list_item_1, tables);
        tableListView.setAdapter(adapters);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SeekBar countBar = (SeekBar) findViewById(R.id.countBar);
        countBar.setMax(20);
        countBar.setProgress(10);





        tableListView= (ListView) findViewById(R.id.myListView);



        
        countBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int min = 1;
                int tablesNumber;
                if(i<min)
                {
                    tablesNumber = min;
                    countBar.setProgress(min);
                }
                else
                {
                    tablesNumber = i;
                }
                Log.i("clicked" , Integer.toString(i));
                generate(i);




            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });




    }
}