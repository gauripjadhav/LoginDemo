package com.example.logindemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText Username;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Username = (EditText)findViewById(R.id.etUsername);
        Password = (EditText)findViewById(R.id.etPassword);
        Info = (TextView)findViewById(R.id.tvInfo);
        Login = (Button)findViewById(R.id.btLogin);

        Info.setText("No of attempts remaining : 5");

        Login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                validate(Username.getText().toString(), Password.getText().toString());
            }
        });
    }

    private void validate(String userName, String userPassword){
         if((userName == "Admin") && (userPassword == "123456")){
             Intent intent = new Intent(MainActivity.this, SecondActivity.class);
             startActivity(intent);
        }else{
              counter--;
              Info.setText("No of attempts remaining: " + String.valueOf(counter));

              if(counter == 0){
                  Login.setEnabled(false);
              }
        }
    }
}
