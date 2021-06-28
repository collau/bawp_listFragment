package com.fishnco.listfragmentsample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.Toast;

import com.fishnco.listfragmentsample.data.Course;
import com.fishnco.listfragmentsample.data.CourseData;

public class CourseDetailActivity extends AppCompatActivity {

    Course course;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_detail);

        if (savedInstanceState == null) {

            Bundle extra = getIntent().getExtras();
            int position = extra.getInt("course_id");
            course = new CourseData().courseList().get(position);

            CourseDetailFragment courseDetailFragment = new CourseDetailFragment();
            courseDetailFragment.setArguments(extra);
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .add(R.id.detailContainer, courseDetailFragment)
                    .commit();
        }
    }
}