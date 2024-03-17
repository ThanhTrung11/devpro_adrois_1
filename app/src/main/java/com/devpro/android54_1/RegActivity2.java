package com.devpro.android54_1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegActivity2 extends AppCompatActivity {

    protected Button btnRegister2;
    protected EditText edtGmail;
    protected EditText edtPass;
    protected EditText edtCheck;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_reg2);

        onClick();
        getVar();

    }
    private void getVar() {
        edtGmail = findViewById(R.id.edtGmail);
        edtPass = findViewById(R.id.edtPass);
        edtCheck = findViewById(R.id.edtCheck);
        btnRegister2 = findViewById(R.id.btnRegister2);
    }

      private void onClick(){
        btnRegister2.setOnClickListener(v -> {
            String gmail = edtGmail.getText().toString().trim();
            String pass = edtPass.getText().toString().trim();
            String check = edtCheck.getText().toString().trim();
            if(gmail.length() > 4
                    && pass.length() > 4

            ){
                if(pass.equals(check)){
                    Intent intent = new Intent(RegActivity2.this,MainActivity.class);
                    intent.putExtra("GMAIL",gmail);
                    intent.putExtra("GMAIL",pass);

                    Toast.makeText(this, " DANG KÍ THÀNH CÔNG", Toast.LENGTH_SHORT).show();

                    finish();
                }   else{
                    edtCheck.setError("sai mật khẩu");
                }
            }else{
                Toast.makeText(this, "Chưa  đủ thông tin", Toast.LENGTH_SHORT).show();
            }

        });
    }


}
