package com.mohamedabdelaziz.dailyquran;

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
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class Fragment5 extends Fragment {
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
        mRecyclerView.setAdapter(new RecyAdapter());
        return view;
    }

    class RecyAdapter extends RecyclerView.Adapter<Holder> {

        @NonNull
        @Override
        public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new Holder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item2, null));
        }

        @Override
        public void onBindViewHolder(@NonNull Holder holder, final int position) {
            holder.itemView.setHasTransientState(false);
            try {
                InputStream ims = getContext().getAssets().open(generateName(position));
                Drawable d = Drawable.createFromStream(ims, null);
                holder.name.setImageDrawable(d);

            } catch (IOException ex) {
            }
            holder.index.setText("" + (position + 1));
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainInterface.launchQuran((position + 1));
                }
            });
        }

        private String generateName(int position) {
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


        @Override
        public int getItemCount() {
            return 604;
        }

    }

    class Holder extends RecyclerView.ViewHolder {
        ImageView name;
        TextView index;

        public Holder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.iv_name);
            index = itemView.findViewById(R.id.tv_index);
        }
    }
}
