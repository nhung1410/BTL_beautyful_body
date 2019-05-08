package com.example.btl_beautyful_body;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.util.Log;
import java.text.DecimalFormat;

import androidx.appcompat.app.AppCompatActivity;

public class Screen_3_1 extends AppCompatActivity {
    TextView   txt_tyLeEoHong,
            txt_khoiQuetelet;
    TextView edKq, txt_chanDoan,txtLoiKhuyen;
    Button btnThoat, btnLuuKq;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_3_1);
        txt_tyLeEoHong = (TextView) findViewById(R.id.txt_tyLeEoHong);
        txt_khoiQuetelet = (TextView) findViewById(R.id.txt_khoiQuetelet);


        final String canNang = getIntent().getStringExtra("CAN_NANG");
        final String chieuCao = getIntent().getStringExtra("CHIEU_CAO");
        final String tuoi = getIntent().getStringExtra("TUOI");
        final String gioiTinh = getIntent().getStringExtra("GIOI_TINH");
        final String eo = getIntent().getStringExtra("EO");
        final String hoatDong = getIntent().getStringExtra("HOAT_DONG");
        final String hong = getIntent().getStringExtra("HONG");

        Log.d("e",chieuCao+"");
        final Dialog dialog = new Dialog(Screen_3_1.this);



        txt_khoiQuetelet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DecimalFormat dcf = new DecimalFormat("#.00");
                dialog.setContentView(R.layout.activity_dialog__bmi);
                btnThoat = (Button) dialog.findViewById(R.id.btnThoat);
                btnLuuKq = (Button) dialog.findViewById(R.id.btnLuuKQ);
                edKq = (TextView) dialog.findViewById(R.id.dialog_kq);
                txt_chanDoan = (TextView) dialog.findViewById(R.id.txt_chanDoan);
                txtLoiKhuyen = (TextView)dialog.findViewById(R.id.txtLoiKhuyen);

                String chanDoan = "";
                String loiKhuyen = "";
                //Tính chỉ số BMI theo chỉ số khối Quetelet
                double result = 0;
                result = Float.parseFloat(canNang.trim())/(Float.parseFloat(chieuCao.trim()) * Float.parseFloat(chieuCao.trim()));
                edKq.setText("BMI của bạn là "+dcf.format(result));
                dialog.show();


                if(result<18.5){
                    chanDoan = "Gầy" ;
                    loiKhuyen= "Bạn cần bổ sung thực phẩm hỗ trợ tăng cân và siêng năng tập thể dục!";
                }
                else if(result>=18.5 && result<24.9){
                    chanDoan = "Bình Thường";
                    loiKhuyen = "Tập thể dục hằng ngày để có vóc dáng đẹp nhé!";
                }
                else if(result>=30 && result<35){
                    chanDoan = "Hơi béo";
                    loiKhuyen = "Tập thể dục hằng ngày để có vóc dáng đẹp nhé!";
                }
                else if(result>=30 && result<35){
                    chanDoan = "béo phì cấp độ I";
                    loiKhuyen = "Hãy tập thể dục hằng ngày và ăn nhiều rau xanh";
                }
                else if(result>=35 && result<40){
                    chanDoan = "béo phì cấp độ II";
                    loiKhuyen = "Hãy siêng năng tập thể dục hằng ngày và hạn chế ăn thức ăn nhiều năng lượng";
                }
                else {
                    chanDoan = "béo phì cấp độ III-nguy hiểm";
                    loiKhuyen = "Hãy siêng năng tập thể dục hằng ngày, ăn nhiều rau xanh và ngừng cung cấp thực phẩm chứa nhiều năng lượng";
                }
                txt_chanDoan.setText("Bạn "+chanDoan);
                txtLoiKhuyen.setText(loiKhuyen);

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

        txt_tyLeEoHong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DecimalFormat dcf = new DecimalFormat("#0.00");
                dialog.setContentView(R.layout.activity_dialog__bmi);
                btnThoat = (Button) dialog.findViewById(R.id.btnThoat);
                btnLuuKq = (Button) dialog.findViewById(R.id.btnLuuKQ);
                edKq = (TextView) dialog.findViewById(R.id.dialog_kq);
                txt_chanDoan = (TextView) dialog.findViewById(R.id.txt_chanDoan);
                txtLoiKhuyen = (TextView)dialog.findViewById(R.id.txtLoiKhuyen);

                //Tính chỉ số BMI theo vong eo - hông
                double result = 0;
                result = Float.parseFloat(eo.trim())/(Float.parseFloat(hong.trim()) );
                edKq.setText("BMI của bạn là "+dcf.format(result));
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

                String chanDoan = "";
                String loiKhuyen = "";

                //Xét theo giới tính nam
                if(gioiTinh.equals("Nam")){
                    //Độ tuổi 20-29
                    if(Integer.parseInt(tuoi.trim())>19 && Integer.parseInt(tuoi.trim())<30){
                        if(result < 0.83){
                            chanDoan = "có nguy cơ béo phì thấp";
                            loiKhuyen = "Bạn cần bổ sung thực phẩm hỗ trợ tăng cân và siêng năng tập thể dục!";
                        }
                        else if(result >=0.83 && result <0.89){
                            chanDoan = "có nguy cơ béo phì trung bình";
                            loiKhuyen = "Tập thể dục hằng ngày để có vóc dáng đẹp nhé!";
                        }
                        else if(result >=0.89 && result <=0.94){
                            chanDoan = "có nguy có béo phì cao";
                            loiKhuyen = "Hãy tập thể dục hằng ngày và ăn nhiều rau xanh";
                        }
                        else {
                            chanDoan = "có nguy cơ béo phì rất cao";
                            loiKhuyen = "Hãy siêng năng tập thể dục hằng ngày, ăn nhiều rau xanh và ngừng cung cấp thực phẩm chứa nhiều năng lượng";

                        }
                    }
                    //Độ tuổi 30-39
                    if(Integer.parseInt(tuoi.trim())>29 && Integer.parseInt(tuoi.trim())<40){
                        if(result < 0.84){
                            chanDoan = "có nguy cơ béo phì thấp";
                            loiKhuyen = "Bạn cần bổ sung thực phẩm hỗ trợ tăng cân và siêng năng tập thể dục!";
                        }
                        else if(result >=0.84 && result <=0.91){
                            chanDoan = "có nguy cơ béo phì trung bình";
                            loiKhuyen = "Tập thể dục hằng ngày để có vóc dáng đẹp nhé!";
                        }
                        else if(result >=0.92 && result <=0.96){
                            chanDoan = "có nguy có béo phì cao";
                            loiKhuyen = "Hãy tập thể dục hằng ngày và ăn nhiều rau xanh";
                        }
                        else {
                            chanDoan = "có nguy cơ béo phì rất cao";
                            loiKhuyen = "Hãy siêng năng tập thể dục hằng ngày, ăn nhiều rau xanh và ngừng cung cấp thực phẩm chứa nhiều năng lượng";
                        }
                    }
                    //Độ tuổi 40-49
                    if(Integer.parseInt(tuoi.trim())>=40 && Integer.parseInt(tuoi.trim())<50){
                        if(result < 0.88){
                            chanDoan = "có nguy cơ béo phì thấp";
                            loiKhuyen = "Bạn cần bổ sung thực phẩm hỗ trợ tăng cân và siêng năng tập thể dục!";
                        }
                        else if(result >=0.88 && result <=0.95){
                            chanDoan = "có nguy cơ béo phì trung bình";
                            loiKhuyen = "Tập thể dục hằng ngày để có vóc dáng đẹp nhé!";
                        }
                        else if(result >=0.96 && result <=1.00){
                            chanDoan = "có nguy có béo phì cao";
                            loiKhuyen = "Hãy tập thể dục hằng ngày và ăn nhiều rau xanh";
                        }
                        else {
                            chanDoan = "có nguy cơ béo phì rất cao";
                            loiKhuyen = "Hãy siêng năng tập thể dục hằng ngày, ăn nhiều rau xanh và ngừng cung cấp thực phẩm chứa nhiều năng lượng";
                        }
                    }
                    //Độ tuổi 50-59
                    if(Integer.parseInt(tuoi.trim())>49 && Integer.parseInt(tuoi.trim())<70){
                        if(result < 0.91){
                            chanDoan = "có nguy cơ béo phì thấp";
                            loiKhuyen = "Bạn cần bổ sung thực phẩm hỗ trợ tăng cân và siêng năng tập thể dục!";
                        }
                        else if(result >=0.91 && result <=0.98){
                            chanDoan = "có nguy cơ béo phì trung bình";
                            loiKhuyen = "Tập thể dục hằng ngày để có vóc dáng đẹp nhé!";
                        }
                        else if(result >=0.99 && result <=1.03){
                            chanDoan = "có nguy có béo phì cao";
                            loiKhuyen = "Hãy tập thể dục hằng ngày và ăn nhiều rau xanh!";
                        }
                        else {
                            chanDoan = "có nguy cơ béo phì rất cao";
                            loiKhuyen = "Hãy siêng năng tập thể dục hằng ngày, ăn nhiều rau xanh và ngừng cung cấp thực phẩm chứa nhiều năng lượng";
                        }
                    }
                    //Độ tuổi 60-69
                    if(Integer.parseInt(tuoi.trim())>59 && Integer.parseInt(tuoi.trim())<60){
                        if(result < 0.90){
                            chanDoan = "có nguy cơ béo phì thấp";
                            loiKhuyen = "Bạn cần bổ sung thực phẩm hỗ trợ tăng cân và siêng năng tập thể dục!";
                        }
                        else if(result >=0.90 && result <=0.96){
                            chanDoan = "có nguy cơ béo phì trung bình";
                            loiKhuyen = "Tập thể dục hằng ngày để có vóc dáng đẹp nhé!";
                        }
                        else if(result >=0.97 && result <=1.02){
                            chanDoan = "có nguy có béo phì cao";
                            loiKhuyen = "Hãy tập thể dục hằng ngày và ăn nhiều rau xanh";
                        }
                        else {
                            chanDoan = "có nguy cơ béo phì rất cao";
                            loiKhuyen= "Hãy siêng năng tập thể dục hằng ngày, ăn nhiều rau xanh và ngừng cung cấp thực phẩm chứa nhiều năng lượng";
                        }
                    }

                }
                //Xét theo giới tính nữ
                if(gioiTinh.equals("Nữ")){
                    //Độ tuổi 20-29
                    if(Integer.parseInt(tuoi.trim())>19 && Integer.parseInt(tuoi.trim())<30){
                        if(result < 0.71){
                            chanDoan = "có nguy cơ béo phì thấp";
                            loiKhuyen = "Bạn cần bổ sung thực phẩm hỗ trợ tăng cân và siêng năng tập thể dục!";
                        }
                        else if(result >=0.71 && result <0.78){
                            chanDoan = "có nguy cơ béo phì trung bình";
                            loiKhuyen = "Tập thể dục hằng ngày để có vóc dáng đẹp nhé!";
                        }
                        else if(result >=0.78 && result <=0.82){
                            chanDoan = "có nguy có béo phì cao";
                            loiKhuyen = "Hãy tập thể dục hằng ngày và ăn nhiều rau xanh";
                        }
                        else {
                            chanDoan = "có nguy cơ béo phì rất cao";
                            loiKhuyen = "Hãy siêng năng tập thể dục hằng ngày, ăn nhiều rau xanh và ngừng cung cấp thực phẩm chứa nhiều năng lượng";

                        }
                    }
                    //Độ tuổi 30-39
                    if(Integer.parseInt(tuoi.trim())>29 && Integer.parseInt(tuoi.trim())<40){
                        if(result < 0.72){
                            chanDoan = "có nguy cơ béo phì thấp";
                            loiKhuyen = "Bạn cần bổ sung thực phẩm hỗ trợ tăng cân và siêng năng tập thể dục!";
                        }
                        else if(result >=0.72 && result <=0.78){
                            chanDoan = "có nguy cơ béo phì trung bình";
                            loiKhuyen = "Tập thể dục hằng ngày để có vóc dáng đẹp nhé!";
                        }
                        else if(result >=0.79 && result <=0.84){
                            chanDoan = "có nguy có béo phì cao";
                            loiKhuyen = "Hãy tập thể dục hằng ngày và ăn nhiều rau xanh";
                        }
                        else {
                            chanDoan = "có nguy cơ béo phì rất cao";
                            loiKhuyen = "Hãy siêng năng tập thể dục hằng ngày, ăn nhiều rau xanh và ngừng cung cấp thực phẩm chứa nhiều năng lượng";
                        }
                    }
                    //Độ tuổi 40-49
                    if(Integer.parseInt(tuoi.trim())>=40 && Integer.parseInt(tuoi.trim())<50){
                        if(result < 0.73){
                            chanDoan = "có nguy cơ béo phì thấp";
                            loiKhuyen = "Bạn cần bổ sung thực phẩm hỗ trợ tăng cân và siêng năng tập thể dục!";
                        }
                        else if(result >=0.73 && result <=0.79){
                            chanDoan = "có nguy cơ béo phì trung bình";
                            loiKhuyen = "Tập thể dục hằng ngày để có vóc dáng đẹp nhé!";
                        }
                        else if(result >=0.80 && result <=1.87){
                            chanDoan = "có nguy có béo phì cao";
                            loiKhuyen = "Hãy tập thể dục hằng ngày và ăn nhiều rau xanh";
                        }
                        else {
                            chanDoan = "có nguy cơ béo phì rất cao";
                            loiKhuyen = "Hãy siêng năng tập thể dục hằng ngày, ăn nhiều rau xanh và ngừng cung cấp thực phẩm chứa nhiều năng lượng";
                        }
                    }
                    //Độ tuổi 50-59
                    if(Integer.parseInt(tuoi.trim())>49 && Integer.parseInt(tuoi.trim())<70){
                        if(result < 0.74){
                            chanDoan = "có nguy cơ béo phì thấp";
                            loiKhuyen = "Bạn cần bổ sung thực phẩm hỗ trợ tăng cân và siêng năng tập thể dục!";
                        }
                        else if(result >=0.74 && result <=0.81){
                            chanDoan= "có nguy cơ béo phì trung bình";
                            loiKhuyen = "Tập thể dục hằng ngày để có vóc dáng đẹp nhé!";
                        }
                        else if(result >=0.82 && result <=0.88){
                            chanDoan = "có nguy có béo phì cao";
                            loiKhuyen = "Hãy tập thể dục hằng ngày và ăn nhiều rau xanh";
                        }
                        else {
                            chanDoan = "có nguy cơ béo phì rất cao";
                            loiKhuyen = "Hãy siêng năng tập thể dục hằng ngày, ăn nhiều rau xanh và ngừng cung cấp thực phẩm chứa nhiều năng lượng";
                        }
                    }
                    //Độ tuổi 60-69
                    if(Integer.parseInt(tuoi.trim())>59 && Integer.parseInt(tuoi.trim())<60){
                        if(result < 0.76){
                            chanDoan = "có nguy cơ béo phì thấp";
                            loiKhuyen = "Bạn cần bổ sung thực phẩm hỗ trợ tăng cân và siêng năng tập thể dục!";
                        }
                        else if(result >=0.76 && result <=0.83){
                            chanDoan = "có nguy cơ béo phì trung bình";
                            loiKhuyen= "Tập thể dục hằng ngày để có vóc dáng đẹp nhé!";
                        }
                        else if(result >=0.84 && result <=0.90){
                            chanDoan = "có nguy có béo phì cao";
                            loiKhuyen = "Hãy tập thể dục hằng ngày và ăn nhiều rau xanh";
                        }
                        else {
                            chanDoan = "có nguy cơ béo phì rất cao";
                            loiKhuyen = "Hãy siêng năng tập thể dục hằng ngày, ăn nhiều rau xanh và ngừng cung cấp thực phẩm chứa nhiều năng lượng";
                        }
                    }

                }
                txt_chanDoan.setText("Bạn " + chanDoan);
                txtLoiKhuyen.setText(loiKhuyen);


            }
        });


    }
}
