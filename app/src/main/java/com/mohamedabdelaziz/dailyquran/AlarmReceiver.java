package com.mohamedabdelaziz.dailyquran;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(final Context context, Intent intent) {
        Intent t = new Intent(context, AlarmServices.class);
        context.startService(t);
    }

}
