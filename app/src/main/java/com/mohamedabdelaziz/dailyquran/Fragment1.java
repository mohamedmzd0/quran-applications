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

public class Fragment1 extends Fragment {
    TextView tv1, tv2, tv3, tv4, tv5, tv6, tv7, tv8, tv9, tv10, tv11, tv12, tv13, tv14, tv15, tv16, tv17, tv18, tv19, tv20, tv21, tv22, tv23;
    CardView c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20, c21, c22, c23;
    MainInterface mainInterface;

    public void setMainInterface(MainInterface mainInterface) {
        this.mainInterface = mainInterface;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (mainInterface != null)
            mainInterface.showToolBar();
        c2.setVisibility(View.VISIBLE);
        tv2.setText(getResources().getString(R.string.text12));
        c3.setVisibility(View.VISIBLE);
        tv3.setText(getResources().getString(R.string.text13));
        c4.setVisibility(View.VISIBLE);
        tv4.setText(getResources().getString(R.string.text14));
        c5.setVisibility(View.VISIBLE);
        tv5.setText(getResources().getString(R.string.text15));
        c6.setVisibility(View.VISIBLE);
        tv6.setText(getResources().getString(R.string.text16));
        c7.setVisibility(View.VISIBLE);
        tv7.setText(getResources().getString(R.string.text17));
        c8.setVisibility(View.VISIBLE);
        tv8.setText(getResources().getString(R.string.text18));
        c9.setVisibility(View.VISIBLE);
        tv9.setText(getResources().getString(R.string.text19));
        c10.setVisibility(View.VISIBLE);
        tv10.setText(getResources().getString(R.string.text20));
        c12.setVisibility(View.VISIBLE);
        tv12.setText(getResources().getString(R.string.text22));
        c13.setVisibility(View.VISIBLE);
        tv13.setText(getResources().getString(R.string.text23));
        c14.setVisibility(View.VISIBLE);
        tv14.setText(getResources().getString(R.string.text24));
        c15.setVisibility(View.VISIBLE);
        tv15.setText(getResources().getString(R.string.text25));
        c16.setVisibility(View.VISIBLE);
        tv16.setText(getResources().getString(R.string.text26));
        c17.setVisibility(View.VISIBLE);
        tv17.setText(getResources().getString(R.string.text27));
        c18.setVisibility(View.VISIBLE);
        tv18.setText(getResources().getString(R.string.text28));
        c19.setVisibility(View.VISIBLE);
        tv19.setText(getResources().getString(R.string.text29));
        c20.setVisibility(View.VISIBLE);
        tv20.setText(getResources().getString(R.string.text30));
        c21.setVisibility(View.VISIBLE);
        tv21.setText(getResources().getString(R.string.text30));
        c22.setVisibility(View.VISIBLE);
        tv22.setText(getResources().getString(R.string.text31));
        c23.setVisibility(View.VISIBLE);
        tv23.setText(getResources().getString(R.string.text32));

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
        tv12 = rootView.findViewById(R.id.tv12);
        tv13 = rootView.findViewById(R.id.tv13);
        tv14 = rootView.findViewById(R.id.tv14);
        tv15 = rootView.findViewById(R.id.tv15);
        tv16 = rootView.findViewById(R.id.tv16);
        tv17 = rootView.findViewById(R.id.tv17);
        tv18 = rootView.findViewById(R.id.tv18);
        tv19 = rootView.findViewById(R.id.tv19);
        tv20 = rootView.findViewById(R.id.tv20);

        tv21 = rootView.findViewById(R.id.tv21);
        tv22 = rootView.findViewById(R.id.tv22);
        tv23 = rootView.findViewById(R.id.tv23);

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
        c12 = rootView.findViewById(R.id.card12);
        c13 = rootView.findViewById(R.id.card13);
        c14 = rootView.findViewById(R.id.card14);
        c15 = rootView.findViewById(R.id.card15);
        c16 = rootView.findViewById(R.id.card16);
        c17 = rootView.findViewById(R.id.card17);
        c18 = rootView.findViewById(R.id.card18);
        c19 = rootView.findViewById(R.id.card19);
        c20 = rootView.findViewById(R.id.card20);

        c21 = rootView.findViewById(R.id.card21);
        c22 = rootView.findViewById(R.id.card22);
        c23 = rootView.findViewById(R.id.card23);


        return rootView;
    }
}
