package org.edx.mobile.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

import org.edx.mobile.R;
import org.edx.mobile.model.course.BlockType;
import org.edx.mobile.model.course.CourseComponent;
import org.edx.mobile.services.ViewPagerDownloadManager;
import org.edx.mobile.util.BrowserUtil;

/**
 *
 */
public class CourseUnitMobileNotSupportedFragment extends CourseUnitFragment {

    /**
     * Create a new instance of fragment
     */
    ImageView img_loading;
    public static CourseUnitMobileNotSupportedFragment newInstance(CourseComponent unit) {
        CourseUnitMobileNotSupportedFragment f = new CourseUnitMobileNotSupportedFragment();

        // Supply num input as an argument.
        Bundle args = new Bundle();
        args.putSerializable(Router.EXTRA_COURSE_UNIT, unit);
        f.setArguments(args);

        return f;
    }

    /**
     * When creating, retrieve this instance's number from its arguments.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * The Fragment's UI is just a simple text view showing its
     * instance number.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_course_unit_grade, container, false);
        img_loading=(ImageView)v.findViewById(R.id.img_loading);
        GlideDrawableImageViewTarget imageViewTarget = new GlideDrawableImageViewTarget(img_loading);
        Glide.with(this).load(R.raw.loading).override(350,350).centerCrop().into(imageViewTarget);

      //  ((TextView) v.findViewById(R.id.not_available_message)).setVisibility(View.GONE);
//        .setText(
//                unit.getType() == BlockType.VIDEO ? R.string.video_only_on_web_short : R.string.assessment_not_available);
//        v.findViewById(R.id.view_on_web_button).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                BrowserUtil.open(getActivity(), unit.getWebUrl());
//                environment.getAnalyticsRegistry().trackOpenInBrowser(unit.getId()
//                        , unit.getCourseId(), unit.isMultiDevice());
//            }
//        });
        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (ViewPagerDownloadManager.instance.inInitialPhase(unit))
            ViewPagerDownloadManager.instance.addTask(this);
    }


    @Override
    public void run() {
        ViewPagerDownloadManager.instance.done(this, true);
    }

}
