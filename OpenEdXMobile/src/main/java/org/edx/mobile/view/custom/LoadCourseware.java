package org.edx.mobile.view.custom;

import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;

import org.edx.mobile.R;
import org.edx.mobile.base.BaseFragmentActivity;

/**
 * Created by Sushil on 5/26/2017.
 */

public class LoadCourseware extends BaseFragmentActivity {
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_corseware);

//        environment.getAnalyticsRegistry().trackScreenView(Analytics.Screens.MY_FEEDBACK);

        webView=(WebView)findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        Log.e("URL ", getIntent().getStringExtra("URL"));
        webView.loadUrl("https://docs.google.com/viewer?url="+getIntent().getStringExtra("URL"));


    }
}
