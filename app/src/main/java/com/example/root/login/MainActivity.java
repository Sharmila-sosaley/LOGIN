package com.example.root.login;

//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//
//public class MainActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }
//}


import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.id;

public class MainActivity extends Activity {
    private Button login;
    private EditText name;
    private EditText password;
    private TextView attempt;
    private int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        attempt=(TextView) findViewById(R.id.attempt);
        login = (Button) findViewById(R.id.loginbtn);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(name.getText().toString(),password.getText().toString());
            }
        });
    }
    private void validate(String username,String password){
        if((username.equals("admin"))&&(password.equals("admin"))){
            Intent intent=new Intent(MainActivity.this,Main2Activity.class);
            startActivity(intent);
        }
        else{

            counter--;

            attempt.setText("No of attempts remaining: " + String.valueOf(counter));

            if(counter == 0){
                Toast.makeText(MainActivity.this,"Unauthorised User",Toast.LENGTH_LONG).show();

                login.setEnabled(false);
            }
        }
    }
}