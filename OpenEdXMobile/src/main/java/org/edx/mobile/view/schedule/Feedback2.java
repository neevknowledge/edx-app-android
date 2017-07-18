package org.edx.mobile.view.schedule;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Toast;

import org.edx.mobile.R;
import org.edx.mobile.http.ApiConstants;
import org.edx.mobile.model.api.ProfileModel;
import org.edx.mobile.view.adapters.ScheduleDetailAdapter;
import org.edx.mobile.view.data_holder.GetSetAnswer;
import org.edx.mobile.view.data_holder.GetSetFeedback;
import org.edx.mobile.view.data_holder.ScheduleData;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Feedback2 extends Fragment {
    View v;
    FragmentTransaction ft;
    RadioButton ontime, late, class_end_ontime, class_end_early, class_end_late;
    EditText comment;
    String option1, option2, cmnt="", submitedno="", postdata;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        v = inflater.inflate(R.layout.feedback_form2, container, false);

        ontime = (RadioButton) v.findViewById(R.id.rb_ontime);
        late = (RadioButton) v.findViewById(R.id.rb_late);
        class_end_ontime = (RadioButton) v.findViewById(R.id.rb_class_end_ontime);
        class_end_early = (RadioButton) v.findViewById(R.id.rb_class_end_early);
        class_end_late = (RadioButton) v.findViewById(R.id.rb_class_end_late);
        comment = (EditText) v.findViewById(R.id.comment_et);

        submitedno= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());

        ft = getFragmentManager().beginTransaction();
        v.findViewById(R.id.btn_back).setVisibility(View.INVISIBLE);
//                .setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //   ft.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right);
//                ft.replace(R.id.container, new FeedBack()).commit();
//            }
//        });
        v.findViewById(R.id.btn_submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (comment.getText().length() == 0) {
                    comment.setError("Comment is required.");
                } else {
                    option1 = class_end_ontime.isChecked() ? "1" : class_end_early.isChecked() ? "2" : class_end_late.isChecked() ? "3" : "0";
                    option2 = ontime.isChecked() ? "1" : late.isChecked() ? "2" : "0";

                    new Post_Feedback().execute();
                    cmnt=comment.getText().toString();
                   // getActivity().finish();
                }
            }
        });
        return v;
    }

    public class Post_Feedback extends AsyncTask<String, String, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {
            ApiConstants.COURSE_URL = null;
            try {
               postdata  = URLDecoder.decode("&f1="+GetSetAnswer.getAns1()+"&f2="+GetSetAnswer.getAns2()+
                       "&f3="+GetSetAnswer.getAns3()+"&f4="+GetSetAnswer.getAns4()+"&f5="+GetSetAnswer.getAns5()+"&f6="+GetSetAnswer.getAns6()+
                       "&f7="+GetSetAnswer.getAns7()+"&f8="+Integer.parseInt(option1)+"&f9="+Integer.parseInt(option2)+"&f10="+cmnt+"&wsid="+GetSetFeedback.getWs_id()+
                       "&wsdateid="+GetSetFeedback.getWsdate_id()+"&batchcode="+GetSetFeedback.getBatch_code()+
                       "&facultyid="+GetSetFeedback.getFac_id()+"&studentname="+ScheduleData.getuName()+
                       "&studentemail="+ScheduleData.getScheduler_email()+"&wsfeedbackdate="+GetSetFeedback.getWs_date()+"&submittedon="+ submitedno, "utf-8");
            } catch (Exception e) {
                Log.e("Course Url exception", e.getMessage());
            }
            String conUrl = ApiConstants.POST_FEEDBACK+postdata;
            Log.e("URL ", conUrl);
            try {
                URL url = new URL(conUrl);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestProperty("Authorization", ApiConstants.AUTHORIZATION_TOKEN);
                urlConnection.setRequestMethod("POST");
                urlConnection.setRequestProperty("Content-Type", "application/json");
               urlConnection.connect();
                int responseCode = urlConnection.getResponseCode();
                if (responseCode == 200) {
                    try {
//                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
//                        StringBuilder stringBuilder = new StringBuilder();
//                        String line;
//                        while ((line = bufferedReader.readLine()) != null) {
//                            stringBuilder.append(line).append("\n");
//                        }
//                        bufferedReader.close();
//                        return stringBuilder.toString();
                    } finally {
                        urlConnection.disconnect();
                    }
                } else {
                    Log.e("ERROR code", ""+responseCode);
                }
            } catch (Exception e) {
                Log.e("ERROR", e.getMessage(), e);
                return null;
            }
            return null;
        }

        @Override
        protected void onPostExecute(String response) {
            super.onPostExecute(response);
            dialog();
            if (response == null) {
                response = "THERE WAS AN ERROR";
            } else {
                Log.i("INFO", response);
            }
        }
    }

    public void dialog(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
        alertDialogBuilder.setMessage("Thanks for your feedback.");
                alertDialogBuilder.setPositiveButton("Ok",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
                               getActivity().finish();
                            }
                        });
                AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}

