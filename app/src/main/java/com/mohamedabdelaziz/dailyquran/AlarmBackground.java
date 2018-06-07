package com.mohamedabdelaziz.dailyquran;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.IBinder;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;

public class AlarmBackground extends Service {
    AlarmManager alarmMgr;
    PendingIntent pendingIntent;

    public AlarmBackground() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Intent intent1 = new Intent(getApplicationContext(), AlarmReceiver.class);
        alarmMgr = (AlarmManager) getSystemService(ALARM_SERVICE);
        pendingIntent = PendingIntent.getBroadcast(getApplicationContext(),
                1, intent1, PendingIntent.FLAG_UPDATE_CURRENT);
        alarmMgr.setRepeating(AlarmManager.RTC, System.currentTimeMillis(), 15 * 1000 * 60,
                pendingIntent);
        read();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }

    @Override
    public void onTaskRemoved(Intent rootIntent) {
        Intent restartService = new Intent(getApplicationContext(),
                this.getClass());
        alarmMgr.cancel(pendingIntent);

        restartService.setPackage(getPackageName());
        PendingIntent restartServicePI = PendingIntent.getService(
                getApplicationContext(), 1, restartService,
                PendingIntent.FLAG_ONE_SHOT);
        AlarmManager alarmService = (AlarmManager) getApplicationContext().getSystemService(Context.ALARM_SERVICE);
        alarmService.set(AlarmManager.ELAPSED_REALTIME, SystemClock.elapsedRealtime() + 5000, restartServicePI);

    }

    private void read() {
        FirebaseDatabase.getInstance().getReference("messg").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot != null) {
                    String text = dataSnapshot.child("m").getValue(String.class);
                    String title = dataSnapshot.child("t").getValue(String.class);
                    if (text == null || title == null)
                        return;
                    if (!getSharedPreferences(String.valueOf(R.string.sharedData), MODE_PRIVATE).getString("messg", "nvl").equals(text)) {
                        getSharedPreferences(String.valueOf(R.string.sharedData), MODE_PRIVATE).edit().putString("messg", text).commit();
                        notifyuser(title, text);
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void notifyuser(String title, String text) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            String id = "notficiation";
            CharSequence name = "notficiation";
            String description = "Notifications from admin";
            int importance = NotificationManager.IMPORTANCE_LOW;
            NotificationChannel mChannel = new NotificationChannel(id, name, importance);
            mChannel.setDescription(description);
            mChannel.enableLights(true);
            mChannel.setLightColor(Color.RED);
            notificationManager.createNotificationChannel(mChannel);

            NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(getApplicationContext(), "notficiation")
                    .setSmallIcon(R.drawable.logo)
                    .setChannelId(id)
                    .setContentTitle(title)
                    .setAutoCancel(true)
                    .setNumber(1)
                    .setColor(255)
                    .setStyle(new NotificationCompat.BigTextStyle()
                            .bigText(text))
                    .setWhen(System.currentTimeMillis());
            notificationManager.notify(5, notificationBuilder.build());
        } else {
            NotificationCompat.Builder mNotifyBuilder = new NotificationCompat.Builder(
                    getApplicationContext()).setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle(title)
                    .setStyle(new NotificationCompat.BigTextStyle()
                            .bigText(text))
                    .setAutoCancel(true).setWhen(Calendar.getInstance().getTimeInMillis());

            NotificationManager mNotifyMgr =
                    (NotificationManager) getApplicationContext().getSystemService(NOTIFICATION_SERVICE);
            mNotifyMgr.notify(5, mNotifyBuilder.build());
        }
    }
}
