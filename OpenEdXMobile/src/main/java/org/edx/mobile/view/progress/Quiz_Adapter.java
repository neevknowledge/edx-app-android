package org.edx.mobile.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.edx.mobile.R;


public class Quiz_Adapter extends RecyclerView.Adapter<Quiz_Adapter.ViewHolder> {
    View v;
    Context context;
    String [] ary;
    public Quiz_Adapter(Context context, String[] ary) {
        this.context=context;
        this.ary=ary;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        v= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_progress_quiz, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(Quiz_Adapter.ViewHolder holder, int position) {
        holder.title.setText(ary[position]);
    }

    @Override
    public int getItemCount() {
        return ary.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        public ViewHolder(View itemView) {
            super(itemView);

            title=(TextView)itemView.findViewById(R.id.tv_title);
        }
    }
}
