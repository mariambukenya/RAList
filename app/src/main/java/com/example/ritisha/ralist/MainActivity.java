package com.example.ritisha.ralist;

import android.content.ClipData;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String[] raNames;
    String[] dutyDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        listView = (ListView) findViewById(R.id.listView);

        raNames = res.getStringArray(R.array.raNames);
        dutyDay = res.getStringArray(R.array.dutyDay);

        ItemAdapter ItemAdapter = new ItemAdapter(this, raNames, dutyDay);
        listView.setAdapter(ItemAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent showPicture = new Intent(getApplicationContext(),RA_picture.class);
                showPicture.putExtra("com.example.ritisha.ralist.ITEM_INDEX", i);
                startActivity(showPicture);
            }
        });
    }
}
