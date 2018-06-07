package com.mohamedabdelaziz.dailyquran;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Fragment10 extends Fragment {
    TextView tv1, tv2, tv3, tv4, tv5, tv6, tv7, tv8, tv9, tv10, tv11;
    CardView c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11;

    MainInterface mainInterface;

    public void setMainInterface(MainInterface mainInterface) {
        this.mainInterface = mainInterface;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (mainInterface != null)
            mainInterface.showToolBar();


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment1, container, false);
        tv1 = rootView.findViewById(R.id.tv1);
        tv2 = rootView.findViewById(R.id.tv2);
        tv3 = rootView.findViewById(R.id.tv3);
        tv4 = rootView.findViewById(R.id.tv4);
        tv5 = rootView.findViewById(R.id.tv5);
        tv6 = rootView.findViewById(R.id.tv6);
        tv7 = rootView.findViewById(R.id.tv7);
        tv8 = rootView.findViewById(R.id.tv8);
        tv9 = rootView.findViewById(R.id.tv9);
        tv10 = rootView.findViewById(R.id.tv10);
        tv11 = rootView.findViewById(R.id.tv11);

        c1 = rootView.findViewById(R.id.card1);
        c2 = rootView.findViewById(R.id.card2);
        c3 = rootView.findViewById(R.id.card3);
        c4 = rootView.findViewById(R.id.card4);
        c5 = rootView.findViewById(R.id.card5);
        c6 = rootView.findViewById(R.id.card6);
        c7 = rootView.findViewById(R.id.card7);
        c8 = rootView.findViewById(R.id.card8);
        c9 = rootView.findViewById(R.id.card9);
        c10 = rootView.findViewById(R.id.card10);
        c11 = rootView.findViewById(R.id.card11);

        c1.setVisibility(View.VISIBLE);
        tv1.setText(getResources().getString(R.string.text33));
        c2.setVisibility(View.VISIBLE);
        tv2.setText(getResources().getString(R.string.text34));
        c3.setVisibility(View.VISIBLE);
        tv3.setText(getResources().getString(R.string.text35));
        c4.setVisibility(View.VISIBLE);
        tv4.setText(getResources().getString(R.string.text36));
        c5.setVisibility(View.VISIBLE);
        tv5.setText(getResources().getString(R.string.text37));
        c6.setVisibility(View.VISIBLE);
        tv6.setText(getResources().getString(R.string.text38));
        c7.setVisibility(View.VISIBLE);
        tv7.setText(getResources().getString(R.string.text39));
        c8.setVisibility(View.VISIBLE);
        tv8.setText(getResources().getString(R.string.text40));
        c9.setVisibility(View.VISIBLE);
        tv9.setText(getResources().getString(R.string.text41));
        c10.setVisibility(View.VISIBLE);
        tv10.setText(getResources().getString(R.string.text42));
        c11.setVisibility(View.VISIBLE);
        tv11.setText(getResources().getString(R.string.text43));

        return rootView;
    }
}
