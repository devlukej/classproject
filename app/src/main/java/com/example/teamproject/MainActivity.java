package com.example.teamproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    TextView tvLight;

    private boolean swData;

    private Switch swBtn;

    private SharedPreferences appData;


    private SensorManager mySensorManager;
    private SensorEventListener gyroListener;
    private Sensor myGyroscope;
    private SensorManager sensorManager;
    private Sensor lightSensor;
    private SensorEventListener lightListener;


    private double roll;
    private double pitch;
    private double yaw;

    private double timestamp = 0.0;
    private double dt;

    private double rad_to_dgr = 180 / Math.PI;
    private static final float NS2S = 1.0f / 1000000000.0f;

    TextView x;
    TextView y;
    TextView z;

    protected void onResume() {
        super.onResume();
        mySensorManager.registerListener(gyroListener, myGyroscope, SensorManager.SENSOR_DELAY_UI);
        sensorManager.registerListener(lightListener, lightSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    protected void onPause() {
        super.onPause();
        mySensorManager.unregisterListener(gyroListener);
        sensorManager.unregisterListener(lightListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Vibrator vib = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        ImageView imgView = (ImageView) findViewById(R.id.imgView);


        ////////////////////////////조도센서////////////////////////////////

        tvLight = (TextView) findViewById(R.id.tvLight);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

        lightListener = new SensorEventListener() {

            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {

                //String tvLight2 = (String.valueOf(sensorEvent.values[0]));

                if (sensorEvent.sensor.getType() == Sensor.TYPE_LIGHT) {
                    tvLight.setText((String.valueOf(sensorEvent.values[0])));
                }
                if (roll*rad_to_dgr > -60 && roll*rad_to_dgr < 60 && pitch*rad_to_dgr > -60 && pitch*rad_to_dgr < 60 && yaw*rad_to_dgr > -60 && yaw*rad_to_dgr < 60 && sensorEvent.values[0] < 150 && swBtn.isChecked()){
                    vib.vibrate(new long[]{5000,1000,500,1000,500,1000},-1);
                    imgView.setImageResource(R.drawable.no);

                } else {
                    imgView.setImageResource(R.drawable.ok);

                }
                if(swBtn.isChecked() == false) {
                    if (roll*rad_to_dgr > -60 && roll*rad_to_dgr < 60 && pitch*rad_to_dgr > -60 && pitch*rad_to_dgr < 60 && yaw*rad_to_dgr > -60 && yaw*rad_to_dgr < 60 && sensorEvent.values[0] < 150){
                        imgView.setImageResource(R.drawable.no);

                    } else {
                        imgView.setImageResource(R.drawable.ok);

                    }
                }

            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        };


        ///////////////////////////자이로센서///////////////////////////////

        x = (TextView) findViewById(R.id.x);
        y = (TextView) findViewById(R.id.y);
        z = (TextView) findViewById(R.id.z);

        mySensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        myGyroscope = mySensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        gyroListener = new SensorEventListener() {

            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                double gyroX = sensorEvent.values[0];
                double gyroY = sensorEvent.values[1];
                double gyroZ = sensorEvent.values[2];

                dt = (sensorEvent.timestamp - timestamp) * NS2S;
                timestamp = sensorEvent.timestamp;

                if (dt - timestamp * NS2S != 0) {
                    pitch = pitch + gyroY * dt;
                    roll = roll + gyroX * dt;
                    yaw = yaw + gyroZ * dt;

                    x.setText("x : " + String.format("%.1f", roll * rad_to_dgr));    //일단 이렇게 표기하고
                    y.setText("y : " + String.format("%.1f", pitch * rad_to_dgr));
                    z.setText("z : " + String.format("%.1f", yaw * rad_to_dgr));
                }

            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        };


        /////////////////////////////메인/////////////////////////////////


        appData = getSharedPreferences("appData", MODE_PRIVATE);
        load();

        swBtn = (Switch) findViewById(R.id.switch1);


        Button btnPosition = (Button) findViewById(R.id.BtnPosition);
        Button btnStretch = (Button) findViewById(R.id.BtnStretch);


        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_SCREEN_OFF);
        intentFilter.addAction(Intent.ACTION_SCREEN_ON);

        PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
        boolean isScreenOn = pm.isInteractive();


        if (swData) {
            swBtn.setChecked(swData);
        }

        swBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    save();
            }
        });


        if (isScreenOn) {
            Log.e("MainActivity", "isScreen On");
        } else {
            Log.e("MainActivity", "isScreen Off");
        }

        registerReceiver(screenOnOff, intentFilter);


        btnPosition.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PositionActivity.class);
                startActivity(intent);

                finish();
            }
        });
        btnStretch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), StretchActivity.class);
                startActivity(intent);

                finish();
            }
        });
    }  //////////////////////////onCreate End

    BroadcastReceiver screenOnOff = new BroadcastReceiver() {
        public static final String ScreenOff = "android.intent.action.SCREEN_OFF";
        public static final String ScreenOn = "android.intent.action.SCREEN_ON";

        public void onReceive(Context contex, Intent intent) {
            if (intent.getAction().equals(ScreenOff)) {
                Log.e("MainActivity", "Screen Off");
            } else if (intent.getAction().equals(ScreenOn)) {
                Log.e("MainActivity", "Screen On");

            }
        }
    };

        private void save () {
            SharedPreferences.Editor editor = appData.edit();

            editor.putBoolean("SW_DATA", swBtn.isChecked());

            editor.apply();
        }


        private void load () {
            swData = appData.getBoolean("SW_DATA", false);
        }


        @Override
        protected void onDestroy () {
            super.onDestroy();
            unregisterReceiver(screenOnOff);
        }
    }