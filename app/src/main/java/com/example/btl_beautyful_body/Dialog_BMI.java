package com.example.btl_beautyful_body;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.TextView;

public class Dialog_BMI extends AppCompatActivity {
    TextView dialogKQ;
    Button btnLuu, btnThoat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog__bmi);
        final Button btnThoat = (Button) this.findViewById(R.id.btnThoat);

        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog_BMI.this.finish();
            }
        });
    }
}
