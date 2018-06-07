package com.mohamedabdelaziz.dailyquran;

import android.Manifest;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class Settings extends AppCompatActivity {
    private static final int MY_PERMISSIONS_REQUEST = 100;
    String username = "private";
    private Switch sw_daily_quran, sw_moslm, sw_azkar, sw_salah, sw_kahf;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private TextView textView;
    private RadioButton rb_pm, rb_am, rb_hour, rb_half, rb_quart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_settings);
        sharedPreferences = getSharedPreferences(String.valueOf(R.string.sharedData), MODE_PRIVATE);
        editor = sharedPreferences.edit();
        sw_daily_quran = findViewById(R.id.sw_daily_quran);
        sw_moslm = findViewById(R.id.sw_moslm);
        sw_azkar = findViewById(R.id.sw_azkar);
        sw_salah = findViewById(R.id.sw_salah);
        sw_kahf = findViewById(R.id.sw_kahf);
        textView = findViewById(R.id.tv_time);
        rb_pm = findViewById(R.id.rb_pm);
        rb_am = findViewById(R.id.rb_am);
        rb_quart = findViewById(R.id.rb_3);
        rb_half = findViewById(R.id.rb_2);
        rb_hour = findViewById(R.id.rb_1);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        try {
            FirebaseDatabase.getInstance().setPersistenceEnabled(true);
            FirebaseDatabase.getInstance().getReference("response").keepSynced(true);
        } catch (Exception e) {
        }
        sw_daily_quran.setChecked(sharedPreferences.getBoolean(String.valueOf(R.string.dailyQuran), true));
        sw_moslm.setChecked(sharedPreferences.getBoolean(String.valueOf(R.string.moslm), true));
        sw_azkar.setChecked(sharedPreferences.getBoolean(String.valueOf(R.string.azkar), true));
        sw_salah.setChecked(sharedPreferences.getBoolean(String.valueOf(R.string.salah), true));
        sw_kahf.setChecked(sharedPreferences.getBoolean(String.valueOf(R.string.kahf), true));

        int salahp = sharedPreferences.getInt(String.valueOf(R.string.salahP), 15);
        if (salahp == 15)
            rb_quart.setChecked(true);
        else if (salahp == 30)
            rb_half.setChecked(true);
        else rb_hour.setChecked(true);

        rb_hour.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    editor.putInt(String.valueOf(R.string.salahP), 60).commit();
                    restartServices();
                }
            }
        });
        rb_half.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    editor.putInt(String.valueOf(R.string.salahP), 30).commit();
                    restartServices();
                }
            }
        });
        rb_quart.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    editor.putInt(String.valueOf(R.string.salahP), 15).commit();
                    restartServices();
                }
            }
        });
        int h = sharedPreferences.getInt(String.valueOf(R.string.hour), 22);
        if (h > 12)

        {
            textView.setText("" + (h - 12));
            rb_pm.setChecked(true);
        } else

        {
            textView.setText("" + h);
            rb_am.setChecked(true);
        }

        sw_kahf.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()

        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                editor.putBoolean(String.valueOf(R.string.kahf), isChecked).commit();
            }
        });
        sw_daily_quran.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()

        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(Settings.this, "الورد اليومي الساعه" + sharedPreferences.getInt(String.valueOf(R.string.hour), 22), Toast.LENGTH_SHORT).show();
                }

                editor.putBoolean(String.valueOf(R.string.dailyQuran), isChecked).commit();
            }
        });
        sw_salah.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()

        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                editor.putBoolean(String.valueOf(R.string.salah), isChecked).commit();
            }
        });
        sw_moslm.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()

        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                editor.putBoolean(String.valueOf(R.string.moslm), isChecked).commit();
            }
        });
        sw_azkar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()

        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                editor.putBoolean(String.valueOf(R.string.azkar), isChecked).commit();
            }
        });


        if (ContextCompat.checkSelfPermission(Settings.this,
                Manifest.permission.GET_ACCOUNTS)
                != PackageManager.PERMISSION_GRANTED) {
            getUsername();
            if (ActivityCompat.shouldShowRequestPermissionRationale(Settings.this,
                    Manifest.permission.GET_ACCOUNTS)) {
                ActivityCompat.requestPermissions(Settings.this,
                        new String[]{Manifest.permission.GET_ACCOUNTS},
                        MY_PERMISSIONS_REQUEST);
            } else {
                ActivityCompat.requestPermissions(Settings.this,
                        new String[]{Manifest.permission.GET_ACCOUNTS},
                        MY_PERMISSIONS_REQUEST);
            }
        } else {
            getUsername();
        }

    }

    private void restartServices() {
        final Intent intent = new Intent(getApplicationContext(), AlarmBackground.class);
        stopService(intent);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                try {
                    if (!isMyServiceRunning(AlarmBackground.class))
                        startService(intent);
                    else restartServices();
                    Toast.makeText(Settings.this, "تم ضبط التنبيه", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                }
            }
        }, 100);
    }

    private boolean isMyServiceRunning(Class<?> serviceClass) {
        ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }

    private void getUsername() {
        final AccountManager manager = AccountManager.get(this);
        final Account[] accounts = manager.getAccountsByType("com.google");
        final int size = accounts.length;
        String[] names = new String[size];
        for (int i = 0; i < size; i++) {
            names[i] = accounts[i].name;
        }
        if (names.length > 0)
            username = names[0];

    }

    public void save(View view) {
        if (textView.getText().length() == 0)
            textView.setError("يرجي تحديد الوقت");
        else if (textView.length() > 2)
            textView.setError("الوقت غير صحيح");
        else {
            if (TextUtils.isDigitsOnly(textView.getText())) {
                if (Integer.parseInt(textView.getText().toString()) > 12 || Integer.parseInt(textView.getText().toString()) <= 0)
                    textView.setError("وقت غير صالح");
                else {
                    int h = Integer.parseInt(textView.getText().toString());
                    if (rb_pm.isChecked())
                        h += 12;
                    editor.putInt(String.valueOf(R.string.hour), h).commit();
                    Toast.makeText(Settings.this, "تم ضبط الوقت" + h, Toast.LENGTH_SHORT).show();
                }
            } else
                textView.setError("وقت غير صالح");
        }
    }

    public void send(View view) {
        String text = ((TextView) findViewById(R.id.tv)).getText().toString();
        if (text.length() > 3) {
            Model model = new Model();
            model.setEmail(username);
            model.setMessage(text);
            model.setDate("" + Calendar.getInstance().HOUR_OF_DAY + " : " + Calendar.getInstance().MINUTE + "\n" + Calendar.getInstance().DAY_OF_MONTH + "/" + Calendar.getInstance().MONTH + "/" + Calendar.getInstance().YEAR);
            FirebaseDatabase.getInstance().getReference("response").push().setValue(model);
            ((TextView) findViewById(R.id.tv)).setText("");
            Toast.makeText(Settings.this, "تمت الاضافه", Toast.LENGTH_SHORT).show();
        } else
            Toast.makeText(Settings.this, "رساله غير صالحه", Toast.LENGTH_SHORT).show();

    }


}
