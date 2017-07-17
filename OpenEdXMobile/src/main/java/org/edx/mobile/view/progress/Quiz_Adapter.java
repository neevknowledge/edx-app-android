package org.edx.mobile.view.progress;

import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.timqi.sectorprogressview.SectorProgressView;

import org.edx.mobile.R;

import java.util.Random;


public class Quiz_Adapter extends RecyclerView.Adapter<Quiz_Adapter.ViewHolder> {
    View v;
    Context context;
    String[] ary;

    public Quiz_Adapter(Context context, String[] ary) {
        this.context = context;
        this.ary = ary;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_progress_quiz, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(Quiz_Adapter.ViewHolder holder, int position) {
        Random r = new Random();
        int min = 0;
        int max = 100;
        int i1 = r.nextInt(max - min + 1) + min;
        holder.title.setText(ary[position]);
        holder.percentage.setText(i1+"%");
        holder.spv.setPercent(i1);
    }

    @Override
    public int getItemCount() {
        return ary.length;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, percentage;
        SectorProgressView spv;

        public ViewHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.tv_title);
            percentage= (TextView) itemView.findViewById(R.id.tv_percentage);

            spv = (SectorProgressView)itemView.findViewById(R.id.spv);


        }
    }




}
