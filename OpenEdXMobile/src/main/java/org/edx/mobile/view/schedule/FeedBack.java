package org.edx.mobile.view.schedule;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import org.edx.mobile.R;
import org.edx.mobile.view.data_holder.GetSetAnswer;

/**
 * Created by Sushil on 6/6/2017.
 */

public class FeedBack extends Fragment {
    View v;
    FragmentTransaction ft;
    RadioButton q1_rb1,q1_rb2,q1_rb3,q1_rb4,q1_rb5;
    RadioButton q2_rb1,q2_rb2,q2_rb3,q2_rb4,q2_rb5;
    RadioButton q3_rb1,q3_rb2,q3_rb3,q3_rb4,q3_rb5;
    RadioButton q4_rb1,q4_rb2,q4_rb3,q4_rb4,q4_rb5;
    RadioButton q5_rb1,q5_rb2,q5_rb3,q5_rb4,q5_rb5;
    RadioButton q6_rb1,q6_rb2,q6_rb3,q6_rb4,q6_rb5;
    RadioButton q7_rb1,q7_rb2,q7_rb3,q7_rb4,q7_rb5;
    int option1,option2, option3, option4, option5, option6, option7;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        v = inflater.inflate(R.layout.feedback_form, container, false);

        q1_rb1= (RadioButton) v.findViewById(R.id.rb_1_1);
        q1_rb2= (RadioButton) v.findViewById(R.id.rb_1_2);
        q1_rb3= (RadioButton) v.findViewById(R.id.rb_1_3);
        q1_rb4= (RadioButton) v.findViewById(R.id.rb_1_4);
        q1_rb5= (RadioButton) v.findViewById(R.id.rb_1_5);

        q2_rb1= (RadioButton) v.findViewById(R.id.rb_2_1);
        q2_rb2= (RadioButton) v.findViewById(R.id.rb_2_2);
        q2_rb3= (RadioButton) v.findViewById(R.id.rb_2_3);
        q2_rb4= (RadioButton) v.findViewById(R.id.rb_2_4);
        q2_rb5= (RadioButton) v.findViewById(R.id.rb_2_5);

        q3_rb1= (RadioButton) v.findViewById(R.id.rb_3_1);
        q3_rb2= (RadioButton) v.findViewById(R.id.rb_3_2);
        q3_rb3= (RadioButton) v.findViewById(R.id.rb_3_3);
        q3_rb4= (RadioButton) v.findViewById(R.id.rb_3_4);
        q3_rb5= (RadioButton) v.findViewById(R.id.rb_3_5);

        q4_rb1= (RadioButton) v.findViewById(R.id.rb_4_1);
        q4_rb2= (RadioButton) v.findViewById(R.id.rb_4_2);
        q4_rb3= (RadioButton) v.findViewById(R.id.rb_4_3);
        q4_rb4= (RadioButton) v.findViewById(R.id.rb_4_4);
        q4_rb5= (RadioButton) v.findViewById(R.id.rb_4_5);

        q5_rb1= (RadioButton) v.findViewById(R.id.rb_5_1);
        q5_rb2= (RadioButton) v.findViewById(R.id.rb_5_2);
        q5_rb3= (RadioButton) v.findViewById(R.id.rb_5_3);
        q5_rb4= (RadioButton) v.findViewById(R.id.rb_5_4);
        q5_rb5= (RadioButton) v.findViewById(R.id.rb_5_5);

        q6_rb1= (RadioButton) v.findViewById(R.id.rb_6_1);
        q6_rb2= (RadioButton) v.findViewById(R.id.rb_6_2);
        q6_rb3= (RadioButton) v.findViewById(R.id.rb_6_3);
        q6_rb4= (RadioButton) v.findViewById(R.id.rb_6_4);
        q6_rb5= (RadioButton) v.findViewById(R.id.rb_6_5);

        q7_rb1= (RadioButton) v.findViewById(R.id.rb_7_1);
        q7_rb2= (RadioButton) v.findViewById(R.id.rb_7_2);
        q7_rb3= (RadioButton) v.findViewById(R.id.rb_7_3);
        q7_rb4= (RadioButton) v.findViewById(R.id.rb_7_4);
        q7_rb5= (RadioButton) v.findViewById(R.id.rb_7_5);

        ft = getFragmentManager().beginTransaction();
        v.findViewById(R.id.btn_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(q1_rb1.isChecked()||q1_rb2.isChecked()||q1_rb3.isChecked()||q1_rb4.isChecked()||q1_rb5.isChecked()){
                    option("q1");
                    GetSetAnswer.setAns1(option1);
                }
                if(q2_rb1.isChecked()||q2_rb2.isChecked()||q2_rb3.isChecked()||q2_rb4.isChecked()||q2_rb5.isChecked()){
                    option("q2");
                    GetSetAnswer.setAns2(option2);
                }
                if(q3_rb1.isChecked()||q3_rb2.isChecked()||q3_rb3.isChecked()||q3_rb4.isChecked()||q3_rb5.isChecked()){
                    option("q3");
                    GetSetAnswer.setAns3(option3);
                }
                if(q4_rb1.isChecked()||q4_rb2.isChecked()||q4_rb3.isChecked()||q4_rb4.isChecked()||q4_rb5.isChecked()){
                    option("q4");
                    GetSetAnswer.setAns4(option4);
                }
                if(q5_rb1.isChecked()||q5_rb2.isChecked()||q5_rb3.isChecked()||q5_rb4.isChecked()||q5_rb5.isChecked()){
                    option("q5");
                    GetSetAnswer.setAns5(option5);
                }
                if(q6_rb1.isChecked()||q6_rb2.isChecked()||q6_rb3.isChecked()||q6_rb4.isChecked()||q6_rb5.isChecked()){
                    option("q6");
                    GetSetAnswer.setAns6(option6);
                }
                if(q7_rb1.isChecked()||q7_rb2.isChecked()||q7_rb3.isChecked()||q7_rb4.isChecked()||q7_rb5.isChecked()){
                    option("q7");
                    GetSetAnswer.setAns7(option7);
                }
             //   ft.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left);
                ft.replace(R.id.container, new Feedback2()).commit();
            }
        });
//        v.findViewById(R.id.btn_back).setVisibility(View.GONE);
//        .setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ft.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right);
//                ft.replace(R.id.container, new Feedback1()).commit();
//            }
//        });
        return v;

    }

    public void option(String qwe){
        switch (qwe){
            case "q1":
                if(q1_rb1.isChecked())
                    option1=1;
                if(q1_rb2.isChecked())
                    option1=2;
                if(q1_rb3.isChecked())
                    option1=3;
                if(q1_rb4.isChecked())
                    option1=4;
                if(q1_rb5.isChecked())
                    option1=5;
                break;
            case "q2":
                if(q2_rb1.isChecked())
                    option2=1;
                if(q2_rb2.isChecked())
                    option2=2;
                if(q2_rb3.isChecked())
                    option2=3;
                if(q2_rb4.isChecked())
                    option2=4;
                if(q2_rb5.isChecked())
                    option2=5;
                break;
            case "q3":
                if(q3_rb1.isChecked())
                    option3=1;
                if(q3_rb2.isChecked())
                    option3=2;
                if(q3_rb3.isChecked())
                    option3=3;
                if(q3_rb4.isChecked())
                    option3=4;
                if(q3_rb5.isChecked())
                    option3=5;
                break;
            case "q4":
                if(q4_rb1.isChecked())
                    option4=1;
                if(q4_rb2.isChecked())
                    option4=2;
                if(q4_rb3.isChecked())
                    option4=3;
                if(q4_rb4.isChecked())
                    option4=4;
                if(q4_rb5.isChecked())
                    option4=5;
                break;
            case "q5":
                if(q5_rb1.isChecked())
                    option5=1;
                if(q5_rb2.isChecked())
                    option5=2;
                if(q5_rb3.isChecked())
                    option5=3;
                if(q5_rb4.isChecked())
                    option5=4;
                if(q5_rb5.isChecked())
                    option5=5;
                break;
            case "q6":
                if(q6_rb1.isChecked())
                    option6=1;
                if(q6_rb2.isChecked())
                    option6=2;
                if(q6_rb3.isChecked())
                    option6=3;
                if(q6_rb4.isChecked())
                    option6=4;
                if(q6_rb5.isChecked())
                    option6=5;
                break;
            case "q7":
                if(q7_rb1.isChecked())
                    option7=1;
                if(q7_rb2.isChecked())
                    option7=2;
                if(q7_rb3.isChecked())
                    option7=3;
                if(q7_rb4.isChecked())
                    option7=4;
                if(q7_rb5.isChecked())
                    option7=5;
                break;
        }
    }
}


