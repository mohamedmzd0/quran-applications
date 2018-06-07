package com.mohamedabdelaziz.dailyquran;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

public class Fragment4 extends Fragment {
    private RecyclerView mRecyclerView;
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
        View view = inflater.inflate(R.layout.fragment_recycler, container, false);
        mRecyclerView = view.findViewById(R.id.recycler);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        mRecyclerView.setHasFixedSize(false);


        mRecyclerView.setAdapter(new RecyAdapter(getContext()));
        return view;
    }

    private int getPage(int po) {
        po = po + 1;
        int p = 1;
        if (po == 2)
            p = 2;
        else if (po == 3)
            p = 50;
        else if (po == 4)
            p = 77;
        else if (po == 5)
            p = 106;
        else if (po == 6)
            p = 128;
        else if (po == 7)
            p = 151;
        else if (po == 8)
            p = 177;
        else if (po == 9)
            p = 187;
        else if (po == 10)
            p = 208;
        else if (po == 11)
            p = 221;
        else if (po == 12)
            p = 235;
        else if (po == 13)
            p = 249;
        else if (po == 14)
            p = 255;
        else if (po == 15)
            p = 262;
        else if (po == 16)
            p = 267;
        else if (po == 17)
            p = 282;
        else if (po == 18)
            p = 293;
        else if (po == 19)
            p = 305;
        else if (po == 20)
            p = 312;
        else if (po == 21)
            p = 322;
        else if (po == 22)
            p = 332;
        else if (po == 23)
            p = 342;
        else if (po == 24)
            p = 350;
        else if (po == 25)
            p = 359;
        else if (po == 26)
            p = 367;
        else if (po == 27)
            p = 377;
        else if (po == 28)
            p = 385;
        else if (po == 29)
            p = 396;
        else if (po == 30)
            p = 404;
        else if (po == 31)
            p = 411;
        else if (po == 32)
            p = 415;
        else if (po == 33)
            p = 418;
        else if (po == 34)
            p = 428;
        else if (po == 35)
            p = 434;
        else if (po == 36)
            p = 440;
        else if (po == 37)
            p = 446;
        else if (po == 38)
            p = 453;
        else if (po == 39)
            p = 458;
        else if (po == 40)
            p = 467;
        else if (po == 41)
            p = 477;
        else if (po == 42)
            p = 483;
        else if (po == 43)
            p = 489;
        else if (po == 44)
            p = 496;
        else if (po == 45)
            p = 499;
        else if (po == 46)
            p = 502;
        else if (po == 47)
            p = 507;
        else if (po == 48)
            p = 511;
        else if (po == 49)
            p = 515;
        else if (po == 50)
            p = 518;
        else if (po == 51)
            p = 520;
        else if (po == 52)
            p = 523;
        else if (po == 53)
            p = 526;
        else if (po == 54)
            p = 528;
        else if (po == 55)
            p = 531;
        else if (po == 56)
            p = 534;
        else if (po == 57)
            p = 537;
        else if (po == 58)
            p = 542;
        else if (po == 59)
            p = 545;
        else if (po == 60)
            p = 549;
//
        else if (po == 61)
            p = 551;
        else if (po == 62)
            p = 553;
        else if (po == 63)
            p = 554;
        else if (po == 64)
            p = 556;
        else if (po == 65)
            p = 558;
        else if (po == 66)
            p = 560;
        else if (po == 67)
            p = 562;
        else if (po == 68)
            p = 564;
        else if (po == 69)
            p = 566;
        else if (po == 70)
            p = 568;
        else if (po == 71)
            p = 570;
        else if (po == 72)
            p = 572;
        else if (po == 73)
            p = 574;
        else if (po == 74)
            p = 575;
        else if (po == 75)
            p = 577;
        else if (po == 76)
            p = 578;
        else if (po == 77)
            p = 580;
        else if (po == 78)
            p = 582;
        else if (po == 79)
            p = 583;
        else if (po == 80)
            p = 585;
        else if (po == 81)
            p = 586;
        else if (po == 82)
            p = 587;
        else if (po == 83)
            p = 587;
        else if (po == 84)
            p = 589;
        else if (po == 85)
            p = 590;
        else if (po == 86)
            p = 591;
        else if (po == 87)
            p = 591;
        else if (po == 88)
            p = 592;
        else if (po == 89)
            p = 593;
        else if (po == 90)
            p = 594;
        else if (po == 91)
            p = 595;
        else if (po == 92)
            p = 595;
        else if (po == 93)
            p = 596;
        else if (po == 94)
            p = 596;
        else if (po == 95)
            p = 597;
        else if (po == 96)
            p = 597;
        else if (po == 97)
            p = 598;
        else if (po == 98)
            p = 598;
        else if (po == 99)
            p = 599;
        else if (po == 100)
            p = 599;
        else if (po == 101)
            p = 600;
        else if (po == 102)
            p = 600;
        else if (po == 103)
            p = 601;
        else if (po == 104)
            p = 601;
        else if (po == 105)
            p = 601;
        else if (po == 106)
            p = 602;
        else if (po == 107)
            p = 602;
        else if (po == 108)
            p = 602;
        else if (po == 109)
            p = 603;
        else if (po == 110)
            p = 603;
        else if (po == 111)
            p = 603;
        else if (po == 112)
            p = 604;
        else if (po == 113)
            p = 604;
        else if (po == 114)
            p = 604;
        return p - 1;
    }

    class RecyAdapter extends RecyclerView.Adapter<Holder> {
        Context mContext;


        public RecyAdapter(Context mContext) {
            this.mContext = mContext;
        }

        @NonNull
        @Override
        public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new Holder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, null));
        }

        @Override
        public void onBindViewHolder(@NonNull Holder holder, final int position) {
            holder.itemView.setHasTransientState(false);
            holder.name.setScaleX(.5f);
            holder.name.setScaleY(.5f);
            try {
                InputStream ims = getContext().getAssets().open(generateName(position));
                Drawable d = Drawable.createFromStream(ims, null);
                holder.name.setImageDrawable(d);

            } catch (IOException ex) {
            }
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mainInterface != null)
                        mainInterface.launchQuran(getPage(position));
                }
            });
        }

        private String generateName(int position) {
            position = position + 1;
            return "s" + position + ".png";
        }


        @Override
        public int getItemCount() {
            return 114;
        }

    }

    class Holder extends RecyclerView.ViewHolder {
        ImageView name;

        public Holder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.iv_name);
        }
    }
}
