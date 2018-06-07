package com.mohamedabdelaziz.dailyquran;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.FirebaseDatabase;

import java.util.Random;

public class BootREceiver extends BroadcastReceiver {

    private SharedPreferences sharedPreferences;

    @Override
    public void onReceive(Context context, Intent intent) {
        if (!isMyServiceRunning(AlarmBackground.class, context)) {
            context.startService(new Intent(context, AlarmBackground.class));
        }
        sharedPreferences = context.getSharedPreferences(String.valueOf(R.string.sharedData), Context.MODE_PRIVATE);
        if (sharedPreferences.getBoolean(String.valueOf(R.string.moslm), true)) {
            final String[] array = context.getResources().getStringArray(R.array.taostArray);
            final Toast toast = Toast.makeText(context, array[new Random().nextInt(array.length - 1)], Toast.LENGTH_LONG);
            View toastView = toast.getView();

            TextView toastMessage = (TextView) toastView.findViewById(android.R.id.message);
            toastMessage.setTextSize(20);

            toastMessage.setTextColor(Color.WHITE);
            toastMessage.setGravity(Gravity.CENTER);
            toastMessage.setCompoundDrawablePadding(0);
            toastView.setBackgroundColor(Color.parseColor("#99D66DFC"));
            toast.setGravity(Gravity.TOP, 16, 0);
            toast.show();
            new CountDownTimer(5000, 1000) {
                public void onTick(long millisUntilFinished) {
                    toast.show();
                }

                public void onFinish() {
                    toast.cancel();
                }
            }.start();

        }
    }


    private boolean isMyServiceRunning(Class<?> serviceClass, Context context) {
        ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }

}
