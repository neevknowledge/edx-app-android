package org.edx.mobile.view;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;

import org.edx.mobile.R;
import org.edx.mobile.base.BaseFragmentActivity;
import org.edx.mobile.module.analytics.Analytics;

public class Progress extends BaseFragmentActivity {

    FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        blockDrawerFromOpening();
        ActionBar bar = getSupportActionBar();
        if (bar != null) {
            bar.setDisplayShowHomeEnabled(false);
            bar.setDisplayHomeAsUpEnabled(true);
            bar.setIcon(android.R.color.transparent);
        }
//        configureDrawer();
        environment.getAnalyticsRegistry().trackScreenView(Analytics.Screens.MY_PROGRESS);

        ft = getSupportFragmentManager().beginTransaction();
        // ft.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left);
       ft.replace(R.id.container, new ProgressFragment()).commit();

    }
}