package com.example.khanh.customlistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Country> listCountry = getListData();
        final ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(new CustomListAdapter(listCountry, this));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Object o = listView.getItemAtPosition(i);
                Country country = (Country) o;
                Toast.makeText(MainActivity.this, country.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private List<Country> getListData() {
        List<Country> list = new ArrayList<Country>();
        Country vn = new Country("VietNam", "vi", 98000000);
        Country us = new Country("United States", "us", 320000000);
        Country ru = new Country("Russia", "ru", 142000000);
        list.add(vn);
        list.add(us);
        list.add(ru);
        return list;
    }
}
