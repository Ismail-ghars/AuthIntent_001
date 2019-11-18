package com.ismail.authintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MainActivity extends AppCompatActivity {

    String EXTRA_LOGIN = "USER_LOGIN";
    String EXTRA_PASSWORD = "USER_PASSWORD";

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText login = (EditText) findViewById(R.id.user_email);
        final EditText password = (EditText) findViewById(R.id.user_password);
        Button seConnecter = (Button) findViewById(R.id.connect);


        seConnecter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String logintxt = login.getText().toString();
                String passtxt = password.getText().toString();

                if (logintxt.equals("") || passtxt.equals("")) {
                    Toast.makeText(MainActivity.this, R.string.email_or_password_empty,
                                   Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
                    Matcher m = p.matcher(logintxt);
                    if (!m.matches()){
                        Toast.makeText(MainActivity.this,R.string.email_invalide,
                                       Toast.LENGTH_SHORT).show();
                        return;
                    }

                    Intent intent = new Intent(MainActivity.this, LoginDisplayActivity.class);
                    intent.putExtra(EXTRA_LOGIN,logintxt);
                    intent.putExtra(EXTRA_PASSWORD,passtxt);
                    startActivity(intent);
                }
            }
        });
    }
}