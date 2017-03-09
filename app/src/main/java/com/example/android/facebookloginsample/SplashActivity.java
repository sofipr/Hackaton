package com.example.android.facebookloginsample;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.android.facebookloginsample.LoginActivity;

public class SplashActivity extends Activity {

    private static int SPLASH_TIME_OUT = 3000;

    ProgressBar bar;
    TextView txt;
    int total = 0;
    boolean isRunning = false;
    // handler for the background updating
     Handler handler = new Handler();

      /*  public void handleMessage(Message msg) {
            total = total + 5;
            String perc = String.valueOf(total).toString();
            txt.setText("Loading..."+perc + " %");
            TextView nameverval=(TextView ) findViewById(R.id.never);
            Typeface light = Typeface.create("sans-serif-light", Typeface.NORMAL);
            nameverval.setTypeface(light);
            nameverval.setText(getString(R.string.app_name) + " V " +getVersion());

            if(perc.equalsIgnoreCase("100"))
            {
                Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(intent);
                SplashActivity.this.finish();
            }
            bar.incrementProgressBy(5);
        }

    };
    private String getVersion() {
        String version = "";
        try {
            PackageInfo pInfo = getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_META_DATA);
            version = pInfo.versionName;
        } catch (PackageManager.NameNotFoundException e1) {
            Log.e(this.getClass().getSimpleName(), "Name not found", e1);
        }
        return version;
    }
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        bar = (ProgressBar) findViewById(R.id.com_facebook_login_activity_progress_bar);
        txt = (TextView) findViewById(R.id.textView);

        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(i);

                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
    public void onStart() {
        super.onStart();
// reset the bar to the default value of 0
//        bar.setProgress(0);
// create a thread for updating the progress bar
        Thread background = new Thread(new Runnable() {
            public void run() {
                try {
                    for (int i = 0; i < 20 && isRunning; i++) {
// wait 1000ms between each update
                        Thread.sleep(200);

                    }
                }
                catch (Throwable t) {              }            }       });
        isRunning = true;
// start the background thread
        background.start();
    }
    public void onStop() {
        super.onStop();
    }}
