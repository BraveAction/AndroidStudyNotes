package com.gxy.application;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * 实现了滑动删除和拖放的适配器
 * Created by Gxy on 2016/3/31
 */
public class RecycleItemAdapter extends RecyclerView.Adapter<RecycleItemAdapter.ViewHolder> implements ItemTouchHelperAdapter {

    private Activity mContext;
    private List<String> mData;
    private MainActivity.ItemOnClickListener itemOnClickListener;
    private RecyclerView mRecyclerView;

    public RecycleItemAdapter(RecyclerView recyclerView, Activity activity, MainActivity.ItemOnClickListener itemOnClickListener) {
        this.mRecyclerView = recyclerView;
        this.mContext = activity;
        this.itemOnClickListener = itemOnClickListener;
        Log.i(getClass().getSimpleName(), (this.itemOnClickListener == null) + "");
        this.itemOnClickListener.onClick();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        CardView view = (CardView) LayoutInflater.from(mContext).inflate(R.layout.item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.textView.setText(mData.get(i));
    }

    public void setmData(List data) {
        this.mData = data;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public List getData() {
        return mData;
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        Collections.swap(mData, fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);
        return true;
    }

    @Override
    public void onItemDismiss(int position) {
        mData.remove(position);
        notifyItemRemoved(position);
        this.mRecyclerView.postDelayed(new Runnable() {
            @Override
            public void run() {
                notifyDataSetChanged();
            }
        }, this.mRecyclerView.getItemAnimator().getMoveDuration() + 50);
    }

    class ViewHolder extends RecyclerView.ViewHolder implements ItemTouchHelperViewHolder, View.OnClickListener {
        private TextView textView;
        private CardView mIteCardView;

        public ViewHolder(View itemView) {
            super(itemView);
            mIteCardView = (CardView) itemView;
            textView = (TextView) itemView.findViewById(R.id.textView);
            mIteCardView.setOnClickListener(this);
        }

        @Override
        public void onItemSelected() {
            mIteCardView.setCardBackgroundColor(Color.TRANSPARENT);
//            mIteCardView.setBackgroundColor(Color.LTGRAY);
        }

        @Override
        public void onItemClear() {
//            mIteCardView.setCardBackgroundColor(mContext.getResources().getColor(R.color.colorAccent));
            mIteCardView.setCardBackgroundColor(0xFFFFC000);
        }

        @Override
        public void onItemDragSelected() {
            mIteCardView.setCardBackgroundColor(Color.LTGRAY);
        }

        @Override
        public void onClick(View view) {

            RecycleItemAdapter.this.itemOnClickListener.onClick();
        }
    }
}
