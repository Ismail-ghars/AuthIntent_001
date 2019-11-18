package com.ismail.authintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class LoginDisplayActivity extends AppCompatActivity {

    String EXTRA_LOGIN = "USER_LOGIN";
    String EXTRA_PASSWORD = "USER_PASSWORD";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_display);

        Intent intent =getIntent();

        TextView loginDisplay=findViewById(R.id.email_display);
        TextView passwordDisplay=findViewById(R.id.password_display);
        if (intent !=null)
        {
            loginDisplay.setText((intent.getStringExtra(EXTRA_LOGIN)));
            passwordDisplay.setText((intent.getStringExtra(EXTRA_PASSWORD)));
        }    }
}
