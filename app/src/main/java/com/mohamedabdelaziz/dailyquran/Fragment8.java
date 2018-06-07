package com.mohamedabdelaziz.dailyquran;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Fragment8 extends Fragment {
    private RecyclerView mRecyclerView;
    MainInterface mainInterface;
    ArrayList<String> strings = new ArrayList<>();

    public void setMainInterface(MainInterface mainInterface) {
        this.mainInterface = mainInterface;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_recycler, container, false);
        mRecyclerView = view.findViewById(R.id.recycler);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));
        mRecyclerView.setHasFixedSize(false);
        for (int i = 0; i < getContext().getSharedPreferences("quran", Context.MODE_PRIVATE).getInt("list", 0); i++) {
            strings.add("" + getContext().getSharedPreferences("quran",
                    Context.MODE_PRIVATE).getString("item_" + i, "fav"));
        }
        final RecyAdapter adapter = new RecyAdapter(strings);
        mRecyclerView.setAdapter(adapter);

        ItemTouchHelper.SimpleCallback itemTouchHelperCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(final RecyclerView.ViewHolder viewHolder, int direction) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        adapter.onItemDismiss(viewHolder.getAdapterPosition());
                    }
                }, 300);

            }

            @Override
            public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
                viewHolder.itemView.animate().setDuration(300).translationX(-getActivity().getWindowManager().getDefaultDisplay().getWidth());
            }
        };

        new ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(mRecyclerView);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (mainInterface != null)
            mainInterface.showToolBar();
    }

    class RecyAdapter extends RecyclerView.Adapter<Holder> {
        ArrayList<String> strings;

        public RecyAdapter(ArrayList<String> strings) {
            this.strings = strings;
        }

        @NonNull
        @Override
        public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new Holder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item3, null));
        }

        @Override
        public void onBindViewHolder(@NonNull final Holder holder, final int position) {
            holder.index.setText("" + (position + 1));
            if (position + 1 == strings.size())
                holder.iv.setImageResource(R.drawable.delete_swipe);
            holder.name.setText(strings.get(position));
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int p = getContext().getSharedPreferences("quran", Context.MODE_PRIVATE).getInt("index_" + position, 1);
                    mainInterface.launchQuran(p);
                }
            });
        }


        @Override
        public int getItemCount() {
            return strings.size();
        }

        public void onItemDismiss(int position) {
            strings.remove(position);
            notifyItemRemoved(position);
            getContext().getSharedPreferences("quran", Context.MODE_PRIVATE).edit().putInt("list", strings.size()).commit();
            for (int i = 0; i < getContext().getSharedPreferences("quran", Context.MODE_PRIVATE).getInt("list", 0); i++) {
                getContext().getSharedPreferences("quran",
                        Context.MODE_PRIVATE).edit().putString("item_" + i, strings.get(i)).commit();
            }
        }
    }

    class Holder extends RecyclerView.ViewHolder {
        TextView name;
        TextView index;
        ImageView iv;

        public Holder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_name);
            index = itemView.findViewById(R.id.tv_index);
            iv = itemView.findViewById(R.id.iv);
        }
    }
}
