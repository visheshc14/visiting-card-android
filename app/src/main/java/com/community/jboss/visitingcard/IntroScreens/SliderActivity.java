package com.community.jboss.visitingcard.IntroScreens;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.community.jboss.visitingcard.LoginActivity;
import com.community.jboss.visitingcard.R;

public class SliderActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_INTRO = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        if (preferences != null) {
            if (preferences.getBoolean("is_first", true)){
                startActivityForResult(new Intent(this, WelcomeActivity.class), REQUEST_CODE_INTRO);
            }
        }

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Proceed to Login", Snackbar.LENGTH_LONG)
                        .setAction("Yes", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent toLogin = new Intent(SliderActivity.this, LoginActivity.class);
                                startActivity(toLogin);
                            }
                        }).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_INTRO) {
            if (resultCode == RESULT_OK) {
                // Finished the intro
                setFinish();
            }
        } else {
            // Cancelled the intro. You can then e.g. finish this activity too.
            setFinish();
            finish();
        }
    }

    private void setFinish() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        if (preferences != null) {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("is_first", false);
            editor.apply();
        }
    }
}
