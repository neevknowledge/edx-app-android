package org.edx.mobile.view.data_holder;

/**
 * Created by Sushil on 6/6/2017.
 */

public class ScheduleData {
    static String scheduler_email, b_code, course_URL, uName;
    String batch_code, course, start_date, end_date, ws_date, venue_details, start_time, end_time,
            topic, schedule, fac_info, status, wsdate_id, ws_id, fac_id, name, feedback;

    public static String getuName() {
        return uName;
    }

    public static void setuName(String uName) {
        ScheduleData.uName = uName;
    }

    public static String getCourse_URL() {
        return course_URL;
    }

    public static void setCourse_URL(String course_URL) {
        ScheduleData.course_URL = course_URL;
    }

    public static String getB_code() {
        return b_code;
    }

    public static void setB_code(String b_code) {
        ScheduleData.b_code = b_code;
    }

    public static String getScheduler_email() {
        return scheduler_email;
    }

    public static void setScheduler_email(String scheduler_email) {
        ScheduleData.scheduler_email = scheduler_email;
    }

    public String getBatch_code() {
        return batch_code;
    }

    public void setBatch_code(String batch_code) {
        this.batch_code = batch_code;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getWs_date() {
        return ws_date;
    }

    public void setWs_date(String ws_date) {
        this.ws_date = ws_date;
    }

    public String getVenue_details() {
        return venue_details;
    }

    public void setVenue_details(String venue_details) {
        this.venue_details = venue_details;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getFac_info() {
        return fac_info;
    }

    public void setFac_info(String fac_info) {
        this.fac_info = fac_info;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getWs_id() {
        return ws_id;
    }

    public void setWs_id(String ws_id) {
        this.ws_id = ws_id;
    }

    public String getFac_id() {
        return fac_id;
    }

    public void setFac_id(String fac_id) {
        this.fac_id = fac_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWsdate_id() {
        return wsdate_id;
    }

    public void setWsdate_id(String wsdate_id) {
        this.wsdate_id = wsdate_id;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
