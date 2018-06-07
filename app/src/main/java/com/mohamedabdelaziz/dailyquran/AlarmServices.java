package com.mohamedabdelaziz.dailyquran;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;

import java.util.Calendar;
import java.util.Date;

public class AlarmServices extends Service {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    NotificationManager notificationManagerKahf;

    public AlarmServices() {

    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        int targettime = (getSharedPreferences(String.valueOf(R.string.sharedData), MODE_PRIVATE).getInt(String.valueOf(R.string.salahP), 15) - 2) * 60 * 1000;
        sharedPreferences = getSharedPreferences(String.valueOf(R.string.sharedData), MODE_PRIVATE);
        editor = sharedPreferences.edit();
        notificationManagerKahf = (NotificationManager) getApplicationContext()
                .getSystemService(NOTIFICATION_SERVICE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                AlarmServices.this.stopSelf();
            }
        }, 10000);

        int hour = new Date().getHours();
        if (hour == sharedPreferences.getInt(String.valueOf(R.string.hour), 22) &&
                sharedPreferences.getInt("dailyp", -1) !=
                        new Date().getDay()) {
            if (sharedPreferences.getBoolean(String.valueOf(R.string.dailyQuran), true)) {
                long when = System.currentTimeMillis();
                Intent intent1 = new Intent(getApplicationContext(), MainActivity.class);
                NotificationManager notificationManager = (NotificationManager) getApplicationContext()
                        .getSystemService(NOTIFICATION_SERVICE);
                intent1.putExtra("index", getApplicationContext()
                        .getSharedPreferences("quran", getApplicationContext().MODE_PRIVATE).getInt("page", 0));
                Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                NotificationCompat.Builder mNotifyBuilder = new NotificationCompat.Builder(
                        getApplicationContext()).setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("وردك اليومي")
                        .setContentText("لاتنس وردك اليومي").setSound(alarmSound)
                        .setAutoCancel(true).setWhen(when)
                        .setVibrate(new long[]{200, 200, 200, 200, 200});

                PendingIntent contentIntent = PendingIntent.getActivity(getApplicationContext(), 0,
                        intent1, PendingIntent.FLAG_UPDATE_CURRENT);
                mNotifyBuilder.setContentIntent(contentIntent);
                notificationManager.notify(4, mNotifyBuilder.build());
                editor.putInt("dailyp", new Date().getDay()).commit();
            }
        }
        if ((hour == 7 || hour == 19) && sharedPreferences.getInt("azkarp", -1) !=
                Calendar.getInstance().DAY_OF_MONTH + hour) {
            if (sharedPreferences.getBoolean(String.valueOf(R.string.azkar), true)) {
                long when = System.currentTimeMillis();
                Intent intent1 = new Intent(getApplicationContext(), MainActivity.class);
                NotificationManager notificationManager = (NotificationManager) getApplicationContext()
                        .getSystemService(NOTIFICATION_SERVICE);
                String title = "";
                if (new Date().getHours() == 7) {
                    title = "ازكار الصباح";
                    intent1.putExtra("azkar", 1);
                }
                if (new Date().getHours() == 19) {
                    title = "ازكار المساء";
                    intent1.putExtra("azkar", 2);
                }
                editor.putInt("azkarp", Calendar.getInstance().DAY_OF_MONTH + hour).commit();
                Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                PendingIntent contentIntent = PendingIntent.getActivity(getApplicationContext(), 0,
                        intent1, PendingIntent.FLAG_UPDATE_CURRENT);
                NotificationCompat.Builder mNotifyBuilder = new NotificationCompat.Builder(
                        getApplicationContext()).setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("وردك اليومي")
                        .setContentText(title).setSound(alarmSound)
                        .setAutoCancel(true).setWhen(when)
                        .setVibrate(new long[]{200, 200, 200, 200, 200})
                        .setContentIntent(contentIntent);

                notificationManager.notify(3, mNotifyBuilder.build());

            }
        }
        if (hour < 23 && hour >= 7) {
            long lastt = sharedPreferences.getLong("lastn", -1);
            long thistime = new Date().getTime();

            if (!((lastt + targettime) >= thistime && (lastt - targettime) <= thistime)) {
                editor.putLong("lastn", thistime).commit();
                if (sharedPreferences.getBoolean(String.valueOf(R.string.salah), true)) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        CharSequence name = "CHANNEL_NAME";
                        Notification.Builder builder = new Notification.Builder(this, "notficiation")
                                .setContentTitle(getString(R.string.app_name))
                                .setContentText("صلي علي محمد")
                                .setAutoCancel(true);
                        Notification notification = builder.build();
                        startForeground(1010, notification);

                    } else {
                        Notification notification = new Notification.Builder(getApplicationContext())
                                .setContentTitle(getString(R.string.app_name))
                                .setContentText("صلي علي محمد")
                                .setSmallIcon(R.drawable.logo)
                                .setWhen(System.currentTimeMillis())
                                .build();
                        startForeground(1010, notification);
                    }
                    MediaPlayer m = new MediaPlayer();
                    try {
                        AssetFileDescriptor descriptor = getApplicationContext().getAssets().openFd("s.mp3");
                        m.setDataSource(descriptor.getFileDescriptor(), descriptor.getStartOffset(), descriptor.getLength());
                        descriptor.close();
                        m.prepare();
                        m.start();

                    } catch (Exception e) {
                    }

                }
            }
        }
        if (sharedPreferences.getBoolean(String.valueOf(R.string.kahf), true))
            if (new Date().getDay() == 5) {
                if (sharedPreferences.getInt("kahfb", -1) != new Date().getDate()) {
                    Intent intent1 = new Intent(getApplicationContext(), MainActivity.class);
                    intent1.putExtra("index", 292);
                    PendingIntent contentIntent = PendingIntent.getActivity(getApplicationContext(), 0,
                            intent1, PendingIntent.FLAG_UPDATE_CURRENT);
                    NotificationCompat.Builder mNotifyBuilderKahf = new NotificationCompat.Builder(
                            getApplicationContext()).setSmallIcon(R.mipmap.ic_launcher)
                            .setContentTitle("لا تنس قراه سورة الكهف")
                            .setOngoing(true)
                            .setContentIntent(contentIntent)
                            .setStyle(new NotificationCompat.BigTextStyle()
                                    .bigText("مَن قرأَ سورةَ الكَهْفِ ليلةَ الجمعةِ، أضاءَ لَهُ منَ النُّورِ فيما بينَهُ وبينَ البَيتِ العَتيقِ"))
                            .setAutoCancel(false).setWhen(System.currentTimeMillis());
                    notificationManagerKahf.notify(2, mNotifyBuilderKahf.build());
                    editor.putInt("kahfb", new Date().getDate()).commit();
                } else if (sharedPreferences.getBoolean("alreadyread", false) == true) {
                    try {
                        notificationManagerKahf.cancel(2);
                    } catch (Exception e) {

                    }
                }
            }

        return super.onStartCommand(intent, flags, startId);
    }


}
