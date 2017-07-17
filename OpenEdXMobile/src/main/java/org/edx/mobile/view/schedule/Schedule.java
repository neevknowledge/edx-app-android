package org.edx.mobile.view.schedule;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.edx.mobile.R;
import org.edx.mobile.http.ApiConstants;
import org.edx.mobile.view.adapters.ScheduleDetailAdapter;
import org.edx.mobile.view.data_holder.BatchCode;
import org.edx.mobile.view.data_holder.ScheduleData;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

/**
 * Created by Sushil on 6/6/2017.
 */

public class Schedule extends Fragment {
    View v;
    RecyclerView r_view;
    RecyclerView.Adapter adapter;
    ArrayList<ScheduleData> data= new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        v = inflater.inflate(R.layout.schedule, container, false);
        r_view = (RecyclerView) v.findViewById(R.id.recycler_view);
        r_view.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        r_view.setHasFixedSize(true);
        new Get_Schedule().execute("Get Schedule");
        return v;
    }

    public class Get_Schedule extends AsyncTask<String, String, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {
            ApiConstants.COURSE_URL = null;
            try {
                ApiConstants.COURSE_URL = URLEncoder.encode(ScheduleData.getCourse_URL(),"utf-8");//""course-v1:EduPristine+DigitalMarketing+Digital-Marketing", "utf-8");
            } catch (Exception e) {
                Log.e("Course Url exception", e.getMessage());
            }
            ApiConstants.EMAIL =ScheduleData.getScheduler_email();//"anubhav@edupristine.com";
            String conUrl = ApiConstants.GET_SCHEDULE + ApiConstants.COURSE_URL + "&email=" + ApiConstants.EMAIL + "";
            Log.e("URL ", conUrl);
            try {
                URL url = new URL(conUrl);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestProperty("Authorization", ApiConstants.AUTHORIZATION_TOKEN);
                urlConnection.setRequestMethod("GET");
                urlConnection.setRequestProperty("Content-Type", "application/json");
                urlConnection.connect();
                int responseCode = urlConnection.getResponseCode();
                if (responseCode == 200) {
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                        StringBuilder stringBuilder = new StringBuilder();
                        String line;
                        while ((line = bufferedReader.readLine()) != null) {
                            stringBuilder.append(line).append("\n");
                        }
                        bufferedReader.close();
                        return stringBuilder.toString();
                    } finally {
                        urlConnection.disconnect();
                    }
                } else {
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
            data.clear();
            if (response == null) {
                response = "THERE WAS AN ERROR";
            } else {
                Log.i("INFO", response);
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONArray ary = jsonArray.getJSONArray(i);
                        for (int j = 0; j < ary.length(); j++) {
                            JSONObject object = ary.getJSONObject(j);
                            ScheduleData gsScheduleData = new ScheduleData();
//                            "name":"Aravind bharathi",
//                                    "fid":19487,
//                                    "code":"IBCNDM11",
//                                    "course":"DM",
//                                    "venue_details":"Redsun",
//                                    "topic":"SEO-II",
//                                    "start_time":"10:00 AM",
//                                    "end_time":"03:00 PM",
//                                    "batch_code":"IBCNDM11",
//                                    "ws_date":"2017-02-26",
//                                    "status":"Confirmed",
//                                    "dateid":16
                            if (BatchCode.getBatch_code().equalsIgnoreCase(object.getString("batch_code"))) {
                                gsScheduleData.setBatch_code(object.getString("batch_code"));
                                gsScheduleData.setWs_date(object.getString("ws_date"));
                                gsScheduleData.setVenue_details(object.getString("venue_details"));
                                gsScheduleData.setStart_time(object.getString("start_time"));
                                gsScheduleData.setEnd_time(object.getString("end_time"));
                                gsScheduleData.setTopic(object.getString("topic"));
                                gsScheduleData.setFac_info(object.getString("name"));//fac.substring(fac.indexOf(":") + 1, fac.indexOf(",")));
                                gsScheduleData.setStatus(object.getString("status"));
                                gsScheduleData.setFac_id(String.valueOf(object.getInt("fid")));
                                gsScheduleData.setWsdate_id(object.getString("dateid"));
                                gsScheduleData.setWs_id(object.getString("id"));
                                gsScheduleData.setFeedback(object.getString("feedback"));
                                data.add(gsScheduleData);
                            }
                        }
                    }
                    adapter = new ScheduleDetailAdapter(getActivity(), data);
                    r_view.setAdapter(adapter);
                    adapter.notifyDataSetChanged();

                } catch (JSONException e) {
                    Log.e("JSON Exception ", e.getMessage());
                }
            }
        }
    }
}
