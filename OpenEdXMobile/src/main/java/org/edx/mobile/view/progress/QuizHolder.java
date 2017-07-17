package org.edx.mobile.view;

import java.util.ArrayList;

/**
 * Created by Sushil on 7/5/2017.
 */

public class QuizHolder {
    ArrayList<String> quizList = new ArrayList<>();
    ArrayList<String> statusList= new ArrayList<>();

    public ArrayList<String> getQuizList() {
        return quizList;
    }

    public void setQuizList(ArrayList<String> quizList) {
        this.quizList = quizList;
    }

    public ArrayList<String> getStatusList() {
        return statusList;
    }

    public void setStatusList(ArrayList<String> statusList) {
        this.statusList = statusList;
    }
}
