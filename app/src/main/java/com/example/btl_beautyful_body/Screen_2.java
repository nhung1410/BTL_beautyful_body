package com.example.btl_beautyful_body;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Screen_2 extends AppCompatActivity {
    TextView txt_chiSoBMI, txt_chiSoBMR, txt_nhipSinhHoc, txt_nhatKy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_2);

        txt_chiSoBMI = (TextView) findViewById(R.id.txt_chiSoBMI);
        txt_chiSoBMR = (TextView) findViewById(R.id.txt_chiSoBMR);
        txt_nhipSinhHoc = (TextView) findViewById(R.id.txt_nhipSinhHoc);
        txt_nhatKy= (TextView) findViewById(R.id.txt_nhatKy);

        final String canNang = getIntent().getStringExtra("CAN_NANG");
        final String chieuCao = getIntent().getStringExtra("CHIEU_CAO");
        final String tuoi = getIntent().getStringExtra("TUOI");
        final String gioiTinh = getIntent().getStringExtra("GIOI_TINH");
        final String eo = getIntent().getStringExtra("EO");
        final String hoatDong = getIntent().getStringExtra("HOAT_DONG");
        final String hong = getIntent().getStringExtra("HONG");
        Log.d("Nhung", canNang + " " + chieuCao + " " + tuoi + " " + gioiTinh + " " + eo + " " + hoatDong + " " + hong);

        txt_chiSoBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Screen_2.this, Screen_3_1.class);
                intent.putExtra("CAN_NANG", canNang);
                intent.putExtra("CHIEU_CAO", chieuCao);
                intent.putExtra("TUOI", tuoi);
                intent.putExtra("GIOI_TINH", gioiTinh);
                intent.putExtra("EO", eo);
                intent.putExtra("HONG", hong);
                intent.putExtra("HOAT_DONG", hoatDong);
                startActivity(intent);


            }
        });
        txt_chiSoBMR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Screen_2.this, Screen_3_2.class);
                intent.putExtra("CAN_NANG", canNang);
                intent.putExtra("CHIEU_CAO", chieuCao);
                intent.putExtra("TUOI", tuoi);
                intent.putExtra("GIOI_TINH", gioiTinh);
                intent.putExtra("EO", eo);
                intent.putExtra("HONG", hong);
                intent.putExtra("HOAT_DONG", hoatDong);
                startActivity(intent);
            }
        });
        txt_nhipSinhHoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Screen_2.this, Screen_4.class);
                intent.putExtra("CAN_NANG", canNang);
                intent.putExtra("CHIEU_CAO", chieuCao);
                intent.putExtra("TUOI", tuoi);
                intent.putExtra("GIOI_TINH", gioiTinh);
                intent.putExtra("EO", eo);
                intent.putExtra("HONG", hong);
                intent.putExtra("HOAT_DONG", hoatDong);
                startActivity(intent);
            }
        });
        txt_nhatKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Screen_2.this, Screen_NhatKy.class);
                intent.putExtra("CAN_NANG", canNang);
                intent.putExtra("CHIEU_CAO", chieuCao);
                intent.putExtra("TUOI",tuoi);
                intent.putExtra("GIOI_TINH", gioiTinh);
                intent.putExtra("EO", eo);
                intent.putExtra("HONG", hong);
                intent.putExtra("HOAT_DONG", hoatDong);
                startActivity(intent);
            }
        });


    }
}
