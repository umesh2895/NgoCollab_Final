package com.ngocollab.login;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ngocollab.R;
import com.ngocollab.dashboard.DashboardActivity;
import com.ngocollab.signup.GetLocationActivity;
import com.ngocollab.signup.RegisterActivity;

/**
 * Created by KunalPardeshi on 1/10/2017.
 */

public class OTPActivity extends AppCompatActivity {

    Button buttonLogIn;
    TextView textViewResendOTP;
    EditText editTextEnterOTP;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_login);

        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }

        editTextEnterOTP = (EditText) findViewById(R.id.editTextOTP);
        buttonLogIn = (Button) findViewById(R.id.buttonLogIn);
        textViewResendOTP = (TextView) findViewById(R.id.textViewResendOTP);

        buttonLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OTPActivity.this, DashboardActivity.class);
                startActivity(intent);
                finish();
            }
        });

        textViewResendOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(OTPActivity.this, "Sending OTP !", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intentNext = new Intent(OTPActivity.this, LoginActivity.class);
        startActivity(intentNext);
        finish();
        super.onBackPressed();
    }
}
