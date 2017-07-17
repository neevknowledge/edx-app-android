package org.edx.mobile.view.adapters;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import org.edx.mobile.R;
import org.edx.mobile.view.schedule.FeedBack;
import org.edx.mobile.view.data_holder.GetSetFeedback;
import org.edx.mobile.view.data_holder.ScheduleData;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class ScheduleDetailAdapter extends RecyclerView.Adapter<ScheduleDetailAdapter.MyHolder> {
    Activity context;
    ArrayList<ScheduleData> data;
    View v;
    String cur_date="";

    public ScheduleDetailAdapter(Activity context, ArrayList<ScheduleData> data) {
        this.context = context;
        this.data = data;

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cur_date=dateFormat.format(cal.getTime());
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.schedule_detail_layout, parent, false);
        return new ScheduleDetailAdapter.MyHolder(v);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        ScheduleData itm = data.get(position);
        String[] dt = itm.getWs_date().split("-");
        if(cur_date.compareToIgnoreCase(itm.getWs_date())==0){
            //current date
            holder.date.setText("Today");
            holder.month.setText(month(Integer.parseInt(dt[1])));
            holder.month.setBackgroundColor(context.getColor(android.R.color.holo_green_dark));
            if (itm.getStatus().equalsIgnoreCase("Confirmed")) {
                holder.status.setTypeface(Typeface.DEFAULT_BOLD);
                holder.status.setText(itm.getStatus());
                holder.status.setTextColor(context.getColor(android.R.color.holo_green_light));
            }
            else {
                holder.status.setText(itm.getStatus());
                holder.status.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                holder.status.setTextColor(context.getColor(android.R.color.holo_red_dark));
            }
        }
        else if (cur_date.compareToIgnoreCase(itm.getWs_date())>0){
            //past date
            holder.date.setText(dt[2]);
            holder.month.setText(month(Integer.parseInt(dt[1])));
            holder.status.setTextSize(13);
            if(itm.getFeedback().equalsIgnoreCase("no"))
                holder.status.setText("Feedback Pending");
            else
                holder.status.setText("Feedback Submitted");
        }
        else {
            //post date
            holder.date.setText(dt[2]);
            holder.month.setText(month(Integer.parseInt(dt[1])));
            if (itm.getStatus().equalsIgnoreCase("Confirmed")) {
                holder.status.setText(itm.getStatus());
                holder.status.setTypeface(Typeface.DEFAULT_BOLD);
                holder.status.setTextColor(context.getColor(android.R.color.holo_green_light));
            }
            else {
                holder.status.setText(itm.getStatus());
                holder.status.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                holder.status.setTextColor(context.getColor(android.R.color.holo_red_dark));
            }
        }




    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public String month(int mt) {
        switch (mt) {
            case 1:
                return "JAN";
            case 2:
                return "FEB";
            case 3:
                return "MAR";
            case 4:
                return "APR";
            case 5:
                return "MAY";
            case 6:
                return "JUN";
            case 7:
                return "JUL";
            case 8:
                return "AUG";
            case 9:
                return "SEPT";
            case 10:
                return "OCT";
            case 11:
                return "NOV";
            case 12:
                return "DEC";

        }
        return null;
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView date, month, status;
        LinearLayout layout;

        public MyHolder(View itemView) {
            super(itemView);
            date = (TextView) itemView.findViewById(R.id.tv_date);
            month = (TextView) itemView.findViewById(R.id.tv_month);
            status = (TextView) itemView.findViewById(R.id.tv_status);
            itemView.findViewById(R.id.layout).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ScheduleData gst = data.get(getAdapterPosition());
                    int date_diff =cur_date.compareToIgnoreCase(gst.getWs_date());
                    dialog(gst.getStart_time(), gst.getEnd_time(), gst.getTopic(), gst.getFac_info(), gst.getVenue_details(),
                            gst.getBatch_code(), gst.getCourse(), gst.getFac_id(),
                            gst.getWsdate_id(), gst.getWs_id(), gst.getWs_date(), gst.getFeedback(), date_diff);
                }
            });
        }
    }
    public void dialog(String start_time, String end_time, final String topic, final String fac_info, final String venue_details,
                       final String batch_code, final String course, final String fac_id, final String wsDateId,
                       final String ws_id, final String ws_date, final String feedback, int date_diff){
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.dialog_schedule);
        dialog.show();
        Window window = dialog.getWindow();
        window.setLayout(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
      dialog.setCancelable(true);
        final TextView tstart_time, tend_time, tfac_name, ttopic, tvenue;
        tstart_time=(TextView)dialog.findViewById(R.id.tv_startTime);
        tend_time=(TextView)dialog.findViewById(R.id.tv_endTime);
        tfac_name=(TextView)dialog.findViewById(R.id.tv_facName);
        ttopic=(TextView)dialog.findViewById(R.id.tv_topic);
        tvenue=(TextView)dialog.findViewById(R.id.tv_venue);

        tstart_time.setText(start_time);
        tend_time.setText(end_time);
        tfac_name.setText(fac_info);
        ttopic.setText(topic);
        tvenue.setText(venue_details);
//        status.setText(getIntent().getStringExtra("status"));

//        tstart_time.setKeyListener(null);tend_time.setKeyListener(null);tfac_name.setKeyListener(null);
//        ttopic.setKeyListener(null);tvenue.setKeyListener(null);

        FrameLayout btnContinue, btnBack;
        btnContinue= (FrameLayout) dialog.findViewById(R.id.continue_button_layout);
        btnBack= (FrameLayout) dialog.findViewById(R.id.back_button_layout);
        btnBack.setVisibility(View.GONE);
        if(feedback.equalsIgnoreCase("yes") || date_diff<0){
            btnContinue.setVisibility(View.GONE);

        }else {
            btnContinue.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    GetSetFeedback.setBatch_code(batch_code);
                    GetSetFeedback.setCourse(course);
                    GetSetFeedback.setTopic(topic);
                    GetSetFeedback.setFac_id(fac_id);
                    GetSetFeedback.setFaculty(fac_info);
                    GetSetFeedback.setWs_id(ws_id);
                    GetSetFeedback.setWsdate_id(wsDateId);
                    GetSetFeedback.setWs_date(ws_date);
                    GetSetFeedback.setVenue(venue_details);
                    FeedBack fb = new FeedBack();
                    context.getFragmentManager().beginTransaction().replace(R.id.container, fb).commit();
                    dialog.dismiss();


                }
            });
        }
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }

}
