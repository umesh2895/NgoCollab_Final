package com.ngocollab.signup;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.ngocollab.R;
import com.ngocollab.login.LoginActivity;

/**
 * Created by KunalPardeshi on 1/10/2017.
 */

public class RegisterActivity extends AppCompatActivity {

    Button buttonNext;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }

        buttonNext = (Button) findViewById(R.id.buttonRegisterNext);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentNext = new Intent(RegisterActivity.this, GetLocationActivity.class);
                startActivity(intentNext);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intentNext = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intentNext);
        finish();
        super.onBackPressed();
    }
}
