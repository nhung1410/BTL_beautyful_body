package com.example.btl_beautyful_body;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Screen_NhatKy extends AppCompatActivity {
    ListView listNhatKy;
    ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen__nhat_ky);

        listNhatKy = (ListView) findViewById(R.id.list_nhatKy);
        final String canNang = getIntent().getStringExtra("CAN_NANG");
        final String chieuCao = getIntent().getStringExtra("CHIEU_CAO");
        final String tuoi = getIntent().getStringExtra("TUOI");
        final String gioiTinh = getIntent().getStringExtra("GIOI_TINH");
        final String eo = getIntent().getStringExtra("EO");
        final String hong = getIntent().getStringExtra("HONG");
        final String hoatDong = getIntent().getStringExtra("HOAT_DONG");

        arrayList = new ArrayList<>();
        arrayList.add(chieuCao);
        ArrayAdapter adapter = new ArrayAdapter(Screen_NhatKy.this,android.R.layout.simple_list_item_1, arrayList);
        listNhatKy.setAdapter(adapter);
    }
}
