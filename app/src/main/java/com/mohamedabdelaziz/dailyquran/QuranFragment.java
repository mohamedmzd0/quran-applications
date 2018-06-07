package com.mohamedabdelaziz.dailyquran;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;


public class QuranFragment extends Fragment {

    private ViewPager mViewPager;
    private int index = 0;
    MainInterface mainInterface;
    boolean isFab = true;
    private FloatingActionButton floatingActionButton;
    private CardView detaillayout;
    private ImageView settings, toggle;
    private EditText page;
    private ImageView name;

    public void setMainInterface(MainInterface mainInterface) {
        this.mainInterface = mainInterface;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_quran, container, false);
        mViewPager = rootView.findViewById(R.id.viewpager);
        floatingActionButton = rootView.findViewById(R.id.fab_bookmark);
        name = rootView.findViewById(R.id.tv_name);
        page = rootView.findViewById(R.id.tv_page);
        settings = rootView.findViewById(R.id.settings);
        detaillayout = rootView.findViewById(R.id.detaillayout);
        toggle = rootView.findViewById(R.id.toggle);
        mViewPager.setAdapter(new swipe());


        rootView.findViewById(R.id.fab_bookmark).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveBookMark(mViewPager.getCurrentItem());
            }
        });
        if (mainInterface != null)
            mainInterface.hideToolBar();


        if (getArguments() != null && getArguments().getInt("index", -1) != -1) {
            index = getArguments().getInt("index", 603);

        } else {
            index = 603 - getContext().getSharedPreferences("quran", Context.MODE_PRIVATE).getInt("pageP", 603);
        }
        if (index == 292) {
            getContext().getSharedPreferences(String.valueOf(R.string.sharedData), Context.MODE_PRIVATE).edit().putBoolean("alreadyread", true).commit();
        }
        mViewPager.setCurrentItem(603 - index, false);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                viewDetail(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        viewDetail(mViewPager.getCurrentItem());
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), Settings.class));
            }
        });
        viewDetail(mViewPager.getCurrentItem());
        toggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainInterface.toggle();
            }
        });
        page.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == 66)
                    if (TextUtils.isDigitsOnly(page.getText()) && page.getText().length() > 0 && page.getText().length() < 4) {
                        int d = Integer.parseInt(page.getText().toString());
                        if (d < 605 && d > 0)
                            mViewPager.setCurrentItem(604 - d, true);
                        hideKeyboard(getActivity());
                    }
                return false;
            }
        });

        return rootView;
    }


    @Override
    public void onStart() {
        super.onStart();

    }

    private void viewDetail(int p) {
        int position = (603 - p);
        page.setText(String.valueOf(position + 1));
        try {
            InputStream ims = getContext().getAssets().open(generatePos(position));
            Drawable d = Drawable.createFromStream(ims, null);
            name.setImageDrawable(d);

        } catch (IOException ex) {
        }
    }

    private String generatePos(int position) {
        position = position + 1;
        int addr = 1;
        if (position == 1)
            addr = 1;
        else if (position < 50)
            addr = 2;
        else if (position < 77)
            addr = 3;
        else if (position < 106)
            addr = 4;
        else if (position < 128)
            addr = 5;
        else if (position < 151)
            addr = 6;
        else if (position < 177)
            addr = 7;
        else if (position < 187)
            addr = 8;
        else if (position < 208)
            addr = 9;
        else if (position < 221)
            addr = 10;
        else if (position < 235)
            addr = 11;
        else if (position < 249)
            addr = 12;
        else if (position < 255)
            addr = 13;
            //////////////
        else if (position < 262)
            addr = 14;
        else if (position < 267)
            addr = 15;
        else if (position < 282)
            addr = 16;
        else if (position < 293)
            addr = 17;
        else if (position < 305)
            addr = 18;
        else if (position < 312)
            addr = 19;
        else if (position < 322)
            addr = 20;
        else if (position < 332)
            addr = 21;
        else if (position < 342)
            addr = 22;
        else if (position < 350)
            addr = 23;
        else if (position < 359)
            addr = 24;
/////
        else if (position < 367)
            addr = 25;
        else if (position < 377)
            addr = 26;
        else if (position < 385)
            addr = 27;
        else if (position < 396)
            addr = 28;
        else if (position < 404)
            addr = 29;
        else if (position < 411)
            addr = 30;
        else if (position < 415)
            addr = 31;
        else if (position < 418)
            addr = 32;
        else if (position < 428)
            addr = 33;
        else if (position < 434)
            addr = 34;
        else if (position < 440)
            addr = 35;
        else if (position < 446)
            addr = 36;
        else if (position < 453)
            addr = 37;
        else if (position < 458)
            addr = 38;
        else if (position < 467)
            addr = 39;
        else if (position < 477)
            addr = 40;
        else if (position < 483)
            addr = 41;
        else if (position < 489)
            addr = 42;
        else if (position < 496)
            addr = 43;
        else if (position < 499)
            addr = 44;
        else if (position < 502)
            addr = 45;
        else if (position < 507)
            addr = 46;

            /////

        else if (position < 511)
            addr = 47;
        else if (position < 515)
            addr = 48;
        else if (position < 518)
            addr = 49;
        else if (position < 520)
            addr = 50;
        else if (position < 523)
            addr = 51;
        else if (position < 526)
            addr = 52;
        else if (position < 528)
            addr = 53;
        else if (position < 531)
            addr = 54;
        else if (position < 534)
            addr = 55;
        else if (position < 537)
            addr = 56;
        else if (position < 542)
            addr = 57;
////////
        else if (position < 545)
            addr = 58;
        else if (position < 549)
            addr = 59;
        else if (position < 551)
            addr = 60;
        else if (position < 553)
            addr = 61;
        else if (position < 554)
            addr = 62;
        else if (position < 556)
            addr = 63;
        else if (position < 558)
            addr = 64;
        else if (position < 560)
            addr = 65;
        else if (position < 562)
            addr = 66;
        else if (position < 564)
            addr = 67;
        else if (position < 566)
            addr = 68;
        else if (position < 568)
            addr = 69;
            /////
        else if (position < 570)
            addr = 70;
        else if (position < 572)
            addr = 71;
        else if (position < 574)
            addr = 72;
        else if (position < 575)
            addr = 73;
        else if (position < 577)
            addr = 74;
        else if (position < 578)
            addr = 75;
        else if (position < 580)
            addr = 76;
        else if (position < 582)
            addr = 77;
        else if (position < 583)
            addr = 78;
        else if (position < 585)
            addr = 79;
            /////
        else if (position < 586)
            addr = 80;
        else if (position < 587)
            addr = 81;
        else if (position < 589)
            addr = 82;
        else if (position < 590)
            addr = 84;
        else if (position < 591)
            addr = 85;

        else if (position < 592)
            addr = 86;
        else if (position < 593)
            addr = 88;
        else if (position < 594)
            addr = 89;
        else if (position < 595)
            addr = 90;
        else if (position < 596)
            addr = 91;
        else if (position < 597)
            addr = 93;
        else if (position < 598)
            addr = 95;
        else if (position < 599)
            addr = 97;
        else if (position < 600)
            addr = 99;
        else if (position < 601)
            addr = 101;
        else if (position < 602)
            addr = 103;
        else if (position < 603)
            addr = 106;
        else if (position < 604)
            addr = 109;
        else if (position == 604)
            addr = 112;

        /***************/

        return "s" + addr + ".png";
    }

    private String generateName(int ind) {
        ind = ind + 1;
        return "p" + ind + ".png";
    }

    @Override
    public void onPause() {
        super.onPause();
        getContext().getSharedPreferences("quran", Context.MODE_PRIVATE).edit().putInt("pageP", mViewPager.getCurrentItem()).commit();
    }

    public static void hideKeyboard(Activity activity) {
        View v = activity.getWindow().getCurrentFocus();
        if (v != null) {
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
        }
    }

    public class swipe extends PagerAdapter {
        LayoutInflater layoutInflater;

        @Override
        public int getCount() {
            return 604;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return (view == (FrameLayout) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, final int p) {
            int position = 603 - p;
            layoutInflater = (LayoutInflater) getContext().getSystemService(getContext().LAYOUT_INFLATER_SERVICE);
            View view = layoutInflater.inflate(R.layout.image, container, false);
            final ImageView imageView = view.findViewById(R.id.imageview);
            imageView.setBackgroundColor(Color.parseColor("#FFFFFEF8"));

            try {
                InputStream ims = getContext().getAssets().open(generateName(position));
                Drawable d = Drawable.createFromStream(ims, null);
                imageView.setImageDrawable(d);
            } catch (IOException ex) {
                return view;
            }

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isFab) {
                        detaillayout.animate().setDuration(200).scaleY(0);
                        floatingActionButton.animate().setDuration(200).scaleX(0);
                        detaillayout.animate().setDuration(200).scaleX(0);
                        floatingActionButton.animate().setDuration(200).scaleY(0);
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                detaillayout.setVisibility(View.GONE);
                                floatingActionButton.setVisibility(View.GONE);
                            }
                        }, 200);

                    } else {
                        detaillayout.setVisibility(View.VISIBLE);
                        floatingActionButton.setVisibility(View.VISIBLE);
                        floatingActionButton.animate().setDuration(200).scaleX(1);
                        detaillayout.animate().setDuration(200).scaleY(1);
                        floatingActionButton.animate().setDuration(200).scaleY(1);
                        detaillayout.animate().setDuration(200).scaleX(1);
                    }
                    isFab = !isFab;
                }
            });

            container.addView(view);
            return view;
        }


        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((FrameLayout) object);
        }
    }

    private void saveBookMark(int pos) {
        int p = 603 - pos;
        int size = getContext().getSharedPreferences("quran", Context.MODE_PRIVATE).getInt("list", 0);
        getContext().getSharedPreferences("quran", Context.MODE_PRIVATE).edit().putInt("index_" + size, p).commit();
        getContext().getSharedPreferences("quran", Context.MODE_PRIVATE).edit().putString("item_" + size, "صفحه رقم  " + (p + 1)).commit();
        getContext().getSharedPreferences("quran", Context.MODE_PRIVATE).edit().putInt("list", (size + 1)).commit();

        final String[] array = getResources().getStringArray(R.array.taostArray);
        final Toast toast = Toast.makeText(getContext(), "تم حفظ العلامه", Toast.LENGTH_SHORT);
        View toastView = toast.getView();

        TextView toastMessage = (TextView) toastView.findViewById(android.R.id.message);
        toastMessage.setTextSize(16);

        toastMessage.setTextColor(Color.BLACK);
        toastMessage.setGravity(Gravity.CENTER);
        toastMessage.setCompoundDrawablePadding(0);
        toastView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        toast.setGravity(Gravity.BOTTOM, 16, 0);
        toast.show();

    }

}
