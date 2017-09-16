package org.edx.mobile.view.schedule;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.webkit.WebView;

import org.edx.mobile.R;
import org.edx.mobile.base.BaseFragmentActivity;


public class Online extends BaseFragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        blockDrawerFromOpening();
        ActionBar bar = getSupportActionBar();
        if (bar != null) {
            bar.setDisplayShowHomeEnabled(true);
            bar.setDisplayHomeAsUpEnabled(true);
            bar.setIcon(android.R.color.transparent);
        }
//        configureDrawer();
//        environment.getAnalyticsRegistry().trackScreenView(Analytics.Screens.MY_SCHEDULE);
        WebView myWebView = (WebView) findViewById(R.id.wec_content);
        Log.e("URL ", getIntent().getStringExtra("url"));
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.loadUrl(getIntent().getStringExtra("url"));

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}