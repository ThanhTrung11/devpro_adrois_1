package com.devpro.android54_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
//protected Button btnStart;

    protected Button btnLogin;
    protected Button btnRegister;
    protected EditText edtGmail;
    protected EditText edtPass;
    protected TextView txLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        getVar();
        onClick();
    }
    protected void getVar() {
        edtGmail = findViewById(R.id.edtGmail);
        edtPass = findViewById(R.id.edtPass);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);
    }

        private void onClick() {

                Intent intent = getIntent();
                String dataGmail = intent.getStringExtra("GMAIL");
                String dataPass = intent.getStringExtra("PASS");

                btnLogin.setOnClickListener(v -> {
                    String username = edtGmail.getText().toString().trim();
                    String password = edtPass.getText().toString().trim();

                    if (username.isEmpty()) {
                        edtGmail.setError("Trong");
                    } else if (password.isEmpty()) {
                        edtPass.setError("Trong");
                    } else {
                        if (username.equals(dataGmail) && password.equals(dataPass)) {
                            Intent intent1 = new Intent(MainActivity.this, BaActivity.class);
                            Toast.makeText(this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                            startActivity(intent1);
                            finish();
                        } else {
                            Toast.makeText(this, "Sai tên đăng nhập hoặc mật khẩu", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                btnRegister.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent2 = new Intent(MainActivity.this, RegActivity2.class);
                        startActivity(intent2);
                    }
                });


            }


}







//    @Override
//    protected void onStart() {
//        super.onStart();
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//    }
//
//    @Override
//    protected void onRestart() {
//        super.onRestart();
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//    }
