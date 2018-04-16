package com.gmail.robbyturnip333.login;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button tombol= findViewById(R.id.login);


        tombol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText nama= findViewById(R.id.user);
                EditText nim= findViewById(R.id.angka);
                EditText pass= findViewById(R.id.pw);

                String ubah_Nama,ubah_Nim,ubah_Pw,alert1,alert2,alert3;
                Boolean status_nama,status_nim,status_pass;
                ubah_Nama=nama.getText().toString();
                ubah_Nim=nim.getText().toString();
                ubah_Pw=pass.getText().toString();

                Shuffle s = new Shuffle();


                if(ubah_Nama.contains("Robby")){
                    status_nama=true;
                    alert1="";
                }
                else {
                    status_nama = false;
                    alert1=" Nama Salah";
                }
                if (ubah_Nim.contains("155410114")){
                    status_nim=true;
                    alert2="";
                }
                else {
                    status_nim = false;
                    alert2=" NIM Salah";
                }
                if (ubah_Pw.contains("turnip")) {
                    status_pass = true;
                    alert3="";
                }
                else {
                    status_pass = false;
                    alert3=" Password Salah";
                }

                /*ubah_Nama.contains("Robby")&&ubah_Nim.contains("155410114")&&ubah_Pw.contains("turnip")*/

                if(status_nama==true && status_nim==true && status_pass==true ){
                    Toast.makeText(getApplicationContext(),"LOGIN BERHSIL",Toast.LENGTH_SHORT).show();
                    Intent utama=new Intent(MainActivity.this, Utama.class);
                    utama.putExtra("nama",ubah_Nama);
                    utama.putExtra("nim",s.shuffle(ubah_Nim));
                    startActivity(utama);
                }
                else{
                    AlertDialog.Builder peringatan= new AlertDialog.Builder(MainActivity.this);
                    peringatan.setMessage(alert1+alert2+alert3).setNegativeButton("Coba Lagi",null).create().show();
                }
            }
        });

    }
    public class Shuffle {

        public String shuffle(String input){
            List<Character> characters = new ArrayList<Character>();
            for(char c:input.toCharArray()){
                characters.add(c);
            }
            StringBuilder output = new StringBuilder(input.length());
            while(characters.size()!=0){
                int randPicker = (int)(Math.random()*characters.size());
                output.append(characters.remove(randPicker));
            }
            return output.toString();
        }
    }

}


