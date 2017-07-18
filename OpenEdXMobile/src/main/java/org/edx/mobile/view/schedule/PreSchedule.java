package org.edx.mobile.view.schedule;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import org.edx.mobile.R;
import org.edx.mobile.http.ApiConstants;
import org.edx.mobile.view.adapters.ScheduleAdapter;
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

public class PreSchedule extends Fragment {
    View v;
    RecyclerView r_view;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager manager;
    ArrayList<ScheduleData> data= new ArrayList<>();
    View loadingIndicator;
    SwipeRefreshLayout srl;
    LinearLayout no_schedule;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        v = inflater.inflate(R.layout.pre_schedule, container, false);

        r_view = (RecyclerView) v.findViewById(R.id.recycler_view);
        manager = new LinearLayoutManager(getActivity());
        r_view.setLayoutManager(manager);
        r_view.setHasFixedSize(true);

        r_view.setVisibility(View.VISIBLE);

        no_schedule=(LinearLayout) v.findViewById(R.id.no_schedule);
        no_schedule.setVisibility(View.GONE);
        loadingIndicator = v.findViewById(R.id.loading_indicator);

        srl=(SwipeRefreshLayout)v.findViewById(R.id.swipe_container);

        srl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Get_Schedule().execute("Get Schedule");
                adapter.notifyDataSetChanged();
            }
        });
        srl.setColorSchemeResources(R.color.edx_brand_primary_accent,
                R.color.edx_brand_gray_x_back, R.color.edx_brand_gray_x_back,
                R.color.edx_brand_gray_x_back);
      new Get_Schedule().execute("Get Schedule");

        return v;
    }
     public class Get_Schedule extends AsyncTask<String, String, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            loadingIndicator.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(String... strings) {
            ApiConstants.COURSE_URL = null;//ScheduleData.getCourse_URL();
            try {
                ApiConstants.COURSE_URL = URLEncoder.encode(ScheduleData.getCourse_URL(),"utf-8");//"course-v1:EduPristine+DigitalMarketing+Digital-Marketing", "utf-8");
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
                    Log.e("Response Code ", String.valueOf(responseCode));
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
                    if(jsonArray.length()==0) {
                        r_view.setVisibility(View.GONE);
                        no_schedule.setVisibility(View.VISIBLE);
                    }
                    else {
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONArray ary = jsonArray.getJSONArray(i);
                            JSONObject objBatchCode = ary.getJSONObject(i);
                            ScheduleData sd = new ScheduleData();
                            sd.setBatch_code(objBatchCode.getString("batch_code"));
                            sd.setCourse(objBatchCode.getString("course"));
                            data.add(sd);
                        }
                        adapter = new ScheduleAdapter(PreSchedule.this, data);
                        r_view.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                    }

                } catch (JSONException e) {
                    Log.e("JSON Exception ", e.getMessage());
                }
            }
            loadingIndicator.setVisibility(View.GONE);
            srl.setRefreshing(false);
        }
    }
}
