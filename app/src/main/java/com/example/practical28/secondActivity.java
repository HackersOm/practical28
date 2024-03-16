package com.example.practical28;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class secondActivity extends AppCompatActivity {
    MySqliteDemo myDatabase ;
    private static final Pattern  patter = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[\\W_]).{6,20}$");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        myDatabase = new MySqliteDemo(this);
        EditText edt1 = findViewById(R.id.edt1);
        EditText edt2 = findViewById(R.id.edt2);
        EditText edt3 = findViewById(R.id.edt3);
        Button btn = findViewById(R.id.btn1);
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(patter.matcher(edt2.getText().toString()).matches())
                {
                    if(edt2.getText().toString().equals(edt3.getText().toString()))
                    {
                        boolean res = myDatabase.insert(edt1.getText().toString(),edt2.getText().toString());
                        if(res){
                            Toast.makeText(secondActivity.this,"Sign In Successfully",Toast.LENGTH_SHORT).show();
                            startActivity(intent);
                            secondActivity.super.finish();

                        }
                        else{
                            Toast.makeText(secondActivity.this,"Sgin in not Successfully",Toast.LENGTH_SHORT).show();
                        }

                    }
                    else{
                        Toast.makeText(secondActivity.this,"Please Check your password",Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(secondActivity.this,"Please Enter Strong Password ",Toast.LENGTH_SHORT).show();

                }

            }
        });

    }
}