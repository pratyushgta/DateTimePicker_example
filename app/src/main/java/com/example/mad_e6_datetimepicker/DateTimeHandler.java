/**
 * This class contains methods storing selected date & time
 * MAD-E7
 *
 * @author Pratyush Kumar (github.com/pratyushgta)
 */

package com.example.mad_e6_datetimepicker;

public class DateTimeHandler {
    static String date;
    static String time;

    public static String getTime() {
        return time;
    }

    public static void setTime(String t) {
        time = t;
    }

    public static String getDate() {
        return date;
    }

    public static void setDate(String d) {
        date = d;
    }
}
