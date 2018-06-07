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

public class Fragment3 extends Fragment {
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
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainInterface.launchQuran(getJ(position));
                }
            });
            try {
                InputStream ims = getContext().getAssets().open(generateName(position));
                Drawable d = Drawable.createFromStream(ims, null);
                holder.name.setImageDrawable(d);
            } catch (IOException ex) {
            }
        }

        private int getJ(int position) {
            int j = 1;
            position += 1;
            if (position == 1)
                j = 1;
            else if (position == 2)
                j = 22;
            else if (position == 3)
                j = 42;
            else if (position == 4)
                j = 62;
            else if (position == 5)
                j = 82;
            else if (position == 6)
                j = 102;
            else if (position == 7)
                j = 121;
            else if (position == 8)
                j = 142;
            else if (position == 9)
                j = 162;
            else if (position == 10)
                j = 182;
            else if (position == 11)
                j = 201;
            else if (position == 12)
                j = 222;
            else if (position == 13)
                j = 242;
            else if (position == 14)
                j = 262;
            else if (position == 15)
                j = 282;
            else if (position == 16)
                j = 302;
            else if (position == 17)
                j = 322;
            else if (position == 18)
                j = 342;
            else if (position == 19)
                j = 362;
            else if (position == 20)
                j = 382;
            else if (position == 21)
                j = 402;
            else if (position == 22)
                j = 422;
            else if (position == 23)
                j = 442;
            else if (position == 24)
                j = 462;
            else if (position == 25)
                j = 482;
            else if (position == 26)
                j = 502;
            else if (position == 27)
                j = 522;
            else if (position == 28)
                j = 542;
            else if (position == 29)
                j = 562;
            else if (position == 30)
                j = 582;
            return j;
        }

        private String generateName(int position) {
            position += 1;
            return "j" + position + ".png";
        }


        @Override
        public int getItemCount() {
            return 30;
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
