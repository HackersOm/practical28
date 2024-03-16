package com.example.practical28;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MySqliteDemo myDatabaseDemo ;
    int  count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText edt1 = findViewById(R.id.edt1);
        EditText edt2 = findViewById(R.id.edt2);
        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);
        Intent intent = new Intent(getApplicationContext(),secondActivity.class);
        myDatabaseDemo = new MySqliteDemo(this);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count == 3){
                    Toast.makeText(MainActivity.this,"Cannot login your unsccessfull login is out of limit",Toast.LENGTH_SHORT).show();

                }
                else if (edt1.getText().toString().equals(" ") && edt2.getText().toString().equals(" ") ){
                    Toast.makeText(MainActivity.this,"Username and password cannot be empty",Toast.LENGTH_SHORT).show();
                    count ++;

                }
                else if (edt1.getText().toString().length()<=0 && edt2.getText().toString().length()<=0){
                    Toast.makeText(MainActivity.this,"Username and password cannot be empty",Toast.LENGTH_SHORT).show();
                    count++;
                }
                else {

                    boolean res = myDatabaseDemo.read(edt1.getText().toString(), edt2.getText().toString());
                    if (res) {
                        Toast.makeText(MainActivity.this, "Login Successfully ", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Login UnSuccessfully", Toast.LENGTH_SHORT).show();
                    }
                }
            }



        });

        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view ){
                startActivity(intent);
            }
        });


    }
}