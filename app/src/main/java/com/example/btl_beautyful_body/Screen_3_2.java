package com.example.btl_beautyful_body;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.AdapterView;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Screen_3_2 extends AppCompatActivity {
    TextView txtCtHarris,txtCtMifflin;
    final Context context = this;
    //double result = 0;
    private void fillTextView (int id, String text) {
        TextView tv = (TextView) findViewById(id);
        tv.setText(text);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_3_2);
        Bundle bundleBMR = getIntent().getExtras();

        final String canNang = getIntent().getStringExtra("CAN_NANG");
        final String chieuCao = getIntent().getStringExtra("CHIEU_CAO");
        final String tuoi = getIntent().getStringExtra("TUOI");
        final String gioiTinh = getIntent().getStringExtra("GIOI_TINH");
        final String eo = getIntent().getStringExtra("EO");
        final String hoatDong = getIntent().getStringExtra("HOAT_DONG");
        final String hong = getIntent().getStringExtra("HONG");
        //ChiSo cs = new ChiSo();
        Log.d("e",chieuCao+"");
        txtCtHarris = (TextView) findViewById(R.id.txt_ctHarris);
        txtCtMifflin = (TextView) findViewById(R.id.txt_ctMafflin);
        //final EditText editTextKQ = (EditText) findViewById(R.id.edtKQ);
        txtCtHarris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(Screen_3_2.this,Dialog_BMI.class);
                double result = 0;
                    if (!!gioiTinh.equals("Nam"))
                        result = 66+(13.7 *  Float.parseFloat(canNang.trim())) + (5 * Float.parseFloat(chieuCao.trim())) - (6.76 * Integer.parseInt(tuoi.trim()));
                    else
                        result = 65.5 +(9.6 *  Float.parseFloat(canNang.trim())) + (1.8 * Float.parseFloat(chieuCao.trim())) - (4.7 * Integer.parseInt(tuoi.trim()));
                DecimalFormat dcf = new DecimalFormat("#0.000");
                final Dialog dialog = new Dialog(Screen_3_2.this);
                dialog.setContentView(R.layout.activity_dialog__bmi);
                TextView txtKq = (TextView) dialog.findViewById(R.id.dialog_kq);

//
                Button btnThoat = (Button) dialog.findViewById(R.id.btnThoat);
                Button btnLuuKq = (Button) dialog.findViewById(R.id.btnLuuKQ);
                txtKq.setText("BMR của bạn là "+dcf.format(result));
                dialog.show();
                btnThoat.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });
                btnLuuKq.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });
            }
        });

        txtCtMifflin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }
}
