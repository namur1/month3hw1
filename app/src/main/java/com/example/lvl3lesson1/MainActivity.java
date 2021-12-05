package com.example.lvl3lesson1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {
    private EditText username, password;
    private Button btn_go;
    private ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.usernamebody);
        password = findViewById(R.id.passwordbody);
        btn_go = findViewById(R.id.btn_go);
        logo = findViewById(R.id.logo);
        initListeners();
    }

    private void initListeners() {
        Glide.with(this).load("https://i.imgur.com/PM7tOcS.png").into(logo);
        btn_go.setOnClickListener(view -> {
            Toast.makeText(MainActivity.this, "GO", Toast.LENGTH_SHORT).show();
        });
        username.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() != 0 && password.getText().length() >= 6) {
                    btn_go.setEnabled(true);
                } else {
                    btn_go.setEnabled(false);
                }
            }
        });
        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() >= 6 && username.getText().length() != 0) {
                    btn_go.setEnabled(true);
                } else {
                    btn_go.setEnabled(false);
                }
            }
        });

    }
}
