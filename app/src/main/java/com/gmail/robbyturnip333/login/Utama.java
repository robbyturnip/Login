package com.gmail.robbyturnip333.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Utama extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utama);

        TextView nama= findViewById(R.id.user);
        TextView nim= findViewById(R.id.angka);

        nama.setText(getIntent().getStringExtra("nama"));
        nim.setText(getIntent().getStringExtra("nim"));
    }
}
