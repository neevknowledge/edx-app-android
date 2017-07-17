package org.edx.mobile.view.progress;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.edx.mobile.R;
import org.w3c.dom.Text;

/**
 * Created by Sushil on 7/6/2017.
 */

class Dialog_Quiz_Adapter extends RecyclerView.Adapter<Dialog_Quiz_Adapter.ViewHolder> {
    View v;
    Context context;
    String [] ary;
    public Dialog_Quiz_Adapter(Context context, String[] qz) {
        this.context=context;
        this.ary=qz;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.dialog_layout_progress_quiz, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(Dialog_Quiz_Adapter.ViewHolder holder, int position) {
       holder.title.setText("0/1");
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
