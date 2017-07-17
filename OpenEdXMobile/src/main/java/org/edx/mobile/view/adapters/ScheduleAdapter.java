package org.edx.mobile.view.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.edx.mobile.R;
import org.edx.mobile.view.schedule.PreSchedule;
import org.edx.mobile.view.schedule.Schedule;
import org.edx.mobile.view.data_holder.BatchCode;
import org.edx.mobile.view.data_holder.ScheduleData;

import java.util.ArrayList;

/**
 * Created by Sushil on 6/6/2017.
 */

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.MyViewHolder> {

    PreSchedule context;
    ArrayList<ScheduleData> data;
    View v;

    public ScheduleAdapter(PreSchedule context, ArrayList<ScheduleData> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_schedule_layout, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ScheduleData sd = data.get(position);
        holder.batch_code.setText(": "+sd.getBatch_code());
        holder.course.setText(": "+sd.getCourse());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView batch_code, course;
        public MyViewHolder(final View itemView) {
            super(itemView);
            batch_code =(TextView)itemView.findViewById(R.id.tv_batch_code);
            course =(TextView)itemView.findViewById(R.id.tv_course);
            itemView.findViewById(R.id.layout).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ScheduleData sd = data.get(getAdapterPosition());
                    BatchCode.setBatch_code(sd.getBatch_code());
                    context.getFragmentManager().beginTransaction().replace(R.id.container, new Schedule()).commit();
                }
            });
        }
    }
}
