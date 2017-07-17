package org.edx.mobile.view;

import java.util.ArrayList;

/**
 * Created by Sushil on 6/14/2017.
 */

public class GetSetFeedback {
    static String email, course, batch_code, topic, faculty, fac_report_time, cls_end_time, fac_id, id, ws_id, ws_date, venue;
    static ArrayList<String> feedback= new ArrayList<>();

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        GetSetFeedback.email = email;
    }

    public static String getCourse() {
        return course;
    }

    public static void setCourse(String course) {
        GetSetFeedback.course = course;
    }

    public static String getBatch_code() {
        return batch_code;
    }

    public static void setBatch_code(String batch_code) {
        GetSetFeedback.batch_code = batch_code;
    }

    public static String getTopic() {
        return topic;
    }

    public static void setTopic(String topic) {
        GetSetFeedback.topic = topic;
    }

    public static String getFaculty() {
        return faculty;
    }

    public static void setFaculty(String faculty) {
        GetSetFeedback.faculty = faculty;
    }

    public static String getFac_report_time() {
        return fac_report_time;
    }

    public static void setFac_report_time(String fac_report_time) {
        GetSetFeedback.fac_report_time = fac_report_time;
    }

    public static String getCls_end_time() {
        return cls_end_time;
    }

    public static void setCls_end_time(String cls_end_time) {
        GetSetFeedback.cls_end_time = cls_end_time;
    }

    public static String getFac_id() {
        return fac_id;
    }

    public static void setFac_id(String fac_id) {
        GetSetFeedback.fac_id = fac_id;
    }

    public static String getId() {
        return id;
    }

    public static void setId(String id) {
        GetSetFeedback.id = id;
    }

    public static String getWs_id() {
        return ws_id;
    }

    public static void setWs_id(String ws_id) {
        GetSetFeedback.ws_id = ws_id;
    }

    public static String getWs_date() {
        return ws_date;
    }

    public static void setWs_date(String ws_date) {
        GetSetFeedback.ws_date = ws_date;
    }

    public static ArrayList<String> getFeedback() {
        return feedback;
    }

    public static void setFeedback(ArrayList<String> feedback) {
        GetSetFeedback.feedback = feedback;
    }

    public static String getVenue() {
        return venue;
    }

    public static void setVenue(String venue) {
        GetSetFeedback.venue = venue;
    }
}
