package com.fishnco.listfragmentsample.data;

import android.content.Context;

/**
 * Created by junyi on 26/6/21
 */
public class Course {
    private String courseName;
    private String courseImage;

    public Course(String courseName, String courseImage) {
        this.courseName = courseName;
        this.courseImage = courseImage;
    }

    public int getImageResourceId(Context context) {
        return context.getResources().getIdentifier(this.courseImage, "drawable", context.getPackageName());
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseImage() {
        return courseImage;
    }

    public void setCourseImage(String courseImage) {
        this.courseImage = courseImage;
    }
}
