package com.willpower.study.home;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.willpower.study.R;
import com.willpower.study.chapter7.Chapter7Activity;

import java.util.List;

/**
 * Created by Administrator on 2018/3/30.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    List<ChapterBean> mData;

    Context mContext;

    public HomeAdapter(List<ChapterBean> mData, Context mContext) {
        this.mData = mData;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.home_item_recycler, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.tvIndex.setText(mData.get(position).getChapterIndex());//章节
        holder.tvName.setText(mData.get(position).getChapterDesc());//名称
        holder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Class cls;
                switch (position) {
                    case 6:
                        cls = Chapter7Activity.class;
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
        return mData.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvIndex, tvName;
        CardView rootView;

        public ViewHolder(View itemView) {
            super(itemView);
            tvIndex = (TextView) itemView.findViewById(R.id.tv_home_item_chapter_index);
            tvName = (TextView) itemView.findViewById(R.id.tv_home_item_chapter_name);
            rootView = (CardView) itemView.findViewById(R.id.card_home_item_root_layout);
        }
    }
}
