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

public class Fragment6 extends Fragment {
    TextView tv1, tv2, tv3, tv4, tv5, tv6, tv7, tv8, tv9, tv10, tv11, tv12, tv13, tv14, tv15, tv16, tv17, tv18, tv19, tv20, tv21, tv22, tv23, tv24, tv25, tv26, tv27, tv28, tv29, tv30, tv31, tv32, tv33;
    CardView c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20, c21, c22, c23, c24, c25, c26, c27, c28, c29, c30, c31, c32, c33;
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
        tv24 = rootView.findViewById(R.id.tv24);
        tv25 = rootView.findViewById(R.id.tv25);
        tv26 = rootView.findViewById(R.id.tv26);
        tv27 = rootView.findViewById(R.id.tv27);
        tv28 = rootView.findViewById(R.id.tv28);
        tv29 = rootView.findViewById(R.id.tv29);
        tv30 = rootView.findViewById(R.id.tv30);
        tv31 = rootView.findViewById(R.id.tv31);
        tv32 = rootView.findViewById(R.id.tv32);
        tv33 = rootView.findViewById(R.id.tv33);

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
        c24 = rootView.findViewById(R.id.card24);
        c25 = rootView.findViewById(R.id.card25);
        c26 = rootView.findViewById(R.id.card26);
        c27 = rootView.findViewById(R.id.card27);
        c28 = rootView.findViewById(R.id.card28);
        c29 = rootView.findViewById(R.id.card29);
        c30 = rootView.findViewById(R.id.card30);
        c31 = rootView.findViewById(R.id.card31);
        c32 = rootView.findViewById(R.id.card32);
        c33 = rootView.findViewById(R.id.card33);

        c2.setVisibility(View.VISIBLE);
        tv2.setText(getResources().getString(R.string.text61));
        c3.setVisibility(View.VISIBLE);
        tv3.setText(getResources().getString(R.string.text62));
        c4.setVisibility(View.VISIBLE);
        tv4.setText(getResources().getString(R.string.text63));
        c5.setVisibility(View.VISIBLE);
        tv5.setText(getResources().getString(R.string.text64));
        c6.setVisibility(View.VISIBLE);
        tv6.setText(getResources().getString(R.string.text65));
        c7.setVisibility(View.VISIBLE);
        tv7.setText(getResources().getString(R.string.text66));
        c8.setVisibility(View.VISIBLE);
        tv8.setText(getResources().getString(R.string.text67));
        c9.setVisibility(View.VISIBLE);
        tv9.setText(getResources().getString(R.string.text68));
        c10.setVisibility(View.VISIBLE);
        tv10.setText(getResources().getString(R.string.text69));
        c11.setVisibility(View.VISIBLE);
        tv11.setText(getResources().getString(R.string.text610));
        c12.setVisibility(View.VISIBLE);
        tv12.setText(getResources().getString(R.string.text611));
        c13.setVisibility(View.VISIBLE);
        tv13.setText(getResources().getString(R.string.text612));
        c14.setVisibility(View.VISIBLE);
        tv14.setText(getResources().getString(R.string.text613));
        c15.setVisibility(View.VISIBLE);
        tv15.setText(getResources().getString(R.string.text614));
        c16.setVisibility(View.VISIBLE);
        tv16.setText(getResources().getString(R.string.text615));

        c17.setVisibility(View.VISIBLE);
        tv17.setText(getResources().getString(R.string.text616));
        c18.setVisibility(View.VISIBLE);
        tv18.setText(getResources().getString(R.string.text617));
        c19.setVisibility(View.VISIBLE);
        tv19.setText(getResources().getString(R.string.text618));
        c20.setVisibility(View.VISIBLE);
        tv20.setText(getResources().getString(R.string.text619));
        c21.setVisibility(View.VISIBLE);
        tv21.setText(getResources().getString(R.string.text620));
        c22.setVisibility(View.VISIBLE);
        tv22.setText(getResources().getString(R.string.text621));
        c23.setVisibility(View.VISIBLE);
        tv23.setText(getResources().getString(R.string.text622));
        c24.setVisibility(View.VISIBLE);
        tv24.setText(getResources().getString(R.string.text623));
        c25.setVisibility(View.VISIBLE);
        tv25.setText(getResources().getString(R.string.text624));
        c26.setVisibility(View.VISIBLE);
        tv26.setText(getResources().getString(R.string.text625));
        c27.setVisibility(View.VISIBLE);
        tv27.setText(getResources().getString(R.string.text626));
        c28.setVisibility(View.VISIBLE);
        tv28.setText(getResources().getString(R.string.text627));
        c29.setVisibility(View.VISIBLE);
        tv29.setText(getResources().getString(R.string.text628));
        c30.setVisibility(View.VISIBLE);
        tv30.setText(getResources().getString(R.string.text629));
        c31.setVisibility(View.VISIBLE);
        tv31.setText(getResources().getString(R.string.text630));
        c32.setVisibility(View.VISIBLE);
        tv32.setText(getResources().getString(R.string.text631));
        return rootView;
    }
}
