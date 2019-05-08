package com.example.btl_beautyful_body;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ChiSoActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    TextView txtNgaySinh, txtThangSinh, txtNamSinh;
    EditText edtxtChieuCao, edtxtCanNang, edtxtTuoi, edtxtEo, edtxtHong;
    Button btnNhapLai, btnTiepTuc;
    ChiSo chiSo;
    Spinner spinner, spinnerHD;
    int positionGT, positionHD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_so);

        spinner = (Spinner) findViewById(R.id.spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.arrGioiTinh, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        spinnerHD = (Spinner) findViewById(R.id.spinnerHD);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.arrHoatDong, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinnerHD.setAdapter(adapter1);

        spinner.setOnItemSelectedListener(this);
        spinnerHD.setOnItemSelectedListener(this);

        edtxtChieuCao = (EditText) findViewById(R.id.edtxt_chieuCao);
        edtxtCanNang = (EditText) findViewById(R.id.edtxt_canNang);
        edtxtTuoi = (EditText) findViewById(R.id.edtxt_tuoi);
        edtxtEo = (EditText) findViewById(R.id.edtxt_vongEo);
        edtxtHong = (EditText) findViewById(R.id.edtxt_vongHong);
        btnNhapLai = (Button) findViewById(R.id.btn_nhapLai);
        btnTiepTuc = (Button) findViewById(R.id.btn_tiepTuc);

        btnTiepTuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Kiểm tra hợp lệ
                String chieuCao = edtxtChieuCao.getText()+"";
                chieuCao = chieuCao.trim();
                if(chieuCao.length()<1) {
                    edtxtChieuCao.requestFocus();
                    edtxtChieuCao.selectAll();
                    Toast.makeText(ChiSoActivity.this,"Bạn phải nhập chiều cao", Toast.LENGTH_LONG).show();
                    return;
                }
                if ((edtxtCanNang.getText().toString().trim().length()<1)){
                    edtxtCanNang.requestFocus();
                    edtxtCanNang.selectAll();
                    Toast.makeText(ChiSoActivity.this,"Bạn phải nhập cân nặng", Toast.LENGTH_LONG).show();
                    return;
                }
                if ((edtxtEo.getText().toString().trim().length()<1)){
                    edtxtEo.requestFocus();
                    edtxtEo.selectAll();
                    Toast.makeText(ChiSoActivity.this,"Bạn phải nhập cân nặng", Toast.LENGTH_LONG).show();
                    return;
                }
                if ((edtxtHong.getText().toString().trim().length()<1)){
                    edtxtHong.requestFocus();
                    edtxtHong.selectAll();
                    Toast.makeText(ChiSoActivity.this,"Bạn phải nhập cân nặng", Toast.LENGTH_LONG).show();
                    return;
                }
                if ((edtxtTuoi.getText().toString().trim().length()<1)){
                    edtxtTuoi.requestFocus();
                    edtxtTuoi.selectAll();
                    Toast.makeText(ChiSoActivity.this,"Bạn phải nhập cân nặng", Toast.LENGTH_LONG).show();
                    return;
                }
                Intent intent = new Intent(ChiSoActivity.this, Screen_2.class);
                intent.putExtra("CAN_NANG", edtxtCanNang.getText().toString());
                intent.putExtra("CHIEU_CAO", edtxtChieuCao.getText().toString());
                intent.putExtra("TUOI", edtxtTuoi.getText().toString());
                intent.putExtra("GIOI_TINH", spinner.getSelectedItem().toString());
                intent.putExtra("EO", edtxtEo.getText().toString());
                intent.putExtra("HONG", edtxtHong.getText().toString());
                intent.putExtra("HOAT_DONG", spinnerHD.getSelectedItem().toString());
                startActivity(intent);
            }
        });
        btnNhapLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtxtChieuCao.getText().clear();
                edtxtCanNang.getText().clear();
                edtxtEo.getText().clear();
                edtxtHong.getText().clear();
                edtxtTuoi.getText().clear();
                edtxtChieuCao.requestFocus();

            }
        });

    }

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }


}
