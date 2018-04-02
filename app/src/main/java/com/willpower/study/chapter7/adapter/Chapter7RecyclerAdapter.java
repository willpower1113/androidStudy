package com.willpower.study.chapter7.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.willpower.study.R;
import com.willpower.study.chapter7.Chapter7_1Activity;
import com.willpower.study.chapter7.Chapter7_2Activity;
import com.willpower.study.chapter7.Chapter7_3Activity;
import com.willpower.study.home.ChapterBean;

import java.util.List;

/**
 * Created by Administrator on 2018/3/30.
 */

public class Chapter7RecyclerAdapter extends RecyclerView.Adapter<Chapter7RecyclerAdapter.ViewHolder> {

    Context mContext;
    List<ChapterBean> mData;

    public Chapter7RecyclerAdapter(Context mContext, List<ChapterBean> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.chapter7_item_recycler, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.tvChapter7ItemTitle.setText(mData.get(position).getChapterIndex());
        holder.tvChapter7ItemDesc.setText(mData.get(position).getChapterDesc());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Class cls;
                switch (position) {
                    case 1:
                        cls = Chapter7_1Activity.class;
                        break;
                    case 2:
                        cls = Chapter7_2Activity.class;
                        break;
                    case 3:
                        cls = Chapter7_3Activity.class;
                        break;
                    default:
                        cls = null;
                        break;
                }
                if (cls != null) {
                    mContext.startActivity(new Intent(mContext, cls));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData != null ? mData.size() : 0;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvChapter7ItemTitle, tvChapter7ItemDesc;
        CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            tvChapter7ItemTitle = (TextView) itemView.findViewById(R.id.tv_chapter7_item_title);
            tvChapter7ItemDesc = (TextView) itemView.findViewById(R.id.tv_chapter7_item_desc);
            cardView = (CardView) itemView.findViewById(R.id.card_chapter7_item_layout);
        }
    }
}
